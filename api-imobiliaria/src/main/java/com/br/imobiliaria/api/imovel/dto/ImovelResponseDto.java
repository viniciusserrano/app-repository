package com.br.imobiliaria.api.imovel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImovelResponseDto {
    private Long idImovel;
    private String tipoImovel;
    private String subTipoImovel;
    private String cidade;
    private String bairro;
    private Double valorVenda;
    private String enderecoFotoPrincipal;
    private Integer quantidadeDormitorios;
    private Integer quantidadeBanheiros;
    private Integer quantidadeSuites;
    private Integer quantidadeVagas;
}
