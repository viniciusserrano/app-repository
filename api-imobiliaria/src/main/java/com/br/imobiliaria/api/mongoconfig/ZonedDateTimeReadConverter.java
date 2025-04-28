package com.br.imobiliaria.api.mongoconfig;

import org.springframework.core.convert.converter.Converter;

import java.time.ZonedDateTime;
import java.util.Date;

import static java.time.ZoneId.systemDefault;

public class ZonedDateTimeReadConverter implements Converter<Date, ZonedDateTime> {
    @Override
    public ZonedDateTime convert(Date date) {
        return date.toInstant().atZone(systemDefault());
    }
}
