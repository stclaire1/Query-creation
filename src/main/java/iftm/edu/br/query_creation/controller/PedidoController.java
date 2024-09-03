package iftm.edu.br.query_creation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iftm.edu.br.query_creation.domain.Pedido;
import iftm.edu.br.query_creation.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;

    @Operation(summary = "Retorna todos os itens que foram vendidos sem desconto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de itens sem desconto retornada com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class)) }),
            @ApiResponse(responseCode = "204", description = "Nenhum item sem desconto foi encontrado")
    })
    @GetMapping("/sem-desconto")
    public List<Pedido> getItensSemDesconto() {
        return pedidoService.getItensSemDesconto();
    }

    @Operation(summary = "Retorna todos os itens que foram vendidos com desconto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de itens com desconto retornada com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class)) }),
            @ApiResponse(responseCode = "204", description = "Nenhum item com desconto foi encontrado")
    })
    @GetMapping("/desconto-maior")
    public List<Pedido> getItensComDesconto() {
        return pedidoService.getItensComDesconto();
    }

    @Operation(summary = "Retorna todos os itens ordenados por valor unitário de forma decrescente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de itens retornada com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class)) }),
            @ApiResponse(responseCode = "204", description = "Nenhum item foi encontrado")
    })
    @GetMapping("/ordenado-valor-unit")
    public List<Pedido> getItensOrdenadosPorValor() {
        return pedidoService.getItensOrdenadosPorValor();
    }

    @Operation(summary = "Retorna todos o produto mais vendido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto mais vendido retornada com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class)) }),
            @ApiResponse(responseCode = "204", description = "Nenhum item foi encontrado")
    })
    @GetMapping("/mais-vendido")
    public Long getProdutoMaisVendido() {
        return pedidoService.getProdutoMaisVendido();
    }

    @Operation(summary = "Retorna as NF que foram vendidas mais de 10 unidades de pelo menos um produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista NFs retornada com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class)) }),
            @ApiResponse(responseCode = "204", description = "Nenhuma NF foi encontrada")
    })
    @GetMapping("/nf-mais-10-unidades")
    public List<Long> findNfWithMoreThan10Units() {
        return pedidoService.findNfWithMoreThan10Units();
    }

    @Operation(summary = "Retorna o valor total das NF, onde esse valor seja maior que 500 e ordenado de forma decrescente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de valores retornada com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class)) }),
            @ApiResponse(responseCode = "204", description = "Nenhuma NF foi encontrada")
    })
    @GetMapping("/valor-total-maior-500")
    public List<Object[]> findTotalValueOfNfGreaterThan500() {
        return pedidoService.findTotalValueOfNfGreaterThan500();
    }
}
