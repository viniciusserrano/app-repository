package com.br.imobiliaria.api.imovel.repository;

import com.br.imobiliaria.api.imovel.model.Endereco;
import com.br.imobiliaria.api.imovel.model.ImovelEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ImovelDao extends MongoRepository<ImovelEntity, String>, ImovelCriteriaRepository{

    // Lista todos para podermos inspecionar
    List<ImovelEntity> findAll();

    Optional<ImovelEntity> findByIdImovel(Long idImovel);
    Optional<ImovelEntity> findFirstByIdImovel(Long idImovel);

    long updateEnderecoByIdImovel(Long idImovel, Endereco endereco);

}
