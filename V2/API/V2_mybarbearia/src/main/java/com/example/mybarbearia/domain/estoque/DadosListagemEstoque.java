package com.example.mybarbearia.domain.estoque;

import com.example.mybarbearia.domain.produto.DadosListagemProduto;

public record DadosListagemEstoque(
        Long idProduto,
        Integer quantidade,
        DadosListagemProduto produto
) {
    public DadosListagemEstoque(Estoque estoque) {
        this(estoque.getProduto().getId(), estoque.getQuantidade(), new DadosListagemProduto(estoque.getProduto()));
    }
}
