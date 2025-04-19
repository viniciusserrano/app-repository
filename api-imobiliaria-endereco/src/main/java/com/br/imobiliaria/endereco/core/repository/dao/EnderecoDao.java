package com.br.imobiliaria.endereco.core.repository.dao;

import com.br.imobiliaria.endereco.core.repository.entity.EnderecoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnderecoDao extends MongoRepository<EnderecoEntity, String> {
}
