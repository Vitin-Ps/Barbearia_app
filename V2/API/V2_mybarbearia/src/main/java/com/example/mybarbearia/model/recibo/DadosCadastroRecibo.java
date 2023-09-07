package com.example.mybarbearia.model.recibo;

import com.example.mybarbearia.model.atendimento.Atendimento;
import com.example.mybarbearia.model.produto.Produto;
import com.example.mybarbearia.model.servico.Servico;

import java.math.BigDecimal;

public record DadosCadastroRecibo(

        Produto produto,
        Servico servico,
        Integer quantidade,
        String duracao,
        BigDecimal preco

) {

}
