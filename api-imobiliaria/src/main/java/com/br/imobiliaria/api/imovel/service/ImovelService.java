package com.br.imobiliaria.api.imovel.service;

import com.br.imobiliaria.api.imovel.repository.dao.ImovelDao;
import com.br.imobiliaria.api.imovel.repository.dto.ImovelDto;
import com.br.imobiliaria.api.imovel.repository.entity.ImovelEntity;
import com.br.imobiliaria.api.imovel.service.converter.ImovelConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImovelService {

    private final ImovelDao imovelDao;
    private final ImovelConverter imovelConverter;

    // Injeção via construtor
    public ImovelService(ImovelDao imovelDao, ImovelConverter imovelConverter) {
        this.imovelDao = imovelDao;
        this.imovelConverter = imovelConverter;
    }

    public List<ImovelDto> listarImoveisDisponiveis() {
        List<ImovelEntity> entities = imovelDao.findBySegmentoVendaOrSegmentoLocacao(1, 1);
        return entities.stream()
                .map(imovelConverter::toDto)
                .collect(Collectors.toList());
    }

    public ImovelDto salvarImovel(ImovelDto dto) {
        ImovelEntity entity = imovelConverter.toEntity(dto);
        ImovelEntity salvo = imovelDao.save(entity);
        return imovelConverter.toDto(salvo);
    }

    public ImovelDto atualizarImovel(String id, ImovelDto dto) {
        ImovelEntity entity = imovelDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Imóvel não encontrado"));

        // Atualiza os dados
        entity.setDescricaoImovel(dto.getDescricaoImovel());
        entity.setSegmentoVenda(dto.getSegmentoVenda());
        entity.setSegmentoLocacao(dto.getSegmentoLocacao());
        entity.setValorVenda(dto.getValorVenda());
        entity.setValorLocacao(dto.getValorLocacao());
        entity.setEndereco(dto.getEndereco());

        ImovelEntity atualizado = imovelDao.save(entity);
        return imovelConverter.toDto(atualizado);
    }

}
