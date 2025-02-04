package com.br.imobiliaria.api.imovel.service.converter;

import com.br.imobiliaria.api.imovel.repository.dto.EnderecoDto;
import com.br.imobiliaria.api.imovel.repository.dto.EnderecoSemAcentoDto;
import com.br.imobiliaria.api.imovel.repository.dto.ImovelDto;
import com.br.imobiliaria.api.imovel.repository.dto.LocationDto;
import com.br.imobiliaria.api.imovel.repository.entity.EnderecoEntity;
import com.br.imobiliaria.api.imovel.repository.entity.EnderecoSemAcentoEntity;
import com.br.imobiliaria.api.imovel.repository.entity.ImovelEntity;
import com.br.imobiliaria.api.imovel.repository.entity.LocationEntity;
import org.springframework.stereotype.Component;

@Component

public class ImovelConverter {
    // Converte Entity para Dto
    public ImovelDto toDto(ImovelEntity entity) {
        return new ImovelDto(
                entity.getIdImovel(),
                entity.getDescricaoImovel(),
                entity.getSegmentoVenda(),
                entity.getSegmentoLocacao(),
                entity.getValorVenda(),
                entity.getValorLocacao(),
                entity.getEndereco()
        );
    }

    // Converte Dto para Entity
    public ImovelEntity toEntity(ImovelDto dto) {
        ImovelEntity entity = new ImovelEntity();
        entity.setIdImovel(dto.getIdImovel());
        entity.setDescricaoImovel(dto.getDescricaoImovel());
        entity.setSegmentoVenda(dto.getSegmentoVenda());
        entity.setSegmentoLocacao(dto.getSegmentoLocacao());
        entity.setValorVenda(dto.getValorVenda());
        entity.setValorLocacao(dto.getValorLocacao());
        entity.setEndereco(dto.getEndereco());
        return entity;
    }

    public EnderecoDto toEnderecoDto(EnderecoEntity entity) {
        return new EnderecoDto(
                entity.getId(),
                entity.getUf(),
                entity.getCidade(),
                entity.getZona(),
                entity.getRegiao(),
                entity.getBairro(),
                entity.getLogradouro(),
                entity.getCep(),
                toLocationDto(entity.getLocation()),
                entity.getObservacaoRegiao(),
                toEnderecoSemAcentoDto(entity.getEnderecoSemAcento())
        );
    }

    public EnderecoEntity toEnderecoEntity(EnderecoDto dto) {
        EnderecoEntity entity = new EnderecoEntity();
        entity.setId(dto.getId());
        entity.setUf(dto.getUf());
        entity.setCidade(dto.getCidade());
        entity.setZona(dto.getZona());
        entity.setRegiao(dto.getRegiao());
        entity.setBairro(dto.getBairro());
        entity.setLogradouro(dto.getLogradouro());
        entity.setCep(dto.getCep());
        entity.setLocation(toLocationEntity(dto.getLocation()));
        entity.setObservacaoRegiao(dto.getObservacaoRegiao());
        entity.setEnderecoSemAcento(toEnderecoSemAcentoEntity(dto.getEnderecoSemAcento()));
        return entity;
    }

    public LocationDto toLocationDto(LocationEntity entity) {
        return new LocationDto(entity.getType(), entity.getCoordinates());
    }

    public LocationEntity toLocationEntity(LocationDto dto) {
        LocationEntity entity = new LocationEntity();
        entity.setType(dto.getType());
        entity.setCoordinates(dto.getCoordinates());
        return entity;
    }

    public EnderecoSemAcentoDto toEnderecoSemAcentoDto(EnderecoSemAcentoEntity entity) {
        return new EnderecoSemAcentoDto(
                entity.getLogradouro(),
                entity.getBairro(),
                entity.getRegiao(),
                entity.getCidade()
        );
    }

    public EnderecoSemAcentoEntity toEnderecoSemAcentoEntity(EnderecoSemAcentoDto dto) {
        EnderecoSemAcentoEntity entity = new EnderecoSemAcentoEntity();
        entity.setLogradouro(dto.getLogradouro());
        entity.setBairro(dto.getBairro());
        entity.setRegiao(dto.getRegiao());
        entity.setCidade(dto.getCidade());
        return entity;
    }



}
