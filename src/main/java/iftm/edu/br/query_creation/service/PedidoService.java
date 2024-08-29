package iftm.edu.br.query_creation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import iftm.edu.br.query_creation.domain.Pedido;

@Service
public class PedidoService {

    public List<Pedido> findByDesconto(Long desconto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDesconto'");
    }

    public List<Pedido> findByDescontoGreaterThan(Long desconto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDescontoGreaterThan'");
    }

    public List<Pedido> findAllByOrderByValorUnitDesc() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByOrderByValorUnitDesc'");
    }

    public Long findTopByOrderByQuantidadeDesc() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findTopByOrderByQuantidadeDesc'");
    }

    public List<Long> findNfWithMoreThan10Units() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findNfWithMoreThan10Units'");
    }

    public List<Double> findTotalValueOfNfGreaterThan500() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findTotalValueOfNfGreaterThan500'");
    }
    
}
