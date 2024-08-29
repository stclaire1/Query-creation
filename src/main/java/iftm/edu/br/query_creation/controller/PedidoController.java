package iftm.edu.br.query_creation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iftm.edu.br.query_creation.domain.Pedido;
import iftm.edu.br.query_creation.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/desconto")
    public List<Pedido> findByDesconto(Long desconto) {
        return pedidoService.findByDesconto(desconto);
    }

    @GetMapping("/desconto-maior")
    public List<Pedido> findByDescontoGreaterThan(Long desconto) {
        return pedidoService.findByDescontoGreaterThan(desconto);
    }

    @GetMapping("/valor-unit")
    public List<Pedido> findAllByOrderByValorUnitDesc() {
        return pedidoService.findAllByOrderByValorUnitDesc();
    }

    @GetMapping("/mais-vendido")
    public Long findTopByOrderByQuantidadeDesc() {
        return pedidoService.findTopByOrderByQuantidadeDesc();
    }

    @GetMapping("/nf-mais-10-unidades")
    public List<Long> findNfWithMoreThan10Units() {
        return pedidoService.findNfWithMoreThan10Units();
    }

    @GetMapping("/valor-total-maior-500")
    public List<Double> findTotalValueOfNfGreaterThan500() {
        return pedidoService.findTotalValueOfNfGreaterThan500();
    }
}
