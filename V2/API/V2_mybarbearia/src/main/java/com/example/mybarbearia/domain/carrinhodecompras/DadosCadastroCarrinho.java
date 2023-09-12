package com.example.mybarbearia.domain.carrinhodecompras;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroCarrinho(
        @NotNull(message = "Id do Cliente {dados.obrigatorio}")
        Long idCliente,
        Long idProduto,
        Long idServico
) {
}
