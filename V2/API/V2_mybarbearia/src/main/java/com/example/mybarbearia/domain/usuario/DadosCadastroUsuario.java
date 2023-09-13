package com.example.mybarbearia.domain.usuario;



public record DadosCadastroUsuario(
        DadosAutenticacao dadosAutenticacao,
        String email,
        TipoUsuario tipoUsuario
) {
}
