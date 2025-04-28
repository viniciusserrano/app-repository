package com.br.imobiliaria.api.imovel.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "imoveis")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImovelEntity {

    @Id
    @Field("_id")
    private String id;

    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    @Field("idImovel")
    private Long idImovel;

    @Field("complementos")
    private List<Complemento> complementos;

    @Field("dependencias")
    private List<Dependencia> dependencias;

    @Field("empreendimentoProximos")
    private String empreendimentoProximos;

    @Field("idCampanhaVenda")
    private Integer idCampanhaVenda;

    @Field("idCampanhaLocacao")
    private Integer idCampanhaLocacao;

    @Field("tipoImovel")
    private String tipoImovel;

    @Field("tipoImovelSemAcento")
    private String tipoImovelSemAcento;

    @Field("subTipoImovel")
    private String subTipoImovel;

    @Field("endereco")
    private Endereco endereco;

    @Field("subTipoImovelSemAcento")
    private String subTipoImovelSemAcento;

    @Field("finalidadeResidencial")
    private Integer finalidadeResidencial;

    @Field("finalidadeComercial")
    private Integer finalidadeComercial;

    @Field("idComplemento")
    private Integer idComplemento;

    @Field("metragemPrincipal")
    private Double metragemPrincipal;

    @Field("quantidadeDormitorios")
    private Integer quantidadeDormitorios;

    @Field("quantidadeVagas")
    private Integer quantidadeVagas;

    @Field("quantidadeSuites")
    private Integer quantidadeSuites;

    @Field("demaisDependencias")
    private String demaisDependencias;

    @Field("previsaoCondominio")
    private Double previsaoCondominio;

    @Field("previsaoIptu")
    private Double previsaoIptu;

    @Field("exercicioIptu")
    private String exercicioIptu;

    @Field("iptuIsento")
    private Integer iptuIsento;

    @Field("descricaoImovel")
    private String descricaoImovel;

    @Field("segmentoVenda")
    private Integer segmentoVenda;

    @Field("valorLocacao")
    private Double valorLocacao;

    @Field("valorCampanhaVenda")
    private Integer valorCampanhaVenda;

    @Field("segmentoLocacao")
    private Integer segmentoLocacao;

    @Field("valorCampanhaLocacao")
    private Integer valorCampanhaLocacao;

    @Field("enderecoFotoPrincipal")
    private String enderecoFotoPrincipal;

    @Field("quantidadeFotos")
    private Integer quantidadeFotos;

    @Field("temMobilia")
    private Boolean temMobilia;

    @Field("quantidadeBanheiros")
    private Integer quantidadeBanheiros;

    @Field("imovelDosSonhosVenda")
    private Boolean imovelDosSonhosVenda;

    @Field("imovelDosSonhosLocacao")
    private Boolean imovelDosSonhosLocacao;

    @Field("dataCadastro")
    private Date dataCadastro;

    @Field("aceitaPet")
    private Boolean aceitaPet;

    @Field("classificacaoLocacao")
    private Map<String, Object> classificacaoLocacao;

    @Field("fotos")
    private String fotos;

    @Field("filialLocacao")
    private Filial filialLocacao;

    @Field("pontosReferencia")
    private String pontosReferencia;

    @Field("situacao")
    private Integer situacao;

    @Field("tipoEventoBanib")
    private Integer tipoEventoBanib;

    @Field("dtdisponiloc")
    private Date dtdisponiloc;

    @Field("flsdestaqueloc")
    private Integer flsdestaqueloc;

    @Field("flsdestaquevenda")
    private Integer flsdestaquevenda;

    @Field("dataAtualizacaoVenda")
    private String dataAtualizacaoVenda;

    @Field("dataAtualizacaoLocacao")
    private Date dataAtualizacaoLocacao;

    @Field("alugueltranquilo")
    private Integer alugueltranquilo;

    @Field("valorSomaLocacaoCondominio")
    private Double valorSomaLocacaoCondominio;

    @Field("andar")
    private Integer andar;

    @Field("filial")
    private Integer filial;

    @Field("nomeCondominio")
    private String nomeCondominio;

    @Field("empreendimento")
    private Empreendimento empreendimento;

    @Field("dataUltimaAtualizacaoCondominio")
    private String dataUltimaAtualizacaoCondominio;

    @Field("filialVenda")
    private String filialVenda;

//    @Field("endereço")
//    private EnderecoCompleto enderecoCompleto;

    @Data
    @NoArgsConstructor
    public static class Complemento {
        @Field("idComplemento")
        private Integer idComplemento;

        @Field("empreendimentoImovel")
        private Integer empreendimentoImovel;

        @Field("idEmpreendimentoImovel")
        private Integer idEmpreendimentoImovel;

        @Field("tipoComplemento")
        private String tipoComplemento;

        @Field("complemento")
        private String complemento;

        @Field("valorComplemento")
        private Double valorComplemento;

        @Field("descricaoUnidade")
        private String descricaoUnidade;

        @Field("complementoSemAcento")
        private ComplementoSemAcento complementoSemAcento;

        @Data
        @NoArgsConstructor
        public static class ComplementoSemAcento {
            @Field("complemento")
            private String complemento;
        }
    }

    @Data
    @NoArgsConstructor
    public static class Dependencia {
        @Field("descricao")
        private String descricao;

        @Field("quantidade")
        private Integer quantidade;

        @Field("dependencia")
        private String dependencia;
    }

    @Data
    @NoArgsConstructor
    public static class Filial {
        @Field("_id")
        private String id;

        @Field("idFilial")
        private Long idFilial;

        @Field("nome")
        private String nome;


        @Field("endereco")
        private String endereco;

        @Field("telefoneAdministracao")
        private String telefoneAdministracao;

        @Field("emailAdministracao")
        private String emailAdministracao;

        @Field("telefoneLocacao")
        private String telefoneLocacao;

        @Field("emailLocacao")
        private String emailLocacao;

        @Field("telefoneVenda")
        private String telefoneVenda;

        @Field("emailVenda")
        private String emailVenda;

        @Field("telefoneCondominio")
        private String telefoneCondominio;

        @Field("emailCondominio")
        private String emailCondominio;

        @Field("latitude")
        private String latitude;

        @Field("longitude")
        private String longitude;

        @Field("enderecoFoto")
        private String enderecoFoto;

        @Field("ordem")
        private Integer ordem;

        @Field("mostraSiteEmpresa")
        private Integer mostraSiteEmpresa;
    }

    @Data
    @NoArgsConstructor
    public static class Empreendimento {
        @Field("fotos")
        private String fotos;

        @Field("nome")
        private String nome;

        @Field("cep")
        private String cep;

        @Field("endereco")
        private String endereco;

        @Field("latitude")
        private String latitude;

        @Field("longitude")
        private String longitude;

        @Field("observacaoRegiao")
        private String observacaoRegiao;

        @Field("endereço")
        private String enderecoComAcento;
    }

    @Data
    @NoArgsConstructor
    public static class EnderecoCompleto {
        @Field("enderecoSemAcento")
        private EnderecoSemAcento enderecoSemAcento;

        @Data
        @NoArgsConstructor
        public static class EnderecoSemAcento {
            @Field("logradouro")
            private String logradouro;
        }
    }

}