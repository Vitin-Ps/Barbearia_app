package com.example.mybarbearia.domain.produto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosAtualizaProduto(
        @NotNull
        Long id,
        String nome,
        String descricao,
        String marca,
        TipoProduto tipo,
        BigDecimal preco,
        BigDecimal comissao
) {

}
