package com.br.imobiliaria.api.imovel.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoSemAcentoDto {
    private String logradouro; // Nome da rua sem acentos
    private String bairro;     // Bairro sem acentos
    private String regiao;     // Região sem acentos
    private String cidade;     // Cidade sem acentos
}
