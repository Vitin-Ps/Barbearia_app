package com.example.mybarbearia.domain.recibo;

import com.example.mybarbearia.domain.atendimento.Atendimento;
import com.example.mybarbearia.domain.produto.Produto;
import com.example.mybarbearia.domain.servico.Servico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "recibo")
@Entity(name = "Recibo")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Recibo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_atendimento")
    private Atendimento atendimento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto")
    private Produto produto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_servico")
    private Servico servico;
    private Integer quantidade;
    private BigDecimal preco;
}
