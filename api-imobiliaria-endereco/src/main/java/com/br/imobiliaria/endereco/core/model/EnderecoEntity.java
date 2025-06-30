package com.br.imobiliaria.endereco.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "enderecos")
@CompoundIndex(name = "idx_regiao_bairro_logradouro", def = "{'regiao':1,'bairro':1,'logradouro':1}", unique = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoEntity {

    @Id
    private String id;

    private String uf;
    private String cidade;
    private String zona;
    private String regiao;
    private String bairro;
    private String logradouro;
    private String cep;

    private Boolean isAtivo;
    private String observacaoRegiao;

    private EnderecoLocation location;

    @Field("enderecoSemAcento")
    private EnderecoSemAcento enderecoSemAcento;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EnderecoLocation {
        private String type;
        private List<Double> coordinates;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EnderecoSemAcento {
        private String cidade;
        private String regiao;
        private String bairro;
        private String logradouro;
        private String zona;
    }
}
