package iftm.edu.br.query_creation.dto;

import lombok.Data;

@Data
public class PedidoDTO {
    private Long id_pedido;
    private Long id_nf;
    private Long id_item;
    private Long cod_prod;
    private Double valor_unit;
    private Long quantidade;
    private Long desconto;
}
