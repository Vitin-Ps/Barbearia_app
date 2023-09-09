package com.example.mybarbearia.model.funcionario;

import com.example.mybarbearia.model.usuario.TipoUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosValidaFuncionario(
        @NotNull(message = "Tipo de usuario {dados.obrigatiorio}")
        TipoUsuario tipoUsuario
) {
}
