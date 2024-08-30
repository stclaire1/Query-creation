package iftm.edu.br.query_creation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import iftm.edu.br.query_creation.domain.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {
    // Retorne todos os itens que foram vendidos sem desconto.
    List<Pedido> findByDesconto(int desconto);

    // Retorne todos os itens que foram vendidos com desconto.
    List<Pedido> findByDescontoGreaterThan(int desconto);

    // Retorne todos os itens e ordene o resultado por VALOR_UNIT do maior valor para o menor.
    List<Pedido> findAllByOrderByValorUnitDesc();

    // Retorne o produto que mais vendeu.
    @Query("SELECT p.codProd FROM Pedido p GROUP BY p.codProd ORDER BY SUM(p.quantidade) DESC LIMIT 1")
    Long findTopByOrderByQuantidadeDesc();

    // Consulte as NF que foram vendidas mais de 10 unidades de pelo menos um produto.
    @Query("SELECT DISTINCT p.idNf FROM Pedido p WHERE p.quantidade > 10 GROUP BY p.idNf")
    List<Long> findNfWithMoreThan10Units();

    // Pesquise o valor total das NF, onde esse valor seja maior que 500, e ordene o resultado do maior valor para o menor.
    @Query("SELECT p.idNf, SUM(p.valorUnit * p.quantidade * (1 - p.desconto / 100)) AS total FROM Pedido p GROUP BY p.idNf HAVING SUM(p.valorUnit * p.quantidade * (1 - p.desconto / 100)) > 500 ORDER BY total DESC")
    List<Object[]> findTotalValueOfNfGreaterThan500();

}
