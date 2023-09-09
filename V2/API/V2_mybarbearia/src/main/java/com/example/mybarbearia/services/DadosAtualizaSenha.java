package com.example.mybarbearia.services;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaSenha(
        @NotBlank(message = "Login {dados.obrigatorio}")
        String login,
        @NotBlank(message = "Senha Antiga {dados.obrigatorio}")
        String senhaAntiga,
        @NotBlank(message = "Digite a Nova senha")
        String novaSenha,
        @NotBlank(message = "Repita a Nova Senha")
        String confirmaSenha
) {
}
