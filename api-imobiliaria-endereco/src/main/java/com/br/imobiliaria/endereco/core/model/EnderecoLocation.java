package com.br.imobiliaria.endereco.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoLocation {

    private String type;
    private List<Double> coordinates;
}
