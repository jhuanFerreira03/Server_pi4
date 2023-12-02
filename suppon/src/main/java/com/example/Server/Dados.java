package com.example.Server;

public class Dados extends Comunicado{
    private String res;
    public Dados (String res){
        this.res = res;
    }

    public String getRes(){
        return res;
    }
}
