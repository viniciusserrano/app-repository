package com.br.imobiliaria.endereco.overpass.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StreetDto {
    private String bairro;
    private String logradouro;
}
