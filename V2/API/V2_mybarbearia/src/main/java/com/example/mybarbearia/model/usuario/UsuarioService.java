package com.example.mybarbearia.model.usuario;

import com.example.mybarbearia.infra.exception.ValidacaoExeption;
import com.example.mybarbearia.infra.security.TokenService;
import com.example.mybarbearia.repository.UsuarioRepository;
import com.example.mybarbearia.services.DadosAtualizaSenha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    public String gerarTokenUnico(TipoUsuario tipoUsuario, int usosRestantes) {
        var usuario = usuarioRepository.getReferenceByLoginAndTipo(String.valueOf(tipoUsuario), tipoUsuario);
        System.out.println(usuario);
        var autenticacaoToken = new UsernamePasswordAuthenticationToken(usuario.getLogin(), "2222");
        var autenticacao = manager.authenticate(autenticacaoToken);
        var tokenJWT = tokenService.gerarTokenUnico((Usuario) autenticacao.getPrincipal(), usosRestantes);
        return "?token=" + tokenJWT + "&" + "tipoUsuario=" + tipoUsuario;
    }
}
