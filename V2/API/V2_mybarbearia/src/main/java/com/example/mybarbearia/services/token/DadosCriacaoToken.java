package com.example.mybarbearia.services.token;

import jakarta.validation.constraints.NotBlank;

public record DadosCriacaoToken(
        @NotBlank(message = "Login {dados.obrigatório}")
        String login
) {
}
