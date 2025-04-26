package com.br.imobiliaria.api.imovel.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "imoveis")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImovelEntity {
    @Id
    private String id;
    private Integer idImovel;
    private List<Complemento> complementos;
    private List<Dependencia> dependencias;
    private List<EstacaoProxima> estacoesProximas;
    private Endereco endereco;
    private Location location;
    private Integer isAtivo;
    private String tipoImovel;
    private String subTipoImovel;
    private Integer finalidadeResidencial;
    private Integer finalidadeComercial;
    private Double valorVenda;
    private Integer quantidadeDormitorios;
    private Integer quantidadeVagas;
    private Integer quantidadeSuites;
    private Integer quantidadeBanheiros;
    private String descricaoImovel;
    private String enderecoFotoPrincipal;
    private Integer quantidadeFotos;
    private String dataCadastro;
    private Boolean aceitaPet;
    private String tipoImovelSemAcento;
    private String subTipoImovelSemAcento;
    private String demaisDependencias;
    private Double previsaoCondominio;
    private Double previsaoIptu;
    private Integer iptuIsento;
    private String descricaoFilialVenda;
    private Integer dddFilialVenda;
    private Integer valorCampanhaVenda;
    private Integer valorCampanhaLocacao;
    private Boolean temMobilia;
    private Boolean imovelDosSonhosVenda;
    private Boolean imovelDosSonhosLocacao;
    private Integer segmentoVenda;
    private Integer segmentoLocacao;
    private String dataBaixaVenda;
    private String dataBaixaLocacao;
    private String dataAtualizacaoLocacao;
    private String dataAtualizacaoVenda;
    private String nomeCondominio;

    private String dataUltimaAtualizacaoCondominio; // Adicionado
    private String exercicioIptu;                   // Adicionado
    private Map<String, Object> classificacaoVenda;


}
