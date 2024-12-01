/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.core.usecase.pedido;

import br.com.techchallenge.fiap.neighborfood.adapter.gateways.EstoqueGateway;
import br.com.techchallenge.fiap.neighborfood.adapter.gateways.PedidoGateway;
import br.com.techchallenge.fiap.neighborfood.adapter.gateways.UserGateway;
import br.com.techchallenge.fiap.neighborfood.adapter.inbound.PedidoRequest;
import br.com.techchallenge.fiap.neighborfood.core.domain.dto.*;
import br.com.techchallenge.fiap.neighborfood.core.domain.enums.Categoria;
import br.com.techchallenge.fiap.neighborfood.core.domain.enums.Status;
import br.com.techchallenge.fiap.neighborfood.core.domain.pedido.Item;
import br.com.techchallenge.fiap.neighborfood.core.domain.pedido.Pedido;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
class PedidoUseCaseTest {

    @Autowired
    private PedidoUseCase pedidoUseCase;

    @Autowired
    private EstoqueGateway estoqueGateway;

    @Autowired
    private UserGateway userGateway;

    @Autowired
    private  PedidoGateway pedidoGateway;

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("USECASE - MENU")
    void menuOpcionais() {

        /* ACT */
        /* ASSERT */
        assertThat(pedidoUseCase.menuOpcionais()).isNotNull();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("USECASE - Realiza um pedido")
    void pedido() {
        /* ACT */
        AcompanhamentoResponseDTO pedido = pedidoUseCase.pedido(pedidoRequest(Boolean.FALSE));

        /* ASSERT */
        assertThat(pedido).isNotNull();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("USECASE - Atualiza um pedido")
    void atualizarPedido() {
        /* ACT */
        AcompanhamentoResponseDTO pedido = pedidoUseCase.atualizarPedido(pedidoRequest(Boolean.TRUE));

        /* ASSERT */
        assertThat(pedido).isNotNull();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("USECASE - Remove itens do pedido")
    void removeItens() {
        /* ACT */
        pedidoUseCase.removeItens(pedidoRequest(Boolean.FALSE).getItensPedido());
    }


    private PedidoRequest pedidoRequest(Boolean atualiza){
        PedidoRequest request = new PedidoRequest();
        request.setIdCliente(1L);

        Item item = new Item();
        item.setId(1L);
        item.setIdPedido(1L);
        item.setPreco(new BigDecimal(2.00));
        item.setCategoria(Categoria.ACOMPANHAMENTO);
        request.setItensPedido(new HashSet<>(List.of(item)));

        if(atualiza){
            item.setId(2L);
            item.setPreco(new BigDecimal(20.00));
        }
        return request;
    }

    private Pedido pedido(Boolean atualiza) {

        Pedido dto = new Pedido();
        dto.setIdCliente(1L);
        dto.setStatus(Status.RECEBIDO);
        dto.setTotal(new BigDecimal(7.00));
        dto.setDataPedido(new Date());
        dto.setId(1L);

        Item itemPedido = new Item();
        itemPedido.setId(1L);

        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(1L);
        produtoDTO.setNome("Batata Frita");
        produtoDTO.setDescricao("Batata Frita média");
        produtoDTO.setCategoria(CategoriaDTO.ACOMPANHAMENTO);
        produtoDTO.setImg("http://google.com/image");
        produtoDTO.setPreco(new BigDecimal(7.00));
        itemPedido.setIdProduto(produtoDTO.getId());
        itemPedido.setIdPedido(1L);
        dto.setItensProdutos(List.of(itemPedido));


        if (atualiza) {
            produtoDTO.setId(2L);
            produtoDTO.setPreco(new BigDecimal(19.00));
            produtoDTO.setCategoria(CategoriaDTO.LANCHE);
            dto.setStatus(Status.FINALIZADO);
        }

        return dto;
    }

    private PedidoRequestDTO pedidoDto(Boolean atualiza){

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