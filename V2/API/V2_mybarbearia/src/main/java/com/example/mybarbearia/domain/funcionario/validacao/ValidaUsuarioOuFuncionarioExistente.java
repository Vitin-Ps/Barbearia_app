package com.example.mybarbearia.domain.funcionario.validacao;

import com.example.mybarbearia.domain.funcionario.DadosCadastroFuncionario;
import com.example.mybarbearia.infra.exception.ValidacaoExeption;
import com.example.mybarbearia.repository.FuncionarioRepository;
import com.example.mybarbearia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaUsuarioOuFuncionarioExistente implements ValidaCadastroFuncionario{
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public void valida(DadosCadastroFuncionario dados) {
        if(funcionarioRepository.existsByEmail(dados.email())) throw new ValidacaoExeption("Email já cadastrado!");
        if(funcionarioRepository.existsByCpf(dados.cpf())) throw new ValidacaoExeption("CPF já cadastrado!");
        if(usuarioRepository.existsByLogin(dados.dadosAutenticacao().login())) throw new ValidacaoExeption("Login inválido");
    }
}
