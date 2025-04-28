package com.br.imobiliaria.api.imovel.repository.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
@Data
public class LocationEntity {
    @Field("type")
    private String type; // Tipo de localização, ex.: "Point"
    @Field("coordinates")
    private List<Double> coordinates; // Coordenadas: [longitude, latitude]
}
