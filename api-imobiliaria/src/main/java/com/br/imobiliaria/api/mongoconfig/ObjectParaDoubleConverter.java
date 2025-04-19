package com.br.imobiliaria.api.mongoconfig;

import org.springframework.core.convert.converter.Converter;

public class ObjectParaDoubleConverter implements Converter<Object, Double>{

    @Override
    public Double convert(Object source) {
        if (source == null) return null;

        try {
            return Double.valueOf(source.toString().trim().replace(",", "."));
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}
