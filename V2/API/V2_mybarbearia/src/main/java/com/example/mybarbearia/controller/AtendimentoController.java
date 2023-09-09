package com.example.mybarbearia.controller;

import com.example.mybarbearia.model.atendimento.AtendimentoService;
import com.example.mybarbearia.model.atendimento.DadosAgendamentoAtendimento;
import com.example.mybarbearia.model.atendimento.DadosAtualizaAtendimento;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoController {
    @Autowired
    AtendimentoService atendimento; // classe onde toda lógica sera realizada

    @PostMapping
    @Transactional
    public ResponseEntity agendarAtendimento(@RequestBody @Valid DadosAgendamentoAtendimento dados) {
        var atendimentoDados = atendimento.agendar(dados);
        return ResponseEntity.ok(atendimentoDados);
    }

    @PutMapping
    @Transactional
    @PreAuthorize("hasAnyRole('ADMIN', 'ATENDENTE')")
    public ResponseEntity alterarAtendimento(@RequestBody @Valid DadosAtualizaAtendimento dados) {
        var atendimentoDados= atendimento.atualizarDados(dados);
        return ResponseEntity.ok().build();
    }


}
