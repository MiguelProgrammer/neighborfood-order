/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.infrastructure.persistence.order;

import br.com.techchallenge.fiap.neighborfood.core.domain.enums.Categoria;
import br.com.techchallenge.fiap.neighborfood.core.domain.enums.Status;
import br.com.techchallenge.fiap.neighborfood.infrastructure.persistence.order.entities.ItemEntity;
import br.com.techchallenge.fiap.neighborfood.infrastructure.persistence.order.entities.PedidoEntity;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PedidoRepositoryTest {

    private AutoCloseable autoCloseable;

    @Mock
    private PedidoRepository pedidoRepository;
    private PedidoEntity pedidoEntity;
    private ItemEntity itemEntity;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        pedidoEntity = new PedidoEntity();
        pedidoEntity.setIdCliente(1L);

        itemEntity = new ItemEntity();
        itemEntity.setIdPedido(pedidoEntity.getId());
        itemEntity.setPreco(new BigDecimal(7.00));
        itemEntity.setCategoria(Categoria.ACOMPANHAMENTO);
        itemEntity.setImg("http://google.com/image");
        itemEntity.setDescricao("Batata frita média");
        itemEntity.setNome("Batata Frita");
        itemEntity.setIdProduto(1L);

        pedidoEntity.setItensProdutos(new HashSet<>(List.of(itemEntity)));
        pedidoEntity.setStatus(Status.RECEBIDO);
        pedidoEntity.setTotal(new BigDecimal(7.00));
        pedidoEntity.setDataPedido(new Date());

    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Realiza um pedido")
    void save() {
        when(pedidoRepository.save(any(PedidoEntity.class))).thenReturn(pedidoEntity);

        /* ACT */
        var pedido = pedidoRepository.save(pedidoEntity);

        /* ASSERT */
        assertThat(pedido).isInstanceOf(PedidoEntity.class);
        assertThat(pedido).isEqualTo(pedidoEntity);
        assertThat(pedido.getIdCliente()).isEqualTo(pedidoEntity.getIdCliente());
        pedido.getItensProdutos().forEach(it -> {
            assertThat(it.getCategoria()).isEqualTo(Categoria.ACOMPANHAMENTO);
            assertThat(it.getIdPedido()).isEqualTo(pedidoEntity.getId());
        });
        assertThat(pedido.getTotal()).isGreaterThan(BigDecimal.ZERO);
        assertThat(pedido.getDataPedido()).isBefore(new Date());
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

}