package com.example.mybarbearia.domain.estoque;

public record DadosAtualizaEstoque(
        Long idProduto,
        Integer quantidade,
        AlterarQuantidade alterarQuantidade
) {
}
