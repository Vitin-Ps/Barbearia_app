package com.example.mybarbearia.domain.carrinhodecompras.validacoes;

import com.example.mybarbearia.infra.exception.ValidacaoExeption;
import com.example.mybarbearia.domain.carrinhodecompras.DadosCadastroCarrinho;
import org.springframework.stereotype.Component;

@Component
public class ValidaIdItemNull implements ValidadorFuncionalidadeCarrinhoDeCompras{
    @Override
    public void checar(DadosCadastroCarrinho dados) {
        if(dados.idProduto() == null && dados.idServico() == null) throw new ValidacaoExeption("Você tem que escolher algum item.");
    }
}
