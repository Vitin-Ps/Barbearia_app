package com.example.mybarbearia.controller;

import com.example.mybarbearia.infra.security.DadosTokenJWT;
import com.example.mybarbearia.infra.security.TokenService;
import com.example.mybarbearia.model.usuario.DadosAutenticacao;
import com.example.mybarbearia.model.usuario.TipoUsuario;
import com.example.mybarbearia.model.usuario.Usuario;
import com.example.mybarbearia.repository.UsuarioRepository;
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


    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var autenticacaoToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var autenticacao = manager.authenticate(autenticacaoToken);
        var tokenJWT = tokenService.gerarToken((Usuario) autenticacao.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

    @PostMapping("cadCliente")
        public ResponseEntity cadastrarCliente(@RequestBody @Valid DadosAutenticacao dados) {
            var senhaCodificada = new BCryptPasswordEncoder().encode(dados.senha());
            var usuario = new Usuario(dados.login(), senhaCodificada, TipoUsuario.CLIENTE);
            repository.save(usuario);
            return ResponseEntity.ok("Cliente Cadastrado!!!");
        }

    @PostMapping("cadFuncionario")
    public ResponseEntity cadastrarFuncionario(@RequestBody @Valid DadosAutenticacao dados) {
        var senhaCodificada = new BCryptPasswordEncoder().encode(dados.senha());
        var usuario = new Usuario(dados.login(), senhaCodificada, TipoUsuario.BARBEIRO);
        repository.save(usuario);
        return ResponseEntity.ok("Barbeiro Cadastrado!!!");
    }

    @PostMapping("cadAdmin")
    public ResponseEntity CadastrarAdmin(@RequestBody @Valid DadosAutenticacao dados) {
        var senhaCodificada = new BCryptPasswordEncoder().encode(dados.senha());
        var usuario = new Usuario(dados.login(), senhaCodificada, TipoUsuario.ADMIN);
        repository.save(usuario);
        return ResponseEntity.ok("Admin Cadastrado!!!");
    }

}
