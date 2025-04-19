package com.br.imobiliaria.api.mongoconfig;

import org.springframework.core.convert.converter.Converter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ObjectParaLocalDateTimeConverter implements Converter<Object, LocalDateTime>{

    private static final List<DateTimeFormatter> FORMATOS = List.of(
            DateTimeFormatter.ISO_DATE_TIME,
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    );

    @Override
    public LocalDateTime convert(Object source) {
        if (source == null) return null;
        String data = source.toString().trim();

        if (data.equalsIgnoreCase("dados_sensiveis")) return null;

        for (DateTimeFormatter formato : FORMATOS) {
            try {
                return LocalDateTime.parse(data, formato);
            } catch (Exception ignored) {}
        }

        return null;
    }
}
