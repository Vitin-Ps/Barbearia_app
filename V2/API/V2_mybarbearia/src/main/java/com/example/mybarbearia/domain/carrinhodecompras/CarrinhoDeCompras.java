package com.example.mybarbearia.domain.carrinhodecompras;

import com.example.mybarbearia.domain.cliente.Cliente;
import com.example.mybarbearia.domain.produto.Produto;
import com.example.mybarbearia.domain.servico.Servico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "carrinho_de_compras")
@Entity(name = "CarrinhoDeCompras")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CarrinhoDeCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto")
    private Produto produto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_servico")
    private Servico servico;
    private BigDecimal preco;
}
