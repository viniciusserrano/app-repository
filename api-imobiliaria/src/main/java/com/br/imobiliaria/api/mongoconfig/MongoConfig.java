package com.br.imobiliaria.api.mongoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.*;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MongoConfig {

    private final List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();

    @Bean
    public MongoCustomConversions mongoCustomConversions() {

        converters.add(new ZonedDateTimeReadConverter());
        converters.add(new ZonedDateTimeWriteConverter());
        // seus conversores já existentes
        return new MongoCustomConversions(List.of(
                new ObjectParaBooleanConverter(),
                new ObjectParaIntegerConverter(),
                new ObjectParaDoubleConverter(),
                new ObjectParaLocalDateTimeConverter()
        ));
    }

    @Bean
    public MappingMongoConverter mappingMongoConverter(
            MongoDatabaseFactory databaseFactory,
            MongoMappingContext mappingContext) {

        DbRefResolver dbRefResolver = new DefaultDbRefResolver(databaseFactory);
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mappingContext);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null)); // Remove _class
        return converter;
    }

}
