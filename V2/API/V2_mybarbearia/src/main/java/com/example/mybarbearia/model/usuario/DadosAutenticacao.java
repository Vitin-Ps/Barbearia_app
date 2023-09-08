package com.example.mybarbearia.model.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao(
        @NotBlank(message = "Login {dados.obrigatiorio}")
        String login,
        @NotBlank(message = "Senha {dados.obrigatiorio}")
        String senha
) {
}
