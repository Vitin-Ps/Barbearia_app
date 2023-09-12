package com.example.mybarbearia.domain.recibo;

import com.example.mybarbearia.domain.produto.Produto;
import com.example.mybarbearia.domain.servico.Servico;

import java.math.BigDecimal;

public record DadosCadastroRecibo(

        Produto produto,
        Servico servico,
        Integer quantidade,
        String duracao,
        BigDecimal preco

) {

}
