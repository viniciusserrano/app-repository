package com.br.imobiliaria.endereco.core.service;

import com.br.imobiliaria.endereco.core.repository.dao.EnderecoDao;
import com.br.imobiliaria.endereco.core.repository.dto.EnderecoResponseDto;
import com.br.imobiliaria.endereco.core.service.converter.EnderecoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    private final EnderecoDao enderecoDao;
    private final EnderecoConverter converter;

    public EnderecoService(EnderecoDao enderecoDao, EnderecoConverter converter) {
        this.enderecoDao = enderecoDao;
        this.converter = converter;
    }

    public Page<EnderecoResponseDto> buscarTodosPaginado(Pageable pageable) {
        return enderecoDao.findAll(pageable)
                .map(converter::paraDto);
    }

}
