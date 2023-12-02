package com.example.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

public class Receptor extends Thread{
    private Socket conexao;
    private BufferedReader receptor;

    public Receptor(Socket conexao, BufferedReader receptor){
        this.conexao = conexao;
        this.receptor = receptor;
    }

    public void run(){
        for(;;){
            try{
                if (receptor.ready()) {
                    System.out.println("\n" + receptor.readLine() + "\nTente utilizar nosso serviço de chat mais tarde!");
                    System.exit(0);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
