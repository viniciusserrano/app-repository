package com.br.imobiliaria.endereco.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoResponsePorRuaDto {
    private String uf;
    private String cidade;
    private String zona;
    private String regiao;
    private String bairro;
    private String logradouro;
    private String cep;
    private Boolean ativo;
    private String observacaoRegiao;
    private LocationDto location;
    private EnderecoSemAcentoDto enderecoSemAcento;
}
