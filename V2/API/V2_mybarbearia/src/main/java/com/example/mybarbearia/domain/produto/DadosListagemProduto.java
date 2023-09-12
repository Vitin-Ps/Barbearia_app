package com.example.mybarbearia.domain.produto;


import java.math.BigDecimal;

public record DadosListagemProduto(
        Long id,
        String nome,
        String descricao,

        BigDecimal preco,

        String marca,

        TipoProduto tipo,

        BigDecimal comissao
) {
    public DadosListagemProduto(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getMarca(), produto.getTipo(), produto.getComissao());
    }
}
