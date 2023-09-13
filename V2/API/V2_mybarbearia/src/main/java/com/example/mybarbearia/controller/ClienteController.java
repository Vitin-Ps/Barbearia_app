package com.example.mybarbearia.controller;

import com.example.mybarbearia.domain.cliente.Cliente;
import com.example.mybarbearia.domain.cliente.DadosAtualizaCliente;
import com.example.mybarbearia.domain.cliente.DadosListagemCliente;
import com.example.mybarbearia.domain.usuario.*;
import com.example.mybarbearia.repository.ClienteRepository;
import com.example.mybarbearia.domain.cliente.DadosCadastroCliente;
import com.example.mybarbearia.repository.UsuarioRepository;
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

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder componentsBuilder) {
        var cliente = new Cliente(dados);
        clienteRepository.save(cliente);
        usuarioService.cadastroUsuario(new DadosCadastroUsuario(dados.dadosAutenticacao(), dados.email(), TipoUsuario.CLIENTE));
        var uri = componentsBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemCliente(cliente));

    }

    @PostMapping("cadAdmin")
    public ResponseEntity CadastrarAdmin(@RequestBody @Valid DadosAutenticacao dados) {
        var senhaCodificada = new BCryptPasswordEncoder().encode(dados.senha());
        var usuario = new Usuario(dados.login(), senhaCodificada, TipoUsuario.ADMIN);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Admin Cadastrado!!!");
    }



    @PutMapping
    @Transactional
    @PreAuthorize("hasAnyRole('ADMIN', 'CLIENTE')")
    public ResponseEntity alterar(@RequestBody @Valid DadosAtualizaCliente dados) {
        var cliente = clienteRepository.getReferenceById(dados.id());
        cliente.atualizaInformacoes(dados);
        return  ResponseEntity.ok(new DadosListagemCliente(cliente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @PreAuthorize("hasAnyRole('ADMIN', 'CLIENTE')")
    public ResponseEntity apagarLogico(@PathVariable Long id) {
        var cliente = clienteRepository.getReferenceByIdAndAtivoTrue(id);
        cliente.apagaLogico();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/apagar/{id}")
    @Transactional
    @PreAuthorize("hasAnyRole('ADMIN', 'CLIENTE')")
    public ResponseEntity apagarDefinitivo(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var cliente = clienteRepository.getReferenceByIdAndAtivoTrue(id);
        return ResponseEntity.ok(new DadosListagemCliente(cliente));
    }
}
