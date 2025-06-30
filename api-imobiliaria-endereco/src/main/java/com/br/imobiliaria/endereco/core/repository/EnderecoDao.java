package com.br.imobiliaria.endereco.core.repository;

import com.br.imobiliaria.endereco.core.model.EnderecoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EnderecoDao extends MongoRepository<EnderecoEntity, String> {
    // usado para pegar o template (único) daquela região
    Optional<EnderecoEntity>findFirstByRegiao(String regiao);

    // para checar duplicatas ao salvar
    Optional<EnderecoEntity> findByRegiaoAndBairroAndLogradouro(
            String regiao, String bairro, String logradouro);

    Page<EnderecoEntity>findByRegiao(String regiao, Pageable pageable);

    List<EnderecoEntity> findAllByRegiao(String regiao);

    Page<EnderecoEntity> findByLogradouroContainingIgnoreCase(String logradouro, Pageable pageable);
    Page<EnderecoEntity> findByRegiaoContainingIgnoreCase(String regiao, Pageable pageable);
}
