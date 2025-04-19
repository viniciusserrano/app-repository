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
                tratarTexto(entity.getCidade()),
                tratarTexto(entity.getBairro()),
                tratarTexto(entity.getZona()),
                tratarTexto(entity.getRegiao()),
                tratarBoolean(entity.getIsAtivo()),
                tratarCoordenadas(entity.getLocation())
        );
    }

    private String tratarTexto(String valor) {
        return valor != null && valor.equalsIgnoreCase("DADOS_SENSIVEIS") ? null : valor;
    }

    private Boolean tratarBoolean(Boolean valor) {
        return valor != null ? valor : false;
    }

    private List<Double> tratarCoordenadas(EnderecoEntity.EnderecoLocation location) {
        if (location == null || location.getCoordinates() == null) {
            return Collections.emptyList();
        }

        return location.getCoordinates()
                .stream()
                .filter(coord -> coord != null)
                .collect(Collectors.toList());
    }
}
