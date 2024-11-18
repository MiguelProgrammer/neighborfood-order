/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package _generated_sources_swagger_pedido;

import br.com.techchallenge.fiap.neighborfood.core.domain.dto.AcompanhamentoResponseDTO;
import br.com.techchallenge.fiap.neighborfood.core.domain.dto.PedidoRequestDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-17T12:30:36.785807100-03:00[America/Sao_Paulo]")
@Validated
@Tag(name = "menu", description = "Apresenta os opcionais")
public interface NeighborfoodApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /neighborfood/menu : Apresenta o menu com itens opcionais
     * menu de opções
     *
     * @return Apresenta os itens de menu (status code 200)
     *         or request inválida (status code 400)
     */
    @Operation(
        operationId = "menu",
        summary = "Apresenta o menu com itens opcionais",
        description = "menu de opções",
        tags = { "menu" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Apresenta os itens de menu", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))
            }),
            @ApiResponse(responseCode = "400", description = "request inválida")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/neighborfood/menu",
        produces = { "application/json" }
    )
    default ResponseEntity<Object> menu(
        
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /neighborfood/pedido : Realizar um pedido
     * Fazer um  pedido
     *
     * @param pedidoRequestDTO Cria um novo pedido (optional)
     * @return Pedido criado (status code 200)
     *         or request inválida (status code 400)
     */
    @Operation(
        operationId = "order",
        summary = "Realizar um pedido",
        description = "Fazer um  pedido",
        tags = { "order" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Pedido criado", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = AcompanhamentoResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "request inválida")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/neighborfood/pedido",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<AcompanhamentoResponseDTO> order(
        @Parameter(name = "PedidoRequestDTO", description = "Cria um novo pedido") @Valid @RequestBody(required = false) PedidoRequestDTO pedidoRequestDTO
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"total\" : 7.061401241503109, \"pedido\" : { \"itensPedido\" : [ { \"produto\" : { \"preco\" : 2.3021358869347655, \"img\" : \"img\", \"nome\" : \"nome\", \"id\" : 5, \"descricao\" : \"descricao\" }, \"id\" : 1, \"idPedido\" : 5 }, { \"produto\" : { \"preco\" : 2.3021358869347655, \"img\" : \"img\", \"nome\" : \"nome\", \"id\" : 5, \"descricao\" : \"descricao\" }, \"id\" : 1, \"idPedido\" : 5 } ], \"idCliente\" : 6, \"id\" : 0 } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /neighborfood/pedido/update : Atualizar um pedido
     * Atualizar itens de um pedido já realizado
     *
     * @param pedidoRequestDTO atualiar um  pedido (optional)
     * @return Pedido atualizado (status code 200)
     *         or request inválida (status code 400)
     */
    @Operation(
        operationId = "updateOrder",
        summary = "Atualizar um pedido",
        description = "Atualizar itens de um pedido já realizado",
        tags = { "order" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Pedido atualizado", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = AcompanhamentoResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "request inválida")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/neighborfood/pedido/update",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<AcompanhamentoResponseDTO> updateOrder(
        @Parameter(name = "PedidoRequestDTO", description = "atualiar um  pedido") @Valid @RequestBody(required = false) PedidoRequestDTO pedidoRequestDTO
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"total\" : 7.061401241503109, \"pedido\" : { \"itensPedido\" : [ { \"produto\" : { \"preco\" : 2.3021358869347655, \"img\" : \"img\", \"nome\" : \"nome\", \"id\" : 5, \"descricao\" : \"descricao\" }, \"id\" : 1, \"idPedido\" : 5 }, { \"produto\" : { \"preco\" : 2.3021358869347655, \"img\" : \"img\", \"nome\" : \"nome\", \"id\" : 5, \"descricao\" : \"descricao\" }, \"id\" : 1, \"idPedido\" : 5 } ], \"idCliente\" : 6, \"id\" : 0 } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
