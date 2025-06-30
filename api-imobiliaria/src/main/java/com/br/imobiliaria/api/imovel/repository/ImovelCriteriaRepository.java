package com.br.imobiliaria.api.imovel.repository;

import com.br.imobiliaria.api.imovel.model.Endereco;
import org.springframework.stereotype.Component;

@Component
public interface ImovelCriteriaRepository {

    long updateEnderecoByIdImovel(Long idImovel, Endereco endereco);

}
