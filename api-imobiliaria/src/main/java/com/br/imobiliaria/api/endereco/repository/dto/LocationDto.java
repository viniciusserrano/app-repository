package com.br.imobiliaria.api.endereco.repository.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDto {
    private String type;
    private List<Double> coordinates;  // [ longitude, latitude ]
}
