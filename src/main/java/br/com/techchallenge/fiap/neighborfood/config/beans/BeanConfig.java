package br.com.techchallenge.fiap.neighborfood.config.beans;
/*
 * Copyright (c) 2024. MiguelProgrammer
 */

import br.com.techchallenge.fiap.neighborfood.adapter.gateways.*;
import br.com.techchallenge.fiap.neighborfood.core.usecase.pedido.PedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    @Bean
    public PedidoUseCase configBeanPedido(EstoqueGateway estoqueGateway, UserGateway userGateway, PedidoGateway pedidoGateway) {
        return new PedidoUseCase(estoqueGateway, userGateway, pedidoGateway);
    }

    @Bean
    public RestTemplate configTemplate(){
        return new RestTemplate();
    }

}
