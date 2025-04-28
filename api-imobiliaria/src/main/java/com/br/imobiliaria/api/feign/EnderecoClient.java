package com.br.imobiliaria.api.feign;

import com.br.imobiliaria.api.imovel.repository.dto.EnderecoPorRuaDto;
import com.br.imobiliaria.api.imovel.repository.dto.PageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "api-endereco", url = "${endereco.service.url}")
public interface EnderecoClient {

    @GetMapping("/api/enderecos/por-rua")
    PageResponse<EnderecoPorRuaDto> buscarPorRua(
            @RequestParam("logradouro") String logradouro,
            @RequestParam("page") int page,
            @RequestParam("size") int size
    );

}
