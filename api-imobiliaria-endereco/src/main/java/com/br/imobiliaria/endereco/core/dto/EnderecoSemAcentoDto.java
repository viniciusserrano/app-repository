package com.br.imobiliaria.endereco.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoSemAcentoDto {
    private String cidade;
    private String regiao;
    private String bairro;
    private String logradouro;
    private String zona;
}
