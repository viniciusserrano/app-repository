package com.br.imobiliaria.endereco.core.service;

import com.br.imobiliaria.endereco.core.repository.EnderecoDao;
import com.br.imobiliaria.endereco.core.model.EnderecoEntity;
import com.br.imobiliaria.endereco.overpass.repository.dto.StreetDto;
import com.br.imobiliaria.endereco.overpass.service.OverpassService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;

@Service
public class EnderecoPopulacaoService {

    private final OverpassService overpassService;
    private final EnderecoDao enderecoDao;


    public EnderecoPopulacaoService (OverpassService overpassService, EnderecoDao enderecoDao) {
        this.overpassService = overpassService;
        this.enderecoDao = enderecoDao;
    }

    public Page<EnderecoEntity> popularEPaginar(String regiao, Pageable pageable) {
        // 1) carrega todos os docs da região (com placeholders em bairro/logradouro)
        List<EnderecoEntity> existentes = enderecoDao.findAllByRegiao(regiao);

        // 2) busca as ruas reais no OSM
        List<StreetDto> streets = overpassService.buscarLogradourosPorRegiao(regiao);

        // 3) atualiza somente até onde houver dados em streets
        int count = Math.min(existentes.size(), streets.size());
        for (int i = 0; i < count; i++) {
            EnderecoEntity e = existentes.get(i);
            StreetDto  s = streets.get(i);

            e.setBairro(s.getBairro());
            e.setLogradouro(s.getLogradouro());

            // atualiza também o subdoc sem acento
            var sem = e.getEnderecoSemAcento();
            sem.setBairro(normalize(s.getBairro()));
            sem.setLogradouro(normalize(s.getLogradouro()));

            enderecoDao.save(e);
        }

        // 4) retorna página completa (com todos os docs daquela região, já atualizados onde possível)
        return enderecoDao.findByRegiao(regiao, pageable);
    }

    private String normalize(String in) {
        return Normalizer.normalize(in, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase();
    }
}
