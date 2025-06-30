package com.br.imobiliaria.api.imovel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {
    private String type; // Tipo de localização, ex.: "Point"
    private List<Double> coordinates; // Coordenadas: [longitude, latitude]
}
