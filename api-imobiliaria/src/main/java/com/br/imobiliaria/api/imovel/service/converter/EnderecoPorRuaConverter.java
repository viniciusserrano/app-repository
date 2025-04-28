package com.br.imobiliaria.api.imovel.service.converter;

import com.br.imobiliaria.api.imovel.repository.dto.EnderecoPorRuaDto;
import com.br.imobiliaria.api.imovel.repository.entity.Endereco;
import com.br.imobiliaria.api.imovel.repository.entity.Location;
import org.springframework.stereotype.Component;

@Component
public class EnderecoPorRuaConverter {
    public Endereco paraEndereco(EnderecoPorRuaDto dto) {
        Endereco endereco = new Endereco();
        endereco.setUf(dto.getUf());
        endereco.setCidade(dto.getCidade());
        endereco.setBairro(dto.getBairro());
        endereco.setLogradouro(dto.getLogradouro());
        endereco.setCep(dto.getCep());
        return endereco;
    }

    public Location paraLocation(EnderecoPorRuaDto.LocationDto dto) {
        return new Location(
                dto.getType(),
                dto.getCoordinates()
        );
    }
}
