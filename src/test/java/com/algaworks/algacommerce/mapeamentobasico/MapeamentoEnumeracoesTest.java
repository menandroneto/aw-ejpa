package com.algaworks.algacommerce.mapeamentobasico;

import com.algaworks.algacommerce.EntityManagerTest;
import com.algaworks.algacommerce.model.Cliente;
import com.algaworks.algacommerce.model.SexoCliente;
import org.junit.Assert;
import org.junit.Test;

public class MapeamentoEnumeracoesTest extends EntityManagerTest {

    @Test
    public void testarEnum(){
        Cliente cliente = new Cliente();
        // cliente.setId(4); por conta do uso de @GeneratedValue(strategy = GenerationType.IDENTITY)
        cliente.setNome("José Mineiro");
        cliente.setSexo(SexoCliente.MASCULINO);

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteVerificacao);
    }

}
