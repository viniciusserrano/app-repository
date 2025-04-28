package com.br.imobiliaria.api.mongoconfig;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.stereotype.Component;

@Component
public class MongoStartupDebug implements ApplicationRunner {

    private final MappingMongoConverter converter;
    public MongoStartupDebug(MappingMongoConverter converter) {
        this.converter = converter;
    }
    @Override
    public void run(ApplicationArguments args) {
        System.out.println(">>> MONGO CONVERTER: " + converter);
        System.out.println(">>> TYPE MAPPER:     " + converter.getTypeMapper());
    }
}
