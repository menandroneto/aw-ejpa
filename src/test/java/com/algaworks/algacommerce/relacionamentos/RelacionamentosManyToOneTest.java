package com.algaworks.algacommerce.relacionamentos;

import com.algaworks.algacommerce.EntityManagerTest;
import com.algaworks.algacommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentosManyToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento(){
        Cliente cliente = entityManager.find(Cliente.class, 1);

        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataCriacao(LocalDateTime.now());
        pedido.setTotal(BigDecimal.TEN);

        pedido.setCliente(cliente);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido verificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(verificacao.getCliente());
    }

    @Test
    public void verificarRelacionamentoItemPedido(){
        entityManager.getTransaction().begin();

        Cliente cliente = entityManager.find(Cliente.class, 1);
        Produto produto = entityManager.find(Produto.class, 1);

        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataCriacao(LocalDateTime.now());
        pedido.setTotal(BigDecimal.TEN);
        pedido.setCliente(cliente);

        entityManager.persist(pedido);

        entityManager.flush();



        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPedidoId(pedido.getId());
        itemPedido.setProdutoId(produto.getId());
        itemPedido.setPrecoProduto(produto.getPreco());
        itemPedido.setQuantidade(1);
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);

        entityManager.persist(itemPedido);

        entityManager.getTransaction().commit();

        entityManager.clear();

        ItemPedido verificacao = entityManager.find(ItemPedido.class, new ItemPedidoId(pedido.getId(), produto.getId()));

        Assert.assertNotNull(verificacao.getPedido());
        Assert.assertNotNull(verificacao.getProduto());
    }
}