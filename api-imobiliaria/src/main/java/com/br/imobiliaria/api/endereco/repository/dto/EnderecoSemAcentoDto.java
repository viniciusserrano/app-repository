package com.br.imobiliaria.api.endereco.repository.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoSemAcentoDto {
    private String cidade;
    private String regiao;
    private String bairro;
    private String logradouro;
    private String zona;
}
