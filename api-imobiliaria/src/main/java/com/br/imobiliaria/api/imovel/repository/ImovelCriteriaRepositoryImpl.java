package com.br.imobiliaria.api.imovel.repository;

import com.br.imobiliaria.api.imovel.model.Endereco;
import com.br.imobiliaria.api.imovel.model.ImovelEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class ImovelCriteriaRepositoryImpl implements ImovelCriteriaRepository {
    private final MongoTemplate mongoTemplate;

    public ImovelCriteriaRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public long updateEnderecoByIdImovel(Long idImovel, Endereco endereco) {
        Query filtro = Query.query(Criteria.where("idImovel").is(idImovel));
        Update atualizacao = new Update().set("endereco", endereco);
        var result = mongoTemplate.updateFirst(filtro, atualizacao, ImovelEntity.class);
        return result.getMatchedCount();
    }
}
