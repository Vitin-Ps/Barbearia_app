package com.example.mybarbearia.domain.recibo;

import com.example.mybarbearia.domain.produto.Produto;
import com.example.mybarbearia.domain.servico.Servico;

import java.math.BigDecimal;

public record DadosListagemRecibo(
        Produto produto,
        Servico servico,
        Integer quantidade,
        BigDecimal preco
) {
    public DadosListagemRecibo(Recibo recibo) {
        this(
                recibo.getProduto(),
                recibo.getServico(),
                recibo.getQuantidade(),
                recibo.getPreco()
        );
    }
}
