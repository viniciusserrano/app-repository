package com.br.imobiliaria.endereco.overpass.service;

import com.br.imobiliaria.endereco.overpass.repository.dto.OverpassResponse;
import com.br.imobiliaria.endereco.overpass.repository.dto.StreetDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OverpassService {
    private final RestTemplate restTemplate;
    private static final String OVERPASS_URL = "https://overpass-api.de/api/interpreter";
    private static final String NOMINATIM_URL = "https://nominatim.openstreetmap.org/search";

    public List<StreetDto> buscarLogradourosPorRegiao(String regiao) {
        try {
            List<StreetDto> streets = queryOverpassArea(regiao);
            if (!streets.isEmpty()) {
                return streets;
            }
            BoundingBox bbox = fetchBoundingBox(regiao);
            return bbox != null
                    ? queryOverpassBbox(bbox)
                    : List.of();
        } catch (HttpClientErrorException e) {
            // log.warn("Overpass API falhou para '{}', tentando bbox...", regiao, e);
            BoundingBox bbox = fetchBoundingBox(regiao);
            return bbox != null
                    ? queryOverpassBbox(bbox)
                    : List.of();
        }
    }

    private List<StreetDto> queryOverpassArea(String regiao) {
        // 1) monta a query sem regex, combinando vários admin_level
        String ql = """
        [out:json][timeout:25];
        (
          area["boundary"="administrative"]["name"="%1$s"]["admin_level"="8"];
          area["boundary"="administrative"]["name"="%1$s"]["admin_level"="9"];
          area["boundary"="administrative"]["name"="%1$s"]["admin_level"="10"];
          area["boundary"="administrative"]["name"="%1$s"]["admin_level"="11"];
        )->.searchArea;
        way(area.searchArea)["highway"]["name"];
        out tags;
        """.formatted(regiao);

        var form = new LinkedMultiValueMap<String, String>();
        form.add("data", ql);
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("User-Agent", "api-imobiliaria-endereco/1.0");

        OverpassResponse resp = restTemplate.postForObject(
                OVERPASS_URL,
                new HttpEntity<>(form, headers),
                OverpassResponse.class
        );

        return resp.getElements().stream()
                .map(e -> new StreetDto(regiao, e.getTags().getName()))
                .distinct()
                .collect(Collectors.toList());
    }

    private BoundingBox fetchBoundingBox(String regiao) {
        // Chama Nominatim pra encontrar coordenadas do bairro
        var uri = UriComponentsBuilder.fromHttpUrl(NOMINATIM_URL)
                .queryParam("q", regiao + ", São Paulo, BR")
                .queryParam("format", "json")
                .queryParam("limit", 1)
                .build().toUri();

        var results = restTemplate.getForObject(uri, NominatimResult[].class);
        if (results != null && results.length>0) {
            var b = results[0].getBoundingbox();
            return new BoundingBox(
                    Double.parseDouble(b[0]),
                    Double.parseDouble(b[2]),
                    Double.parseDouble(b[1]),
                    Double.parseDouble(b[3])
            );
        }
        return null;
    }

    private List<StreetDto> queryOverpassBbox(BoundingBox box) {
        String ql = """
            [out:json][timeout:25];
            (
              way["highway"]["name"]
                  (%f,%f,%f,%f);
            );
            out tags;
            """.formatted(
                box.minLat, box.minLon,
                box.maxLat, box.maxLon
        );

        var form = new LinkedMultiValueMap<String,String>();
        form.add("data", ql);
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("User-Agent","api-imobiliaria-endereco/1.0");
        var resp = restTemplate.postForObject(
                OVERPASS_URL,
                new HttpEntity<>(form, headers),
                OverpassResponse.class
        );

        return resp.getElements().stream()
                .map(e -> new StreetDto("?", e.getTags().getName()))
                .distinct()
                .collect(Collectors.toList());
    }

    // DTOs auxiliares
    @Data
    static class NominatimResult {
        private String[] boundingbox;
    }
    record BoundingBox(double minLat, double minLon, double maxLat, double maxLon) {}
}
