package com.algaworks.algacommerce.ConhecendoEntityManager;

import com.algaworks.algacommerce.EntityManagerTest;
import com.algaworks.algacommerce.model.Pedido;
import com.algaworks.algacommerce.model.StatusPedido;
import org.junit.Test;

public class GerenciamentoTransacoesTest extends EntityManagerTest {

    @Test
    public void abreFechaCancelaTransacao(){
        Pedido pedido = entityManager.find(Pedido.class, 1);

        entityManager.getTransaction().begin();
        pedido.setStatus(StatusPedido.PAGO);
        if (pedido.getPagamento() != null){
            entityManager.getTransaction().commit();
        } else {
            entityManager.getTransaction().rollback();
        }
    }


    @Test (expected = Exception.class)
    public void tratamentoTransacao(){
        try {
            entityManager.getTransaction().begin();
            this.metodoDoNegocio();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    private void metodoDoNegocio(){
        Pedido pedido = entityManager.find(Pedido.class, 1);
        pedido.setStatus(StatusPedido.PAGO);
        if (pedido.getPagamento() != null) {
            throw new RuntimeException("Pedido sem as informações de pagamento.");
        }
    }
}
