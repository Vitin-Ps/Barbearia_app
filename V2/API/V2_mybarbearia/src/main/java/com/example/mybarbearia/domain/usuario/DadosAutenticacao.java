package com.example.mybarbearia.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao(
        String login,
        @NotBlank(message = "Senha {dados.obrigatiorio}")
        String senha
) {
}
