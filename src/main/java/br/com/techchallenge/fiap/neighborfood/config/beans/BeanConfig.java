package br.com.techchallenge.fiap.neighborfood.config.beans;
/*
 * Copyright (c) 2024. MiguelProgrammer
 */

import br.com.techchallenge.fiap.neighborfood.adapter.gateways.*;
import br.com.techchallenge.fiap.neighborfood.core.usecase.pedido.PedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public PedidoUseCase configBeanPedido(PedidoGateway pedidoGateway) {
        return new PedidoUseCase(pedidoGateway);
    }

}
