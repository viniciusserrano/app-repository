package com.br.imobiliaria.api.imovel.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Field("type")
    private String type;
    @Field("coordinates")
    private List<Double> coordinates;
}
