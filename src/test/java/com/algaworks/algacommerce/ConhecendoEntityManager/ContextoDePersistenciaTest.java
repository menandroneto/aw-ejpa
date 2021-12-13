package com.algaworks.algacommerce.ConhecendoEntityManager;

import com.algaworks.algacommerce.EntityManagerTest;
import com.algaworks.algacommerce.model.Produto;
import org.junit.Test;

import java.math.BigDecimal;

public class ContextoDePersistenciaTest extends EntityManagerTest {

    @Test
    public void usarContextoPersistencia(){
        entityManager.getTransaction().begin();

        Produto produto = entityManager.find(Produto.class, 1);
        produto.setPreco(new BigDecimal(10.0));      // DirtCheck

        Produto produto1 = new Produto();
        produto1.setNome("Caneca para Café");
        produto1.setPreco(new BigDecimal(10.));
        produto1.setDescricao("Boa Caneca para Café");
        entityManager.persist(produto1);

        Produto produto2 = new Produto();
        produto2.setNome("Caneca para chá");
        produto2.setPreco(new BigDecimal(10.));
        produto2.setDescricao("Boa caneca para chá");
        produto2 = entityManager.merge(produto2);

        entityManager.flush(); // Usa o contexto de transação fazer o insert produto2 / insert produto3 / update do objeto produto

        produto2.setDescricao("Boa Caneca para Chá"); // DirtCheck

        entityManager.getTransaction().commit(); // executa o update no produto 2
    }
}
