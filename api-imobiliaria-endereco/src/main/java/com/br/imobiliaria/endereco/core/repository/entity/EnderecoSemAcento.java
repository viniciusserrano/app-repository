package com.br.imobiliaria.endereco.core.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoSemAcento {
    private String cidade;
    private String regiao;
    private String bairro;
    private String logradouro;
    private String zona;
}
