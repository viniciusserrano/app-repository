package com.br.imobiliaria.api.imovel.service.validator;

import com.br.imobiliaria.api.imovel.repository.dto.PageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class EnderecoFeignValidator {
    public <T> void validarConteudo(PageResponse<T> pagina) {
        if (pagina == null || pagina.getContent() == null || pagina.getContent().isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Não foi possível encontrar endereço para o logradouro informado."
            );
        }
    }
}
