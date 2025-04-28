package com.br.imobiliaria.api.mongoconfig;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.stereotype.Component;

@Component
public class MongoEventLogger extends AbstractMongoEventListener<Object> {
    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> evt) {
        System.out.println(">>> onBeforeConvert: " + evt.getSource());
    }
    @Override
    public void onBeforeSave(BeforeSaveEvent<Object> evt) {
        System.out.println(">>> onBeforeSave: " + evt.getDocument());
    }
}
