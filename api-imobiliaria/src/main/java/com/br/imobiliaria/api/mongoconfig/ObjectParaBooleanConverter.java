package com.br.imobiliaria.api.mongoconfig;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ObjectParaBooleanConverter implements Converter<Object, Boolean>{

    @Override
    public Boolean convert(Object source) {
        if (source == null) return null;
        String valor = source.toString().trim().toLowerCase();

        return switch (valor) {
            case "1", "true", "sim" -> true;
            case "0", "false", "nao", "não" -> false;
            case "dados_sensiveis" -> null;
            default -> null;
        };
    }
}
