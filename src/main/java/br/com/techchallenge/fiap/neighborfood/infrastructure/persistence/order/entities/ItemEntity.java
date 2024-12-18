/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.infrastructure.persistence.order.entities;

import br.com.techchallenge.fiap.neighborfood.core.domain.enums.Categoria;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "itens_pedido")
@SequenceGenerator(name = "itens_sequence", initialValue = 1)
public class ItemEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "id_pedido")
    private Long idPedido = new PedidoEntity().getId();

    //@Setter(AccessLevel.PROTECTED)
    @Column(name = "id_produto")
    private Long idProduto;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "img")
    private String img;

}