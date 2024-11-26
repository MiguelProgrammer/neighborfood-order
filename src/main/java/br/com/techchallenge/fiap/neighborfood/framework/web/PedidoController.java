/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.framework.web;


import _generated_sources_swagger_pedido.NeighborfoodApi;
import br.com.techchallenge.fiap.neighborfood.adapter.controllers.Pedido;
import br.com.techchallenge.fiap.neighborfood.adapter.inbound.PedidoRequest;
import br.com.techchallenge.fiap.neighborfood.core.domain.dto.AcompanhamentoResponseDTO;
import br.com.techchallenge.fiap.neighborfood.core.domain.dto.PedidoRequestDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PedidoController implements NeighborfoodApi {

    private final Pedido pedidoController;

    public PedidoController(Pedido pedidoController) {
        this.pedidoController = pedidoController;
    }

    /**
     * GET /neighborfood/menu : Apresenta o menu com itens opcionais
     * menu de opções
     *
     * @return Apresenta os itens de menu (status code 200)
     * or request inválida (status code 400)
     */
    @Override
    @GetMapping(value = "/menu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> menu() {
        return ResponseEntity.ok(pedidoController.menu());
    }

    /**
     * POST /neighborfood/pedido : Realizar um pedido
     * Fazer um  pedido
     *
     * @param pedidoRequest Cria um novo pedido (optional)
     * @return Pedido criado (status code 200)
     *         or request inválida (status code 400)
     */
    @Override
    @PostMapping(value = "/neighborfood/pedido",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<AcompanhamentoResponseDTO> order(@RequestBody PedidoRequestDTO pedidoRequest) {
        AcompanhamentoResponseDTO response =
                pedidoController.pedido(new PedidoRequest().dtoFromRequest(pedidoRequest));
        return ResponseEntity.ok(response);
    }


    /**
     * PUT /neighborfood/pedido/update : Atualizar um pedido
     * Atualizar itens de um pedido já realizado
     *
     * @param pedidoDTO atualiar um  pedido (optional)
     * @return Pedido atualizado (status code 200)
     * or request inválida (status code 400)
     */
    @Override
    @PutMapping(value = "/neighborfood/pedido",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<AcompanhamentoResponseDTO> updateOrder(@RequestBody PedidoRequestDTO pedidoDTO) {
        AcompanhamentoResponseDTO response = pedidoController.atualiza(new PedidoRequest().dtoFromRequest(pedidoDTO));
        return ResponseEntity.ok(response);
    }


}
