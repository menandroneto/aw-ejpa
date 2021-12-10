package com.algaworks.algacommerce.relacionamentos;

import com.algaworks.algacommerce.EntityManagerTest;
import com.algaworks.algacommerce.model.Categoria;
import com.algaworks.algacommerce.model.Pedido;
import org.junit.Assert;
import org.junit.Test;

public class RemoverEntidadesReferenciadasTest extends EntityManagerTest {

    @Test
    public void removerEntidadeReferenciada(){
        Pedido pedido = entityManager.find(Pedido.class, 1);
        Assert.assertFalse(pedido.getItens().isEmpty());

        entityManager.getTransaction().begin();
        pedido.getItens().forEach(i -> entityManager.remove(i));
        entityManager.remove(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido verificacao = entityManager.find(Pedido.class, 1);
        Assert.assertNull(verificacao);
    }
}
