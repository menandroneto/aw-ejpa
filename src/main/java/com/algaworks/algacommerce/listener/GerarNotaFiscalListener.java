package com.algaworks.algacommerce.listener;

import com.algaworks.algacommerce.model.Pedido;
import com.algaworks.algacommerce.service.NotaFiscalService;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class GerarNotaFiscalListener {

    private NotaFiscalService nfService = new NotaFiscalService();

    @PrePersist
    @PreUpdate
    public void gerar(Pedido pedido){
        if (pedido.isPago() && pedido.getNotaFiscal() == null){
            nfService.gerar(pedido);
        }
    }

}
