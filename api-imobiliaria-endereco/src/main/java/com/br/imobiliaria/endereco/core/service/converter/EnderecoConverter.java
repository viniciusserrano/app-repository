package com.br.imobiliaria.endereco.core.service.converter;

import com.br.imobiliaria.endereco.core.repository.dto.EnderecoResponseDto;
import com.br.imobiliaria.endereco.core.repository.entity.EnderecoEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EnderecoConverter {

    public EnderecoResponseDto toDto(EnderecoEntity e) {
        return EnderecoResponseDto.builder()
                .id(e.getId())
                .uf(e.getUf())
                .cidade(e.getCidade())
                .zona(e.getZona())
                .regiao(e.getRegiao())
                .bairro(e.getBairro())
                .logradouro(e.getLogradouro())
                .cep(e.getCep())
                .isAtivo(e.getIsAtivo())
                .observacaoRegiao(e.getObservacaoRegiao())
                .coordenadas(e.getLocation().getCoordinates())
                .build();
    }

}
