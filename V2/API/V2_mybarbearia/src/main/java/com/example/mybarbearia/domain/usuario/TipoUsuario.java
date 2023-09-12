package com.example.mybarbearia.domain.usuario;

public enum TipoUsuario {
    ADMIN("admin"),
    CLIENTE("cliente"),
    BARBEIRO("barbeiro"),
    ATENDENTE("atendente");

    private String tipoUsuario;

    TipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

}
