package com.br.imobiliaria.api.mongoconfig;

import org.springframework.core.convert.converter.Converter;

import java.time.ZonedDateTime;
import java.util.Date;

public class ZonedDateTimeWriteConverter implements Converter<ZonedDateTime, Date> {
    @Override
    public Date convert(ZonedDateTime zonedDateTime) {
        return Date.from(zonedDateTime.toInstant());
    }

    @Override
    public <U> Converter<ZonedDateTime, U> andThen(Converter<? super Date, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
