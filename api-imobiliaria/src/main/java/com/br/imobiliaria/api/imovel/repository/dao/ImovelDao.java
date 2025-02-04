package com.br.imobiliaria.api.imovel.repository.dao;

import com.br.imobiliaria.api.imovel.repository.entity.ImovelEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ImovelDao extends MongoRepository<ImovelEntity, String> {
    List<ImovelEntity> findBySegmentoVendaOrSegmentoLocacao(Integer segmentoVenda, Integer segmentoLocacao);
}
