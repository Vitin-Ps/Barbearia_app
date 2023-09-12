package com.example.mybarbearia.domain.usuario;

import com.example.mybarbearia.infra.exception.ValidacaoExeption;
import com.example.mybarbearia.infra.security.TokenService;
import com.example.mybarbearia.repository.UsuarioRepository;
import com.example.mybarbearia.services.convertdate.DadosAtualizaSenha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TokenService tokenService;
    @Autowired
    AuthenticationManager manager;

    public void AlterarSenha(DadosAtualizaSenha dados) {
        var senhaAntigaCodificada = new BCryptPasswordEncoder().encode(dados.senhaAntiga());
        var usuario = usuarioRepository.getReferenceByLogin(dados.login());
        if(!usuario.getSenha().equals(senhaAntigaCodificada)) throw new ValidacaoExeption("Senha Antiga incorreta!");
        if(!dados.novaSenha().equals(dados.confirmaSenha())) throw new ValidacaoExeption("Senhas não são iguais.");

        var novaSenhaCodificada = new BCryptPasswordEncoder().encode(dados.novaSenha());
        usuario.setSenha(novaSenhaCodificada);
    }
}
