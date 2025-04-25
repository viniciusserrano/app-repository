package com.br.imobiliaria.api.endereco.repository.dto;

import com.br.imobiliaria.api.imovel.repository.dto.LocationDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoDto {

    /** Mapeia o _id do Mongo */
    @JsonProperty("_id")
    private String id;

    private String uf;
    private String cidade;
    private String zona;
    private String regiao;
    private String bairro;
    private String logradouro;
    private String cep;

    /** Supondo que seja um GeoJSON Point */
    private LocationDto location;

    /** Mapeia o field "isAtivo" */
    @JsonProperty("isAtivo")
    private boolean ativo;

    private String observacaoRegiao;

    /** Objeto aninhado com os campos sem acento */
    private EnderecoSemAcentoDto enderecoSemAcento;
}
