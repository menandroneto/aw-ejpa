package com.algaworks.algacommerce.iniciandocomjpa;

import com.algaworks.algacommerce.EntityManagerTest;
import com.algaworks.algacommerce.model.Produto;
import org.junit.*;

import javax.persistence.EntityManager;

public class ConsultadoRegistrosTest extends EntityManagerTest{
    @Test
    public void buscaPorIdentificador() {
        // Produto produto = entityManager.find(Produto.class, 1);
        Produto produto = entityManager.getReference(Produto.class, 1);

        System.out.println("getReference só busca no banco quando for usar uma propriedade.");

        Assert.assertNotNull(produto);
        Assert.assertEquals("Kindle", produto.getNome());
    }

    @Test
    public void atualizaReferencia(){
        Produto produto = entityManager.find(Produto.class, 1);
        produto.setNome("Microfone");

        entityManager.refresh(produto);
        Assert.assertEquals("Kindle", produto.getNome());
    }

}
