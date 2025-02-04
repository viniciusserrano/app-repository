package com.br.imobiliaria.api.imovel.repository.dto;

import com.br.imobiliaria.api.imovel.repository.entity.EnderecoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImovelDto {
    private String idImovel; // Identificador único do imóvel
    private String descricaoImovel; // Descrição do imóvel
    private Integer segmentoVenda; // 0 ou 1 (indica venda)
    private Integer segmentoLocacao; // 0 ou 1 (indica locação)
    private Double valorVenda; // Valor para venda
    private Double valorLocacao; // Valor para locação
    private EnderecoEntity endereco; // Objeto com os dados do endereço
}
