package com.algaworks.algacommerce.iniciandocomjpa;

import com.algaworks.algacommerce.EntityManagerTest;
import com.algaworks.algacommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacoesComTransacaoTeste extends EntityManagerTest {

    @Test
    public void inserirOPrimeiroObjeto(){
        Produto produto = new Produto();
        // produto.setId(2);
        produto.setNome("Câmera Canon");
        produto.setDescricao("A melhor definição para suas fotos");
        produto.setPreco(new BigDecimal(5000.99));

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.clear(); // limpa cache de objetos na memoria

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);
    }


    public void abrirEFecharATransacao(){
        /*
         *
         * pseudo codigo de como devemos implementar as transações
         *
         **/
        Produto produto = new Produto();

        entityManager.getTransaction().begin();

        //entityManager.persist(produto);
        //entityManager.merge(produto);
        //entityManager.remove(produto);

        entityManager.getTransaction().commit();
    }

}
