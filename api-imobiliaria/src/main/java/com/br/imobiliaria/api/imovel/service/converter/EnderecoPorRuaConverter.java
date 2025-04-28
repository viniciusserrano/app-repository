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
        endereco.setLocation(paraLocation(dto.getLocation()));

        // *** Mapeando o enderecoSemAcento ***
        Endereco.EnderecoSemAcento sem = new Endereco.EnderecoSemAcento();
        sem.setLogradouro(dto.getEnderecoSemAcento().getLogradouro());
        sem.setBairro(dto.getEnderecoSemAcento().getBairro());
        sem.setCidade(dto.getEnderecoSemAcento().getCidade());
        sem.setUf(dto.getEnderecoSemAcento().getZona());
        sem.setCep(dto.getCep());
        endereco.setEnderecoSemAcento(sem);

        return endereco;
    }

    public Location paraLocation(EnderecoPorRuaDto.LocationDto dto) {
        return new Location(
                dto.getType(),
                dto.getCoordinates()
        );
    }
}
