package com.br.imobiliaria.api.imovel.repository.dao;

import com.br.imobiliaria.api.imovel.repository.entity.Endereco;
import org.springframework.stereotype.Component;

@Component
public interface ImovelCriteriaRepository {

    long updateEnderecoByIdImovel(Long idImovel, Endereco endereco);

}
