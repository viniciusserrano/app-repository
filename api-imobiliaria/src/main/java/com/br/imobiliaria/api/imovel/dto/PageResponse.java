package com.br.imobiliaria.api.imovel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 * Wrapper genérico para respostas paginadas via Feign.
 * @param <T> tipo dos itens na página
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse<T> {
    private List<T> content;
    private long totalElements;
    private int number;
    private int size;

    /**
     * Cria um PageResponse a partir de um Page do Spring Data.
     */
    public static <U> PageResponse<U> of(org.springframework.data.domain.Page<U> page) {
        return new PageResponse<>(
                page.getContent(),
                page.getTotalElements(),
                page.getNumber(),
                page.getSize()
        );
    }
}
