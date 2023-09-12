package com.example.mybarbearia.domain.atendimento;

import com.example.mybarbearia.domain.cliente.DadosListagemCliente;
import com.example.mybarbearia.domain.funcionario.DadosListagemFuncionario;
import com.example.mybarbearia.domain.recibo.DadosListagemRecibo;

import java.time.LocalDateTime;
import java.util.List;

public record DadosListagemAgendamento(
        Long idAtendimento,
        DadosListagemCliente cliente,
        DadosListagemFuncionario funcionario,
        LocalDateTime data,
        List<DadosListagemRecibo> recibo
) {
}
