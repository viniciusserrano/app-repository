package com.br.imobiliaria.endereco.core.controller;

import com.br.imobiliaria.endereco.core.repository.dto.EnderecoResponseDto;
import com.br.imobiliaria.endereco.core.repository.dto.PopularEnderecoRequest;
import com.br.imobiliaria.endereco.core.repository.entity.EnderecoEntity;
import com.br.imobiliaria.endereco.core.service.EnderecoPopulacaoService;
import com.br.imobiliaria.endereco.core.service.EnderecoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoResource {
    private final EnderecoService enderecoService;

    private final EnderecoPopulacaoService enderecoPopulacaoService;

    public EnderecoResource(EnderecoService enderecoService, EnderecoPopulacaoService enderecoPopulacaoService) {
        this.enderecoService = enderecoService;
        this.enderecoPopulacaoService = enderecoPopulacaoService;
    }

    @GetMapping
    public ResponseEntity<Page<EnderecoResponseDto>> listarTodos(Pageable pageable) {
        return ResponseEntity.ok(enderecoService.buscarTodosPaginado(pageable));
    }

    @GetMapping("/popular")
    public ResponseEntity<Page<EnderecoEntity>> popular(
            @RequestParam String regiao,
            Pageable pageable) {

        Page<EnderecoEntity> page = enderecoPopulacaoService.popularEPaginar(regiao, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/por-regiao")
    public ResponseEntity<Page<EnderecoResponseDto>> buscarPorRegiao(
            @RequestParam String regiao,
            Pageable pageable) {

        Page<EnderecoResponseDto> page = enderecoService.buscarPorRegiao(regiao, pageable);
        return ResponseEntity.ok(page);
    }

}
