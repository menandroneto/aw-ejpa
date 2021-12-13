package com.algaworks.algacommerce.service;

import com.algaworks.algacommerce.model.Pedido;

public class NotaFiscalService {

    public void gerar(Pedido pedido){
        System.out.println("Gerando Nota Ficsal par o Pedido " + pedido.getId() + ".");
    }
}
