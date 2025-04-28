package com.br.imobiliaria.api.imovel.service.converter;

import com.br.imobiliaria.api.imovel.repository.dto.ImovelResponseDto;
import com.br.imobiliaria.api.imovel.repository.entity.ImovelEntity;
import org.springframework.stereotype.Component;

@Component

public class ImovelConverter {
    public ImovelResponseDto paraDto(ImovelEntity entity) {
        String cidade = null;
        String bairro = null;

        return new ImovelResponseDto(
                entity.getIdImovel(),
                entity.getTipoImovel(),
                entity.getSubTipoImovel(),
                cidade,
                bairro,
                entity.getValorLocacao(),
                entity.getEnderecoFotoPrincipal(),
                entity.getQuantidadeDormitorios(),
                entity.getQuantidadeBanheiros(),
                entity.getQuantidadeSuites(),
                entity.getQuantidadeVagas()
        );
    }

}
