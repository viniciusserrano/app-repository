package com.br.imobiliaria.endereco.overpass.controller;

import com.br.imobiliaria.endereco.overpass.repository.dto.StreetDto;
import com.br.imobiliaria.endereco.overpass.service.OverpassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos/osm")
@RequiredArgsConstructor
public class OverpassController {

    private final OverpassService overpassService;

    /**
     * Exemplo:
     * GET /api/enderecos/osm?regiao=Tatuape
     * retorna lista de { bairro: "Tatuape", logradouro: "Rua Itapura" }
     */
    @GetMapping
    public ResponseEntity<List<StreetDto>> buscarPorRegiao(
            @RequestParam String regiao) {
        List<StreetDto> ruas = overpassService.buscarLogradourosPorRegiao(regiao);
        return ResponseEntity.ok(ruas);
    }
}
