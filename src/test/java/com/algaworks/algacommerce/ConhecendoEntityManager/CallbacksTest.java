package com.algaworks.algacommerce.ConhecendoEntityManager;

import com.algaworks.algacommerce.EntityManagerTest;
import com.algaworks.algacommerce.model.Cliente;
import com.algaworks.algacommerce.model.Pedido;
import com.algaworks.algacommerce.model.StatusPedido;
import org.junit.Assert;
import org.junit.Test;

public class CallbacksTest extends EntityManagerTest {

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
