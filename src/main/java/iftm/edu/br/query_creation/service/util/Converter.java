package iftm.edu.br.query_creation.service.util;

import org.springframework.stereotype.Component;

import iftm.edu.br.query_creation.domain.Pedido;
import iftm.edu.br.query_creation.dto.PedidoDTO;

@Component
public class Converter {
    public PedidoDTO convertToDTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId_pedido(pedido.getId_pedido());
        dto.setId_nf(pedido.getId_nf());
        dto.setId_item(pedido.getId_item());
        dto.setCod_prod(pedido.getCod_prod());
        dto.setValor_unit(pedido.getValor_unit());
        dto.setQuantidade(pedido.getQuantidade());
        dto.setDesconto(pedido.getDesconto());
        return dto;
    }

    public Pedido convertToEntity(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setId_pedido(pedidoDTO.getId_pedido());
        pedido.setId_nf(pedidoDTO.getId_nf());
        pedido.setId_item(pedidoDTO.getId_item());
        pedido.setCod_prod(pedidoDTO.getCod_prod());
        pedido.setValor_unit(pedidoDTO.getValor_unit());
        pedido.setQuantidade(pedidoDTO.getQuantidade());
        pedido.setDesconto(pedidoDTO.getDesconto());
        return pedido;
    }
}
