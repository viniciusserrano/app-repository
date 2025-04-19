package com.br.imobiliaria.endereco.core.service.converter;

import com.br.imobiliaria.endereco.core.repository.dto.EnderecoResponseDto;
import com.br.imobiliaria.endereco.core.repository.entity.EnderecoEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EnderecoConverter {

    public EnderecoResponseDto paraDto(EnderecoEntity entity) {
        return new EnderecoResponseDto(
                entity.getCidade(),
                entity.getBairro(),
                entity.getZona(),
                entity.getRegiao(),
                entity.getIsAtivo(),
                entity.getLocation() != null ? entity.getLocation().getCoordinates() : null
        );
    }
}
