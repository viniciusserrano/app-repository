package com.br.imobiliaria.api.imovel.repository.entity;

import lombok.Data;

@Data
public class EstacaoProxima {
    private String nome;
    private String nomeSemAcento;
    private String linha;
    private String cor;
    private String corSemAcento;
    private String tipo;
    private Integer distancia;
}
