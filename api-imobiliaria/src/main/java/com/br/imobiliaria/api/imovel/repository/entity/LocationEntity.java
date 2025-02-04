package com.br.imobiliaria.api.imovel.repository.entity;

import lombok.Data;

import java.util.List;
@Data
public class LocationEntity {
    private String type; // Tipo de localização, ex.: "Point"
    private List<Double> coordinates; // Coordenadas: [longitude, latitude]
}
