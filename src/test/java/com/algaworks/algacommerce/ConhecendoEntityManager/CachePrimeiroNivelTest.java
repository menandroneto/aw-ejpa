package com.algaworks.algacommerce.ConhecendoEntityManager;

import com.algaworks.algacommerce.EntityManagerTest;
import com.algaworks.algacommerce.model.Produto;
import org.junit.Test;

public class CachePrimeiroNivelTest extends EntityManagerTest {

    @Test
    public void verificarCache(){
        // Objetivo da aula: Mostrar quando o cache em primeiro nivel é executado

        Produto produto = entityManager.find(Produto.class, 1);
        System.out.println(produto.getNome());
        System.out.println("-----------------------------------");

        entityManager.clear();

        // O mesmo produto como é uma consulta gerenciada buscou no cache (por que é um objeto gerenciado)
        Produto produtoResgatado = entityManager.find(Produto.class, produto.getId());
        System.out.println(produto.getNome());
    }
}
