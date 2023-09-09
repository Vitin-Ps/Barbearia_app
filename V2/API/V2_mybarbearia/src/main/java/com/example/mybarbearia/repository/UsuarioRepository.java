package com.example.mybarbearia.repository;

import com.example.mybarbearia.model.usuario.TipoUsuario;
import com.example.mybarbearia.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String username);

    boolean findBySenha(String senhaAntigaCodificada);

    Usuario getReferenceByLogin(String login);

    Usuario getReferenceByLoginAndTipo(String user, TipoUsuario tipoUsuario);
}
