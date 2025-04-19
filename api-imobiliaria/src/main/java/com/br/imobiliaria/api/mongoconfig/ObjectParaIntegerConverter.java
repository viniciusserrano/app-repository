package com.br.imobiliaria.api.mongoconfig;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ObjectParaIntegerConverter implements Converter<Object, Integer>{

    @Override
    public Integer convert(Object source) {
        if (source == null) return null;

        try {
            if (source instanceof Integer) {
                return (Integer) source;
            }

            if (source instanceof Boolean) {
                return (Boolean) source ? 1 : 0;
            }

            if (source instanceof String) {
                String valor = ((String) source).trim().toLowerCase();

                if (valor.equals("true")) return 1;
                if (valor.equals("false")) return 0;

                // Verifica se é número
                if (valor.matches("-?\\d+")) {
                    return Integer.parseInt(valor);
                }

                // Log se for string inválida
                System.out.printf("❌ Valor inválido para Integer: %s%n", valor);
            }
        } catch (Exception e) {
            System.out.printf("❌ Erro ao converter para Integer: %s%n", source);
        }

        return null;
    }

}
