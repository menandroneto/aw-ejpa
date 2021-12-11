package com.algaworks.algacommerce.relacionamentos;

import com.algaworks.algacommerce.EntityManagerTest;
import com.algaworks.algacommerce.model.NotaFiscal;
import com.algaworks.algacommerce.model.Pedido;
import com.algaworks.algacommerce.model.PagamentoCartao;
import com.algaworks.algacommerce.model.StatusPagamento;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

public class RelacionamentosOneToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento(){
        Pedido pedido = entityManager.find(Pedido.class, 1);

        PagamentoCartao pagto = new PagamentoCartao();
        pagto.setNumero("1234");
        pagto.setStatus(StatusPagamento.PROCESSANDO);
        pagto.setPedido(pedido);

        entityManager.getTransaction().begin();
        entityManager.persist(pagto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido verificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(verificacao.getPagamento());
    }

    @Test
    public void verificarRelacionamentoPedidoNotaFiscal(){
        Pedido pedido = entityManager.find(Pedido.class, 1);

        NotaFiscal nf = new NotaFiscal();
        nf.setXml("<?xml version=\"1.0\" encoding=\"UTF-8\"?><tst>Teste de Sistema</tst>");
        nf.setDataEmissao(new Date());
        nf.setPedido(pedido);

        entityManager.getTransaction().begin();
        entityManager.persist(nf);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido verificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(verificacao.getNotaFiscal());
    }

}
