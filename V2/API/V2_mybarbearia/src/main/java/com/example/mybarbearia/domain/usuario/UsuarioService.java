package com.example.mybarbearia.domain.usuario;

import com.example.mybarbearia.infra.exception.ValidacaoExeption;
import com.example.mybarbearia.repository.UsuarioRepository;
import com.example.mybarbearia.services.token.TokenTransparenteService;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private TokenTransparenteService tokenTransparenteService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @SneakyThrows
    public void alterarSenha(DadosAlteracaoSenha dados) {
        var publicData = tokenTransparenteService.readPublicData(dados.rawToken());

        if(tokenTransparenteService.tempoExpirado(publicData)) throw new ValidacaoExeption("Token Expirado");

        var usuario = usuarioRepository.getReferenceByLogin(publicData.login());
        if(usuario == null) throw new ValidacaoExeption("Usuario não encontrado");

        var tokenService = tokenTransparenteService.getInstanceFor(usuario);
        tokenService.verifyToken(dados.rawToken());
        if(!dados.novaSenha().equals(dados.confirmaSenha())) throw new ValidacaoExeption("Senhas não são iguais.");
        var novaSenhaCodificada = new BCryptPasswordEncoder().encode(dados.novaSenha());
        usuario.setSenha(novaSenhaCodificada);
        usuarioRepository.save(usuario);
    }

    public void cadastroUsuario(DadosCadastroUsuario dados) {
        String login;
        var senhaCodificada = new BCryptPasswordEncoder().encode(dados.dadosAutenticacao().senha());
        if(dados.dadosAutenticacao().login() == null) login = dados.email();
        else login = dados.dadosAutenticacao().login();
        var usuario = new Usuario(login, senhaCodificada, dados.tipoUsuario());
        usuarioRepository.save(usuario);
    }
}