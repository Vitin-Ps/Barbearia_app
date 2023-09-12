package com.example.mybarbearia.domain.recibo;

import java.math.BigDecimal;

public
record DadosCriacaoRecibo(
        Long idProduto,
        Integer quantidadeProduto,
        Long idCliente,
        Integer quantidadeCliente,
        BigDecimal valorTotal

        ) {
}
