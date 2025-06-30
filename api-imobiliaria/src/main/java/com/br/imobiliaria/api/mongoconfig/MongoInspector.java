package com.br.imobiliaria.api.mongoconfig;

import com.br.imobiliaria.api.imovel.model.ImovelEntity;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class MongoInspector implements ApplicationRunner {

    private final MappingMongoConverter converter;
    private final MongoMappingContext context;

    public MongoInspector(MappingMongoConverter converter,
                          MongoMappingContext context) {
        this.converter = converter;
        this.context = context;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // imprime o toString (já mostra o typeKey)
        System.out.println(">> TypeMapper: " + converter.getTypeMapper());

        // reflection para ler o campo privado "typeKey"
        DefaultMongoTypeMapper tm =
                (DefaultMongoTypeMapper) converter.getTypeMapper();
        Field f = DefaultMongoTypeMapper.class.getDeclaredField("typeKey");
        f.setAccessible(true);
        String typeKey = (String) f.get(tm);
        System.out.println(">> Resolved typeKey: " + typeKey);

        // coleção mapeada para ImovelEntity
        System.out.println(">> Entity collection: " +
                context.getPersistentEntity(ImovelEntity.class).getCollection());
    }

}
