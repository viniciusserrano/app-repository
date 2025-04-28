package com.br.imobiliaria.api.imovel.repository.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Dependencia {
    @Field("descricao")
    private String descricao;

    @Field("quantidade")
    private Integer quantidade;

    @Field("dependencia")
    private String dependencia;
}
