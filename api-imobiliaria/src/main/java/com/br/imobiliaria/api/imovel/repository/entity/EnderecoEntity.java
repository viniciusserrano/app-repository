package com.br.imobiliaria.api.imovel.repository.entity;

import lombok.Data;

@Data
public class EnderecoEntity {
    private String id; // Identificador único do endereço
    private String uf; // Estado (ex.: SP)
    private String cidade; // Cidade (ex.: São Paulo)
    private String zona; // Zona (ex.: Norte)
    private String regiao; // Região (ex.: Santana)
    private String bairro; // Bairro (ex.: Santana)
    private String logradouro; // Nome da rua (ex.: Rua Marechal Hermes da Fonseca)
    private String cep; // CEP (ex.: 02020000)
    private LocationEntity location; // Localização com tipo e coordenadas
    private String observacaoRegiao; // Observação sobre a região
    private EnderecoSemAcentoEntity enderecoSemAcento; // Endereço sem acentos
}
