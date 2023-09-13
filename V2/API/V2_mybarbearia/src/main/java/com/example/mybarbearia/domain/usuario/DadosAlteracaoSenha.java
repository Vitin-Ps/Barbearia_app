package com.example.mybarbearia.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosAlteracaoSenha(
        @NotBlank
        String novaSenha,
        @NotBlank
        String confirmaSenha,
        @NotBlank
        String rawToken
) {
}
