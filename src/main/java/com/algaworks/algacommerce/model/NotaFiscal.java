package com.algaworks.algacommerce.model;

import com.algaworks.algacommerce.model.StatusPagamento;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="nota_fiscal")
public class NotaFiscal {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "pedido_id")
//    private Integer pedidoId;
    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    private String xml;

    @Column(name = "data_emissao")
    private Date dataEmissao;
}
