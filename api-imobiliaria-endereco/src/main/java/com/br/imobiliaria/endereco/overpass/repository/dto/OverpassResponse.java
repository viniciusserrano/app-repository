package com.br.imobiliaria.endereco.overpass.repository.dto;

import lombok.Data;

import java.util.List;

@Data
public class OverpassResponse {
    private List<Element> elements;

    @Data
    public static class Element {
        private Tags tags;
    }

    @Data
    public static class Tags {
        private String name; // nome da rua
    }
}
