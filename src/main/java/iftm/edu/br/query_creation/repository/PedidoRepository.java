package iftm.edu.br.query_creation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import iftm.edu.br.query_creation.domain.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {
    // Retorna todos os itens que foram vendidos sem desconto.
    List<Pedido> findByDesconto(Long desconto);

    // Retorna todos os itens que foram vendidos com desconto.
    List<Pedido> findByDescontoGreaterThan(Long desconto);

    // Retorna todos os itens e ordene o resultado por VALOR_UNIT do maior valor para o menor.
    List<Pedido> findAllByOrderByValorUnitDesc();

    // Retorna o produto que mais vendeu.
    Long findTopByOrderByQuantidadeDesc();

    // Consulte as NF que foram vendidas mais de 10 unidades de pelo menos um produto.
    @Query("SELECT DISTINCT p.idNf FROM Pedido p WHERE p.quantidade > 10 GROUP BY p.idNf")
    List<Long> findNfWithMoreThan10Units();

    // Pesquise o valor total das NF, onde esse valor seja maior que 500, e ordene o resultado do maior valor para o menor.
    @Query("SELECT SUM(p.valorTotal) FROM Pedido p GROUP BY p.idNf HAVING SUM(p.valorTotal) > 500 ORDER BY SUM(p.valorTotal) DESC")
    List<Double> findTotalValueOfNfGreaterThan500();

}
