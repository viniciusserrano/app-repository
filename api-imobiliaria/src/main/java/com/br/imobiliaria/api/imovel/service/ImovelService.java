package com.br.imobiliaria.api.imovel.service;

import com.br.imobiliaria.api.imovel.repository.dao.ImovelDao;
import com.br.imobiliaria.api.imovel.repository.dto.ImovelResponseDto;
import com.br.imobiliaria.api.imovel.service.converter.ImovelConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ImovelService {
    private final ImovelDao imovelDao;
    private final ImovelConverter imovelConverter;

    public ImovelService(ImovelDao imovelDao, ImovelConverter imovelConverter) {
        this.imovelDao = imovelDao;
        this.imovelConverter = imovelConverter;
    }

    public Page<ImovelResponseDto> buscarTodos(Pageable pageable) {
        return imovelDao.findAll(pageable)
                .map(imovelConverter::paraDto);
    }


}
