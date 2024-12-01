/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.framework.web;

import br.com.techchallenge.fiap.neighborfood.core.domain.dto.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PedidoControllerTest {

    @Autowired
    private PedidoController pedidoController;

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Visualiza MENU!")
    void menu() {
        /* ACTO */
        /* ASSERT */

        assertThat(pedidoController.menu().getStatusCode().equals(HttpStatus.OK)).isTrue();


    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Realiza um pedido!")
    void order() {

        /* ACT */
        ResponseEntity<AcompanhamentoResponseDTO> order = pedidoController.order(pedido(Boolean.FALSE));
        AcompanhamentoResponseDTO dto = order.getBody();

        /* ASSERT */
        assertThat(dto).isInstanceOf(AcompanhamentoResponseDTO.class);
        assertThat(dto).isNotNull();
        assertThat(dto.getStatus()).isEqualTo(StatusPedidoDTO.fromValue(dto.getStatus().getValue()));
        assertThat(dto.getTotal()).isGreaterThan(BigDecimal.ZERO);


    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Atualiza um pedido!")
    void updateOrder() {
        ResponseEntity<AcompanhamentoResponseDTO> orderGet = pedidoController.order(pedido(Boolean.FALSE));
        AcompanhamentoResponseDTO dtoGet = orderGet.getBody();
        /* ASSERT */
        assertThat(dtoGet).isInstanceOf(AcompanhamentoResponseDTO.class);
        assertThat(dtoGet).isNotNull();
        assertThat(dtoGet.getStatus()).isEqualTo(StatusPedidoDTO.fromValue(dtoGet.getStatus().getValue()));
        assertThat(dtoGet.getTotal()).isGreaterThan(BigDecimal.ZERO);

        /* ARRANGE */
        PedidoRequestDTO pedido = pedido(Boolean.TRUE);
        pedido.setId(dtoGet.getPedido().getId());
        pedido.getItensPedido().forEach(it -> it.setIdPedido(dtoGet.getPedido().getId()));

        /* ACT */
        ResponseEntity<AcompanhamentoResponseDTO> order = pedidoController.updateOrder(pedido);
        AcompanhamentoResponseDTO dto = order.getBody();

        /* ASSERT */
        assertThat(dto).isInstanceOf(AcompanhamentoResponseDTO.class);
        assertThat(dto).isNotNull();
        assertThat(dto.getStatus()).isEqualTo(StatusPedidoDTO.fromValue(dto.getStatus().getValue()));
        assertThat(dto.getTotal()).isGreaterThan(BigDecimal.ZERO);
    }


    private PedidoRequestDTO pedido(Boolean atualiza){

        PedidoRequestDTO dto = new PedidoRequestDTO();
        dto.setIdCliente(1L);

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setId(1L);

        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(1L);
        produtoDTO.setNome("Batata Frita");
        produtoDTO.setDescricao("Batata Frita média");
        produtoDTO.setCategoria(CategoriaDTO.ACOMPANHAMENTO);
        produtoDTO.setImg("http://google.com/image");
        produtoDTO.setPreco(new BigDecimal(7.00));
        itemPedido.setProduto(produtoDTO);
        itemPedido.setIdPedido(1L);
        dto.setItensPedido(List.of(itemPedido));


        if(atualiza){
            produtoDTO.setId(2L);
            produtoDTO.setPreco(new BigDecimal(11.00));
            produtoDTO.setCategoria(CategoriaDTO.LANCHE);
        }

        return dto;
    }
}