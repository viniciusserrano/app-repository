package com.br.imobiliaria.api.feign;

import com.br.imobiliaria.api.endereco.repository.dto.EnderecoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("api-imobiliaria-endereco")
public interface EnderecoClient {

    @GetMapping("/api/enderecos")
    Page<EnderecoDto> listarEnderecos(@RequestParam int page,
                                      @RequestParam int size);

}
