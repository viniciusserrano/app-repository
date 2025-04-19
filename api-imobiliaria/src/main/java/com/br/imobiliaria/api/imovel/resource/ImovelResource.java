package com.br.imobiliaria.api.imovel.resource;

import com.br.imobiliaria.api.imovel.repository.dto.ImovelResponseDto;
import com.br.imobiliaria.api.imovel.service.ImovelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imoveis")
public class ImovelResource {

    private final ImovelService imovelService;

    public ImovelResource(ImovelService imovelService) {
        this.imovelService = imovelService;
    }

    @GetMapping
    public ResponseEntity<Page<ImovelResponseDto>> listarTodos(Pageable pageable) {
        Page<ImovelResponseDto> imoveis = imovelService.buscarTodos(pageable);
        return ResponseEntity.ok(imoveis);
    }

}
