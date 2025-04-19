package com.br.imobiliaria.api.imovel.repository.entity;

import lombok.Data;

@Data
public class Endereco {
    private String id;
    private String uf;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String cep;
}
