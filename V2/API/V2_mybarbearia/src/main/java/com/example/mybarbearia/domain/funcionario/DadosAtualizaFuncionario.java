package com.example.mybarbearia.domain.funcionario;

public record DadosAtualizaFuncionario(
        Long id,
        String nome,
        String email,
        String telefone,
        Cargo cargo,
        Integer porcentagemComissao
) {
}
