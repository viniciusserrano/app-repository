package com.br.imobiliaria.endereco.core.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoResponseDto {

    private String cidade;
    private String bairro;
    private String zona;
    private String regiao;
    private Boolean isAtivo;
    private List<Double> coordenadas;
}
