package com.br.imobiliaria.endereco.core.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {
    private String type;
    private List<Double> coordinates;
}
