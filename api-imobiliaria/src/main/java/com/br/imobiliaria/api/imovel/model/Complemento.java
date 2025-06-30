package com.br.imobiliaria.api.imovel.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Complemento {

    @Field("idComplemento")
    private Integer idComplemento;

    @Field("empreendimentoImovel")
    private Integer empreendimentoImovel;

    @Field("idEmpreendimentoImovel")
    private Integer idEmpreendimentoImovel;

    @Field("tipoComplemento")
    private String tipoComplemento;

    @Field("complemento")
    private String complemento;

    @Field("valorComplemento")
    private Double valorComplemento;

    @Field("descricaoUnidade")
    private String descricaoUnidade;

    @Field("complementoSemAcento")
    private ComplementoSemAcento complementoSemAcento;

    @Data
    public static class ComplementoSemAcento {
        @Field("complemento")
        private String complemento;
    }
}