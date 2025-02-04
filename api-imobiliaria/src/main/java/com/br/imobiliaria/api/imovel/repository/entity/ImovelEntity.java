package com.br.imobiliaria.api.imovel.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "imoveis")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImovelEntity {

    @Id
    private String idImovel; // Identificador único do imóvel

    private String descricaoImovel; // Descrição do imóvel
    private Integer segmentoVenda; // 0 ou 1 (indica venda)
    private Integer segmentoLocacao; // 0 ou 1 (indica locação)
    private Double valorVenda; // Valor para venda
    private Double valorLocacao; // Valor para locação

    private EnderecoEntity endereco; // Objeto aninhado
}
