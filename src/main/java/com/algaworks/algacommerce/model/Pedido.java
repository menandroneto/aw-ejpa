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

    @ManyToOne(optional = false)
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", fetch= FetchType.LAZY)
    private List<ItemPedido> itens;

    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_ultima_atualizacao", insertable = false)
    private LocalDateTime dataUltimaAtualizacao;

    @Column(name = "data_conclusao")
    private LocalDateTime dataConclusao;

    @OneToOne(mappedBy = "pedido")
    private NotaFiscal notaFiscal;

    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @OneToOne(mappedBy = "pedido")
    private PagamentoCartao pagamento;

    @Embedded
    private EnderecoEntregaPedido enderecoEntrega;

    public boolean isPago() {
        return StatusPedido.PAGO.equals(status);
    }

    // @Prepersist
    // @PreUpdate
    private void calculaTotal() {
        if (itens != null){
                total = itens.stream().map(ItemPedido::getPrecoProduto)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }

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

    @PostLoad
    public void aoCarregar() {
        System.out.println("Após carregar o Pedido.");
    }
}