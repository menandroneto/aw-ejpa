package com.algaworks.algacommerce;

import com.algaworks.algacommerce.model.Produto;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerTest {
    protected static EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    @BeforeClass
    public static void setUpBeforeClass(){
        entityManagerFactory = Persistence.createEntityManagerFactory("AlgaCommerce-PU");
    }

    @AfterClass
    public static void tearDownAfterClass(){
        entityManagerFactory.close();
    }

    @Before
    public void  setUp(){
        entityManager = entityManagerFactory.createEntityManager();
    }

    @After
    public void tearDown(){
        entityManager.close();
    }

    @Test
    public void buscaPorIdentificador(){
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
