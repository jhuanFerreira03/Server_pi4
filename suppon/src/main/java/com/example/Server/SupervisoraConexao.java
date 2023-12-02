package com.example.Server;

import java.util.*;
import java.net.*;
import java.io.*;

public class SupervisoraConexao extends Thread {
    private Parceiro usuario;
    private Socket conexao;
    private ArrayList<Parceiro> usuarios;
    private String name;

    public SupervisoraConexao(Socket conexao, ArrayList<Parceiro> usuarios, String name) throws Exception{
        if(conexao == null){
            throw new Exception("Conexao ausente!");
        }
        if(usuarios == null){
            throw new Exception("Usuarios ausentes!");
        }
        this.conexao = conexao;
        this.usuarios = usuarios;
        this.name = name;
    }

    public void run () {
        PrintWriter transmissor;
        
        try{
            transmissor = new PrintWriter(this.conexao.getOutputStream());
        }catch(Exception e){
            return;
        }
        BufferedReader receptor;
        try{
            receptor = new BufferedReader(new InputStreamReader(this.conexao.getInputStream()));
            this.usuario = new Parceiro(this.conexao, receptor, transmissor);
        }catch(Exception e) {
            try{
                transmissor.close();
            }catch(Exception falha){}
        }
        try{
            synchronized(this.usuarios){
                this.usuarios.add(this.usuario);
            }
            for(;;) {
                System.out.println(usuario.enviar());
                //System.out.println(usuario.enviar());
                /*Comunicado comunicado = this.usuario.enviar();
                if(comunicado == null){
                    return;
                }
                else if(comunicado instanceof PedidoDados){
                    
                }*/
            }
        }
        catch(Exception e){}
    }
}
