package com.algaworks.algacommerce.mapeamentoavancado;

import com.algaworks.algacommerce.EntityManagerTest;
import com.algaworks.algacommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DetalhesColumnTest extends EntityManagerTest {

    @Test
    public void impedirInsercaoDaColunaAtualizacao(){
        Produto produto = new Produto();
        produto.setNome("Teclado para smartphone");
        produto.setDescricao("O mais confortavel");
        produto.setPreco(BigDecimal.ONE);
        produto.setDataCriacao(LocalDateTime.now());
        produto.setDataUltimaAtualizacao(LocalDateTime.now());

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto verificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(verificacao.getDataCriacao());
        Assert.assertNull(verificacao.getDataUltimaAtualizacao());
    }

    @Test
    public void impedirInsercaoDaColunaCriacao(){
        entityManager.getTransaction().begin();
        Produto produto = entityManager.find(Produto.class, 1);

        produto.setDataCriacao(LocalDateTime.now());
        produto.setDataUltimaAtualizacao(LocalDateTime.now());
        produto.setPreco(BigDecimal.ONE);

        // entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto verificacao = entityManager.find(Produto.class, produto.getId());

        Assert.assertNotEquals(
                    produto.getDataCriacao().truncatedTo(ChronoUnit.SECONDS),
                    verificacao.getDataCriacao().truncatedTo(ChronoUnit.SECONDS));

        Assert.assertEquals(produto.getDataUltimaAtualizacao().truncatedTo(ChronoUnit.SECONDS),
                verificacao.getDataUltimaAtualizacao().truncatedTo(ChronoUnit.SECONDS));
    }

}
