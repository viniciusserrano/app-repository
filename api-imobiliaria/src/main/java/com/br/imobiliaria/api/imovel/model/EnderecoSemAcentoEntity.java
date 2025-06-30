package com.br.imobiliaria.api.imovel.model;

import lombok.Data;

@Data
public class EnderecoSemAcentoEntity {

    private String logradouro; // Nome da rua sem acentos
    private String bairro;     // Bairro sem acentos
    private String regiao;     // Região sem acentos
    private String cidade;     // Cidade sem acentos
}
