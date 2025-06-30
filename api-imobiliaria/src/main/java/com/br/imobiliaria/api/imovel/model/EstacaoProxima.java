package com.br.imobiliaria.api.imovel.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class EstacaoProxima {
    @Field("nome")
    private String nome;

    @Field("nomeSemAcento")
    private String nomeSemAcento;

    @Field("linha")
    private String linha;

    @Field("cor")
    private String cor;

    @Field("corSemAcento")
    private String corSemAcento;

    @Field("tipo")
    private String tipo;

    @Field("distancia")
    private Integer distancia;
}
