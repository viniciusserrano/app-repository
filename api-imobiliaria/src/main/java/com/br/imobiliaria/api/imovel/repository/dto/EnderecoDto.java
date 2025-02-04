package com.br.imobiliaria.api.imovel.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto {
    private String id; // Identificador único do endereço
    private String uf; // Estado
    private String cidade; // Cidade
    private String zona; // Zona
    private String regiao; // Região
    private String bairro; // Bairro
    private String logradouro; // Logradouro
    private String cep; // CEP
    private LocationDto location; // Localização geográfica
    private String observacaoRegiao; // Observação sobre a região
    private EnderecoSemAcentoDto enderecoSemAcento; // Endereço sem acentos
}
