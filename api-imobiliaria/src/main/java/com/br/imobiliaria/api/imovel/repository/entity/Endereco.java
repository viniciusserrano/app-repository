package com.br.imobiliaria.api.imovel.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Field("_id")
    private String id;

    @Field("uf")
    private String uf;

    @Field("cidade")
    private String cidade;

    @Field("bairro")
    private String bairro;

    @Field("logradouro")
    private String logradouro;

    @Field("cep")
    private String cep;

    @Field("enderecoSemAcento")
    private EnderecoSemAcento enderecoSemAcento;

    @Field("location")
    private Location location;

    @Data
    @NoArgsConstructor
    public static class EnderecoSemAcento {

        @Field("logradouro")
        private String logradouro;

        @Field("bairro")
        private String bairro;

        @Field("cidade")
        private String cidade;

        @Field("uf")
        private String uf;

        @Field("cep")
        private String cep;
    }

    // Método para sincronizar os campos
    public void syncFields() {
        if (this.enderecoSemAcento == null) {
            this.enderecoSemAcento = new EnderecoSemAcento();
        }
        this.enderecoSemAcento.setLogradouro(this.logradouro);
        this.enderecoSemAcento.setBairro(this.bairro);
        this.enderecoSemAcento.setCidade(this.cidade);
        this.enderecoSemAcento.setUf(this.uf);
        this.enderecoSemAcento.setCep(this.cep);
    }
}