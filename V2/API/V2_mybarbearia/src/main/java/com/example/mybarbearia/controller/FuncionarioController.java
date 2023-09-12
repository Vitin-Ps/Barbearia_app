package com.example.mybarbearia.controller;

import com.example.mybarbearia.domain.funcionario.*;
import com.example.mybarbearia.domain.funcionario.validacao.ValidaCadastroFuncionario;
import com.example.mybarbearia.domain.usuario.TipoUsuario;
import com.example.mybarbearia.domain.usuario.Usuario;
import com.example.mybarbearia.repository.FuncionarioRepository;
import com.example.mybarbearia.repository.UsuarioRepository;
import com.example.mybarbearia.services.token.TokenTransparenteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TokenTransparenteService tokenTransparenteService;
    @Autowired
    private List<ValidaCadastroFuncionario> validadorCadastro;


    @PostMapping("cadBarbeiro")
    @Transactional
    public ResponseEntity cadastrarBarbeiro(@RequestBody @Valid DadosCadastroFuncionario dados, UriComponentsBuilder componentsBuilder) {
        try {
            validadorCadastro.forEach(v -> v.valida(dados));
            tokenTransparenteService.validaToken(dados.rawToken());
            var funcionario = new Funcionario(dados, Cargo.BARBEIRO);
            funcionarioRepository.save(funcionario);
            String login;
            var senhaCodificada = new BCryptPasswordEncoder().encode(dados.dadosAutenticacao().senha());
            if(dados.dadosAutenticacao().login() == null) login = dados.email();
            else login = dados.dadosAutenticacao().login();
            var usuario = new Usuario(login, senhaCodificada, TipoUsuario.BARBEIRO);
            usuarioRepository.save(usuario);
            var uri = componentsBuilder.path("/funcionario/{id}").buildAndExpand(funcionario.getId()).toUri();
            return ResponseEntity.created(uri).body(new DadosListagemFuncionario(funcionario));
        } catch (Exception ex) {
            throw  new RuntimeException("Erro ao checar Token: " + ex);
        }
    }

    @PostMapping("cadAtendente")
    @Transactional
    public ResponseEntity cadastrarAtendente(@RequestBody @Valid DadosCadastroFuncionario dados, UriComponentsBuilder componentsBuilder) {
        try {
            validadorCadastro.forEach(v -> v.valida(dados));
            tokenTransparenteService.validaToken(dados.rawToken());
            var funcionario = new Funcionario(dados, Cargo.ATENDENTE);
            funcionarioRepository.save(funcionario);
            String login;
            var senhaCodificada = new BCryptPasswordEncoder().encode(dados.dadosAutenticacao().senha());
            if(dados.dadosAutenticacao().login() == null) login = dados.email();
            else login = dados.dadosAutenticacao().login();
            var usuario = new Usuario(login, senhaCodificada, TipoUsuario.ATENDENTE);
            System.out.println("aquiiii email:" + login);
            usuarioRepository.save(usuario);
            var uri = componentsBuilder.path("/funcionario/{id}").buildAndExpand(funcionario.getId()).toUri();
            return ResponseEntity.created(uri).body(new DadosListagemFuncionario(funcionario));
        } catch (Exception ex) {
            throw  new RuntimeException("Erro ao checar Token: " + ex);
        }
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemFuncionario>> listar(@PageableDefault(size = 10, page = 0, sort = {"nome"})Pageable pageable) {
        var page = funcionarioRepository.findByAtivoTrue(pageable).map(DadosListagemFuncionario::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    @PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
    public ResponseEntity alterar(@RequestBody @Valid DadosAtualizaFuncionario dados) {
        var funcionario = funcionarioRepository.getReferenceByIdAndAtivoTrue(dados.id());
        funcionario.atualizaInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemFuncionario(funcionario));

    }

    @DeleteMapping("/{id}")
    @Transactional
    @PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
    public ResponseEntity apagarLogico(@PathVariable Long id) {
        var funcionario = funcionarioRepository.getReferenceById(id);
        funcionario.apagarLogico();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/apagar/{id}")
    @Transactional
    @PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
    public ResponseEntity apagarDefinitivo(@PathVariable Long id) {
        funcionarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var funcionario = funcionarioRepository.getReferenceByIdAndAtivoTrue(id);
        return ResponseEntity.ok(new DadosListagemFuncionario(funcionario));
    }

}
