package com.algaworks.algacommerce.model;

import com.algaworks.algacommerce.listener.GenericoListener;
import com.algaworks.algacommerce.listener.GerarNotaFiscalListener;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@EntityListeners({ GerarNotaFiscalListener.class, GenericoListener.class })
@Table(name="pedido")
public class Pedido {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "cliente_id")
//    private Integer clienteId;

    @ManyToOne(optional = false)
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_ultima_atualizacao")
    private LocalDateTime dataUltimaAtualizacao;

    @Column(name = "data_conclusao")
    private LocalDateTime dataConclusao;

//    @Column(name = "nota_fiscal_id")
//    private Integer notaFiscalId;

    @OneToOne(mappedBy = "pedido")
    private NotaFiscal notaFiscal;

    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @Embedded
    private EnderecoEntregaPedido enderecoEntrega;

    public boolean isPago() {
        return StatusPedido.PAGO.equals(status);
    }

    @OneToMany(mappedBy = "pedido", fetch= FetchType.LAZY)
    private List<ItemPedido> itens;

    @OneToOne(mappedBy = "pedido")
    private PagamentoCartao pagamento;

    // Metodo para Calcular o Total
    private void calculaTotal() {
        if (itens != null){
                total = itens.stream()
                        //.map(ItemPedido::getPrecoProduto() * ItemPedido::getQuantidade())
                        .map(ItemPedido::getPrecoProduto)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }




    // Callbacks

    @PrePersist
    public void aoPersistir(){
        dataCriacao = LocalDateTime.now();
        calculaTotal();
    }

    @PreUpdate
    public void aoAtualizar(){
        dataUltimaAtualizacao = LocalDateTime.now();
        calculaTotal();
    }

    // Lista dos callbacks

    @PostPersist
    public void aposPersistir() {
        System.out.println("Após persistir Pedido.");
    }
    @PostUpdate
    public void aposAtualizar() {
        System.out.println("Após atualizar Pedido.");
    }
    @PreRemove
    public void aoRemover() {
        System.out.println("Antes de remover Pedido.");
    }
    @PostRemove
    public void aposRemover() {
        System.out.println("Após remover Pedido.");
    }
    /*
    @PostLoad
    public void aoCarregar() {
        System.out.println("Após carregar o Pedido.");
    }
    */
}
