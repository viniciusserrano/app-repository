package com.br.imobiliaria.api.imovel.resource;

import com.br.imobiliaria.api.imovel.dto.ImovelResponseDto;
import com.br.imobiliaria.api.imovel.model.ImovelEntity;
import com.br.imobiliaria.api.imovel.service.ImovelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/{idImovel}")
    public ResponseEntity<Optional<ImovelEntity>> buscarPorId(
            @PathVariable("idImovel") Long idImovel  // ⚠️ tem de bater este nome
    ) {
        return ResponseEntity.ok(imovelService.buscarPorId(idImovel));
    }



    @PostMapping("/{idImovel}/associar-endereco")
    public ResponseEntity<Void> associarEndereco(
            @PathVariable Long idImovel,
            @RequestParam(required = false) String logradouro) {
        imovelService.associarEnderecoPorLogradouro(idImovel, logradouro);
        return ResponseEntity.ok().build();
    }

}
