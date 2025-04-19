package com.br.imobiliaria.api.imovel.repository.entity;

import lombok.Data;

@Data
public class Complemento {

    private Integer idComplemento;
    private Integer empreendimentoImovel;
    private Integer idEmpreendimentoImovel;
    private String tipoComplemento;
    private String complemento;
    private Double valorComplemento;
    private String descricaoUnidade;
}
