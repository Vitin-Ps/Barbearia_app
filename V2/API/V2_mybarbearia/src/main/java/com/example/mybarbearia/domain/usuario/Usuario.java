package com.example.mybarbearia.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Table(name = "usuario")
@Entity(name = "Usuario")
@Component
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;

    public Usuario(String login, String senhaCodificada, TipoUsuario tipoUsuario) {
        this.login = login;
        this.senha = senhaCodificada;
        this.tipo = tipoUsuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.tipo == TipoUsuario.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        if(this.tipo == TipoUsuario.BARBEIRO) return List.of(new SimpleGrantedAuthority("ROLE_BARBEIRO"), new SimpleGrantedAuthority("ROLE_USER"));
        if(this.tipo == TipoUsuario.ATENDENTE) return List.of(new SimpleGrantedAuthority("ROLE_ATENDENTE"), new SimpleGrantedAuthority("ROLE_USER"));
        if(this.tipo == TipoUsuario.CLIENTE) return List.of(new SimpleGrantedAuthority("ROLE_CLIENTE"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }


    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setSenha(String novaSenhaCodigifcada) {
        this.senha = novaSenhaCodigifcada;
    }
}
