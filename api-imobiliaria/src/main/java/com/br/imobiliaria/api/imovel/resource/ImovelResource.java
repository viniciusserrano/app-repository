package com.br.imobiliaria.api.imovel.resource;

import com.br.imobiliaria.api.imovel.repository.dto.ImovelDto;
import com.br.imobiliaria.api.imovel.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imoveis")
public class ImovelResource {

    private final ImovelService imovelService;

    // Injeção via construtor
    public ImovelResource(ImovelService imovelService) {
        this.imovelService = imovelService;
    }

    @GetMapping
    public ResponseEntity<List<ImovelDto>> listarImoveis() {
        return ResponseEntity.ok(imovelService.listarImoveisDisponiveis());
    }

    @PostMapping
    public ResponseEntity<ImovelDto> salvarImovel(@RequestBody ImovelDto dto) {
        return ResponseEntity.ok(imovelService.salvarImovel(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImovelDto> atualizarImovel(@PathVariable String id, @RequestBody ImovelDto dto) {
        return ResponseEntity.ok(imovelService.atualizarImovel(id, dto));
    }
}
