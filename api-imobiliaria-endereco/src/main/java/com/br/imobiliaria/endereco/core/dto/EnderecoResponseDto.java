package com.br.imobiliaria.endereco.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoResponseDto {

    /**
     * Identificador do documento no MongoDB
     */
    private String id;

    private String uf;
    private String cidade;
    private String zona;
    private String regiao;
    private String bairro;
    private String logradouro;
    private String cep;

    /**
     * Indica se o endereço está ativo ou não
     */
    private Boolean isAtivo;

    /**
     * Observações específicas sobre a região
     */
    private String observacaoRegiao;

    /**
     * Lista de coordenadas [longitude, latitude]
     * (vem de EnderecoEntity.getLocation().getCoordinates())
     */
    private List<Double> coordenadas;
}
