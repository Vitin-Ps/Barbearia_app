package com.example.mybarbearia.model.usuario;

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
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        if (this.tipo == TipoUsuario.ADMIN) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else if (this.tipo == TipoUsuario.CLIENTE) {
            authorities.add(new SimpleGrantedAuthority("ROLE_CLIENTE"));
        } else if (this.tipo == TipoUsuario.BARBEIRO) {
            authorities.add(new SimpleGrantedAuthority("ROLE_BARBEIRO"));
        } else if (this.tipo == TipoUsuario.ATENDENTE) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ATENDENTE"));
        }

        return authorities;
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
}
