package com.algaworks.algacommerce.iniciandocomjpa;

import com.algaworks.algacommerce.EntityManagerTest;
import com.algaworks.algacommerce.model.Cliente;
import com.algaworks.algacommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

public class PrimeiroCrudTest extends EntityManagerTest {

    @Test
    public void inserirRegistro(){
        Cliente cliente = new Cliente();
        // cliente.setId(3);
        cliente.setNome("José Lucas");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteVerificacao);
    }

    @Test
    public void buscarPorIdentificador(){
        Produto produto = entityManager.find(Produto.class, 1);
        Assert.assertNotNull(produto);
        Assert.assertEquals("Kindle", produto.getNome());
    }


    @Test
    public void atualizarRegistro(){
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNome("Fernando Medeiros Silva");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertEquals("Fernando Medeiros Silva", clienteVerificacao.getNome());
    }

    @Test
    public void removerRegistro(){
        Cliente cliente = entityManager.find(Cliente.class, 2);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNull(clienteVerificacao);

    }
}
