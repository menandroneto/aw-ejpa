package com.algaworks.algacommerce.ConhecendoEntityManager;

import com.algaworks.algacommerce.EntityManagerTest;
import com.algaworks.algacommerce.model.Categoria;
import org.junit.Test;

public class EstadosECicloDeVidaTest extends EntityManagerTest {

    @Test
    public void analisarEstados(){
        Categoria categoriaTransient = new Categoria();
        Categoria managed = entityManager.merge(categoriaTransient); // Transforma uma categoria Transient em Managed

        Categoria categoriaManaged = entityManager.find(Categoria.class, 1);

        entityManager.remove(categoriaManaged);         // Removed
        entityManager.persist(categoriaManaged);        // Volta a ser Gerenciada

        entityManager.detach(categoriaManaged);         // Desanexada 
    }

}
