package com.algaworks.algacommerce.relacionamentos;

import com.algaworks.algacommerce.EntityManagerTest;
import com.algaworks.algacommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AutoRelacionamentoTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento(){
        Categoria categoriaPai = new Categoria();
        categoriaPai.setNome("Eletrônicos");

        Categoria categoria = new Categoria();
        categoria.setNome("Calulares");
        categoria.setCategoriaPai(categoriaPai);

        entityManager.getTransaction().begin();
        entityManager.persist(categoriaPai);
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria verificacao = entityManager.find(Categoria.class, categoria.getId());
        Assert.assertNotNull(verificacao.getCategoriaPai());

        Categoria verificacaoPai = entityManager.find(Categoria.class, categoriaPai.getId());
        Assert.assertFalse(verificacaoPai.getCategorias().isEmpty());
    }
}
