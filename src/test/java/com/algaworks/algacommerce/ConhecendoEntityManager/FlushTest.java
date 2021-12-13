package com.algaworks.algacommerce.ConhecendoEntityManager;

import com.algaworks.algacommerce.EntityManagerTest;
import com.algaworks.algacommerce.model.Pedido;
import com.algaworks.algacommerce.model.StatusPedido;
import org.junit.Assert;
import org.junit.Test;

public class FlushTest extends EntityManagerTest {

    @Test(expected = Exception.class)
    public void chamarFlush()  {
        try{
            entityManager.getTransaction().begin();
            Pedido pedido = entityManager.find(Pedido.class, 1);
            pedido.setStatus(StatusPedido.PAGO);

            entityManager.flush();

            if (pedido.getPagamento() == null) {
                throw new RuntimeException("Pedido ainda não foi pago");
            }
//            Uma consulta obriga o JPA sincronizar o que ele tem na memória
//            Pedido pedidoPago = entityManager
//                    .createQuery("select p from Pedido p where p,id = 1", Pedido.class)
//                    .getSingleResult();
//            Assert.assertEquals(pedido.getStatus(), pedidoPago.getStatus());

            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

}
