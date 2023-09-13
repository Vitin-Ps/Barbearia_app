package com.example.mybarbearia.controller;

import com.example.mybarbearia.domain.usuario.*;
import com.example.mybarbearia.infra.security.DadosTokenJWT;
import com.example.mybarbearia.infra.security.TokenService;
import com.example.mybarbearia.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var autenticacaoToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var autenticacao = manager.authenticate(autenticacaoToken);
        var tokenJWT = tokenService.gerarToken((Usuario) autenticacao.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

    @PostMapping("cadastrar")
    public ResponseEntity CadastrarAdmin(@RequestBody @Valid DadosAutenticacao dados) {
        var senhaCodificada = new BCryptPasswordEncoder().encode(dados.senha());
        var usuario = new Usuario(dados.login(), senhaCodificada, TipoUsuario.ADMIN);
        repository.save(usuario);
        return ResponseEntity.ok("Admin Cadastrado!!!");
    }

    @PostMapping("/recuperar")
    @Transactional
    public ResponseEntity recuperarsenha(@RequestBody @Valid DadosAlteracaoSenha dados) {
        try {
          usuarioService.alterarSenha(dados);

        } catch (Exception ex) {
            throw new RuntimeException("erro:" + ex);
        }
        return ResponseEntity.ok("Senha Alterada");
    }


}
