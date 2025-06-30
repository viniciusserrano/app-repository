package com.br.imobiliaria.endereco.core.service;

import com.br.imobiliaria.endereco.core.repository.EnderecoDao;
import com.br.imobiliaria.endereco.core.dto.EnderecoResponseDto;
import com.br.imobiliaria.endereco.core.dto.EnderecoResponsePorRuaDto;
import com.br.imobiliaria.endereco.core.model.EnderecoEntity;
import com.br.imobiliaria.endereco.core.service.converter.EnderecoConverter;
import com.br.imobiliaria.endereco.core.service.validator.EnderecoValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    private final EnderecoDao enderecoDao;
    private final EnderecoConverter converter;

    private final EnderecoValidator validator;

    public EnderecoService(EnderecoDao enderecoDao, EnderecoConverter converter,
                           EnderecoValidator validator) {
        this.enderecoDao = enderecoDao;
        this.converter = converter;
        this.validator = validator;
    }

    public Page<EnderecoResponseDto> buscarTodosPaginado(Pageable pageable) {
        return enderecoDao.findAll(pageable)
                .map(converter::toDto);
    }

    public Page<EnderecoResponseDto> buscarPorRegiao(String regiao, Pageable pageable) {
        validator.validarRegiaoNaoNulaOuVazia(regiao);
        Page<EnderecoEntity> entidades = enderecoDao.findByRegiao(regiao, pageable);
        return entidades.map(converter::toDto);
    }

    public Page<EnderecoResponsePorRuaDto> buscarPorLogradouro(String logradouro, Pageable pageable) {
        validator.validarLogradouroNaoNuloOuVazio(logradouro);

        Page<EnderecoEntity> entidades = enderecoDao
                .findByLogradouroContainingIgnoreCase(logradouro, pageable);

        List<EnderecoResponsePorRuaDto> dtos = entidades.stream()
                .map(converter::converterParaPorRuaDto)
                .collect(Collectors.toList());

        return new PageImpl<>(dtos, pageable, entidades.getTotalElements());
    }

}
