package com.br.imobiliaria.api.mongoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.List;

@Configuration
public class MongoConfig {

    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(List.of(
                new ObjectParaBooleanConverter(),
                new ObjectParaIntegerConverter(),
                new ObjectParaDoubleConverter(),
                new ObjectParaLocalDateTimeConverter()
        ));
    }

}
