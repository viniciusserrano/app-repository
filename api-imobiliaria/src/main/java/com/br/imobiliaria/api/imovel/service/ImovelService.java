package com.br.imobiliaria.api.imovel.service;

import com.br.imobiliaria.api.feign.EnderecoClient;
import com.br.imobiliaria.api.imovel.repository.dao.ImovelDao;
import com.br.imobiliaria.api.imovel.repository.dto.EnderecoPorRuaDto;
import com.br.imobiliaria.api.imovel.repository.dto.ImovelResponseDto;
import com.br.imobiliaria.api.imovel.repository.dto.PageResponse;
import com.br.imobiliaria.api.imovel.repository.entity.Endereco;
import com.br.imobiliaria.api.imovel.repository.entity.ImovelEntity;
import com.br.imobiliaria.api.imovel.service.converter.EnderecoPorRuaConverter;
import com.br.imobiliaria.api.imovel.service.converter.ImovelConverter;
import com.br.imobiliaria.api.imovel.service.validator.EnderecoFeignValidator;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImovelService {
    private final ImovelDao imovelDao;
    private final ImovelConverter imovelConverter;
    private final EnderecoClient enderecoClient;
    private final EnderecoFeignValidator enderecoFeignValidator;
    private final EnderecoPorRuaConverter enderecoPorRuaConverter;
//    private final ImovelCriteriaRepository imovelCriteria;

    private final MeterRegistry meterRegistry;

    private final MongoTemplate mongoTemplate;

    public ImovelService(ImovelDao imovelDao, ImovelConverter imovelConverter,
                         EnderecoClient enderecoClient, EnderecoFeignValidator enderecoFeignValidator,
                         EnderecoPorRuaConverter enderecoPorRuaConverter,
                         MongoTemplate mongoTemplate, MeterRegistry meterRegistry) {
        this.imovelDao = imovelDao;
        this.imovelConverter = imovelConverter;
        this.enderecoClient = enderecoClient;
        this.enderecoFeignValidator = enderecoFeignValidator;
        this.enderecoPorRuaConverter = enderecoPorRuaConverter;
//        this.imovelCriteria = imovelCriteria;
        this.mongoTemplate = mongoTemplate;
        this.meterRegistry = meterRegistry;
    }

    public Page<ImovelResponseDto> buscarTodos(Pageable pageable) {
        return imovelDao.findAll(pageable)
                .map(imovelConverter::paraDto);
    }

    public Optional<ImovelEntity> buscarPorId(Long idImovel) {
        return imovelDao.findByIdImovel(idImovel);
    }

    public void testarBuscarTodos() {
        List<ImovelEntity> todos = imovelDao.findAll();
        for (ImovelEntity imovel : todos) {
            System.out.println("IDIMOVEL encontrado: " + imovel.getIdImovel());
        }
    }


    public void associarEnderecoPorLogradouro(Long idImovel, String logradouro) {
        // Inicia amostragem do timer
        Timer.Sample sample = Timer.start(meterRegistry);

        // 1. Busca o DTO de endereço via Feign
        PageResponse<EnderecoPorRuaDto> resposta =
                enderecoClient.buscarPorRua(logradouro, 0, 1);

        // Para o timer, nome da métrica e tags
        sample.stop(meterRegistry.timer(
                "imobiliaria.feign.buscarPorRua.seconds",           // nome da métrica
                "client", "api-endereco",                          // tag client
                "method", "buscarPorRua"                           // tag method
        ));

        enderecoFeignValidator.validarConteudo(resposta);
        EnderecoPorRuaDto dto = resposta.getContent().get(0);

        Endereco endereco = enderecoPorRuaConverter.paraEndereco(dto);
        long matched = imovelDao.updateEnderecoByIdImovel(idImovel, endereco);
        if (matched == 0) {
            throw new RuntimeException("Não existe imóvel com idImovel=" + idImovel);
        }
        System.out.println(
                ">>> Endereço associado via ImovelDao.updateEnderecoByIdImovel para idImovel=" + idImovel);
    }



}
