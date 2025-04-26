package com.br.imobiliaria.endereco.core.service.converter;

import com.br.imobiliaria.endereco.core.repository.dto.EnderecoResponseDto;
import com.br.imobiliaria.endereco.core.repository.dto.EnderecoResponsePorRuaDto;
import com.br.imobiliaria.endereco.core.repository.dto.EnderecoSemAcentoDto;
import com.br.imobiliaria.endereco.core.repository.dto.LocationDto;
import com.br.imobiliaria.endereco.core.repository.entity.EnderecoEntity;
import org.springframework.stereotype.Component;

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

    public EnderecoResponsePorRuaDto converterParaPorRuaDto(EnderecoEntity ent) {
        return new EnderecoResponsePorRuaDto(
                ent.getUf(),
                ent.getCidade(),
                ent.getZona(),
                ent.getRegiao(),
                ent.getBairro(),
                ent.getLogradouro(),
                ent.getCep(),
                ent.getIsAtivo(),
                ent.getObservacaoRegiao(),
                criarLocation(ent.getLocation()),
                criarSemAcento(ent.getEnderecoSemAcento())
        );
    }

    private LocationDto criarLocation(EnderecoEntity.EnderecoLocation location) {
        if (location == null) {
            return null;
        }
        return new LocationDto(
                location.getType(),
                location.getCoordinates()
        );
    }

    private EnderecoSemAcentoDto criarSemAcento(EnderecoEntity.EnderecoSemAcento semAcento) {
        if (semAcento == null) {
            return null;
        }
        return new EnderecoSemAcentoDto(
                semAcento.getCidade(),
                semAcento.getRegiao(),
                semAcento.getBairro(),
                semAcento.getLogradouro(),
                semAcento.getZona()
        );
    }

}
