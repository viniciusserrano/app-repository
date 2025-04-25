package com.br.imobiliaria.endereco.core.service.validator;

import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class EnderecoValidator {
    public void validarRegiaoNaoNulaOuVazia(String regiao) {
        if (StringUtils.isBlank(regiao)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Parâmetro 'regiao' é obrigatório e não pode estar em branco."
            );
        }
    }
}
