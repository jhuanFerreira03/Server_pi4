package com.example.Server;

public class PedidoDados extends Comunicado {
    private String colecao;

    public PedidoDados(String colecao){
        this.colecao = colecao;
    }

    public String getColecao(){
        return colecao;
    }
}
