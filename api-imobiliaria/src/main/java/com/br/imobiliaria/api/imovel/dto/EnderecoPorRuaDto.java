package com.br.imobiliaria.api.imovel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoPorRuaDto {
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

    @Data
    @AllArgsConstructor
    public static class LocationDto {
        private String type;
        private List<Double> coordinates;
    }

    @Data
    @AllArgsConstructor
    public static class EnderecoSemAcentoDto {
        private String cidade;
        private String regiao;
        private String bairro;
        private String logradouro;
        private String zona;
    }
}
