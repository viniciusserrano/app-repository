package com.br.imobiliaria.api.imovel.service.converter;

import com.br.imobiliaria.api.imovel.repository.dto.ImovelResponseDto;
import com.br.imobiliaria.api.imovel.repository.entity.ImovelEntity;
import org.springframework.stereotype.Component;

@Component

public class ImovelConverter {
    public ImovelResponseDto paraDto(ImovelEntity entity) {
        String cidade = entity.getEndereco() != null ? entity.getEndereco().getCidade() : null;
        String bairro = entity.getEndereco() != null ? entity.getEndereco().getBairro() : null;

        return new ImovelResponseDto(
                entity.getIdImovel(),
                entity.getTipoImovel(),
                entity.getSubTipoImovel(),
                cidade,
                bairro,
                entity.getValorVenda(),
                entity.getEnderecoFotoPrincipal(),
                entity.getQuantidadeDormitorios(),
                entity.getQuantidadeBanheiros(),
                entity.getQuantidadeSuites(),
                entity.getQuantidadeVagas()
        );
    }

}
