package com.algaworks.algacommerce.ConhecendoEntityManager;

import com.algaworks.algacommerce.EntityManagerTest;
import com.algaworks.algacommerce.model.Cliente;
import com.algaworks.algacommerce.model.Pedido;
import com.algaworks.algacommerce.model.Produto;
import com.algaworks.algacommerce.model.StatusPedido;
import org.junit.Assert;
import org.junit.Test;

import java.security.ProtectionDomain;

public class ListenersTest extends EntityManagerTest {
    @Test
    public void carramentoEntidades() {
        Produto produto = entityManager.find(Produto.class, 1);
        Cliente cliente = entityManager.find(Cliente.class, 1);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.AGUARDANDO);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();
        Pedido pedido2 = entityManager.find(Pedido.class, pedido.getId());
    }

    @Test
    public void adicionaCallbacks(){

        Cliente cliente = entityManager.find(Cliente.class, 1);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.AGUARDANDO);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.flush();

        pedido.setStatus(StatusPedido.PAGO);

        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido verifica = entityManager.find(Pedido.class, pedido.getId());

        Assert.assertNotNull(verifica.getDataCriacao());
        Assert.assertNotNull(verifica.getDataUltimaAtualizacao());
    }

}
