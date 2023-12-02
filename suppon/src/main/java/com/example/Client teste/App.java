package com.example.Client;

import com.example.Server.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        try{
            Socket conexao = new Socket("localhost", 3000);

            BufferedReader receptor =
            new BufferedReader (
            new InputStreamReader (
            conexao.getInputStream ())); // autofalante

            PrintWriter transmissor =
            new PrintWriter (
            conexao.getOutputStream ()); 

            BufferedReader tc = new BufferedReader(new InputStreamReader(System.in));

            Receptor outro = new Receptor(conexao, receptor);
            outro.start();

            Scanner sc = new Scanner(System.in);

            String tx;
            do{
                System.out.print("Digite a mensagem que deseja enviar: ");
                tx = tc.readLine();
                transmissor.println(tx);
                transmissor.flush();
            }while(!tx.toLowerCase().equals("fim"));

            sc.close();
        }
        catch(Exception err){

        }

    }
}