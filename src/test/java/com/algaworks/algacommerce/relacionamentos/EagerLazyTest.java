package com.algaworks.algacommerce.relacionamentos;

import com.algaworks.algacommerce.EntityManagerTest;
import com.algaworks.algacommerce.model.Pedido;
import org.junit.Test;

public class EagerLazyTest extends EntityManagerTest {

    @Test
    public void verificaComportamento(){
        Pedido pedido = entityManager.find(Pedido.class, 1);

        pedido.getItens().isEmpty();
    }
}
