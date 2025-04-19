package com.br.imobiliaria.endereco.core.controller;

import com.br.imobiliaria.endereco.core.repository.dto.EnderecoResponseDto;
import com.br.imobiliaria.endereco.core.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoResource {
    private final EnderecoService enderecoService;

    public EnderecoResource(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<List<EnderecoResponseDto>> listarTodos() {
        return ResponseEntity.ok(enderecoService.buscarTodos());
    }
}
