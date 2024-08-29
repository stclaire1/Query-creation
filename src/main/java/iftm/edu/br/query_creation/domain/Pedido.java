package iftm.edu.br.query_creation.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pedido;
    private Long id_nf;
    private Long id_item;
    private Long cod_prod;
    private Double valor_unit;
    private Long quantidade;
    private Long desconto;
}
