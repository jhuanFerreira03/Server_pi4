package com.example.Server;

import com.example.Client.*;
import java.util.*;

import javax.swing.plaf.synth.SynthStyle;

public class Server {

    public static final String PORTA_PADRAO = "3000";
    public static void main( String[] args ){
        Scanner sc = new Scanner(System.in);
        if(args.length >1){
            System.err.println("Uso esperado: Java servidor [Porta]\n");
            sc.close();
            return;
        }
        String porta = Server.PORTA_PADRAO;

        if (args.length == 1){
            porta = args[0];
        }

        ArrayList<Parceiro> usuarios = new ArrayList<Parceiro>();

        AceitaConexao aceitaConexao = null;
        try{
            aceitaConexao = new AceitaConexao(porta, usuarios);
            aceitaConexao.start();
        }catch(Exception e){
            System.err.println("Porta inapropriada!");
            sc.close();
            return;
        }
        for(;;){
            System.out.print("o servidor está ativo na porta: "+ PORTA_PADRAO.toString() +"!\n Escreva \"desativar\" para desativar\n:");
            String dec = null;
            try{
                dec = sc.nextLine();
            }catch(Exception e){}
            if(dec.toLowerCase().equals("desativar")){
                synchronized(usuarios){
                    for(Parceiro usuario:usuarios){
                        try{
                            usuario.fechar();
                        }catch(Exception e){}
                    }
                }
                System.out.println("O servidor foi desativado!");
                sc.close();
                System.exit(0);
            }
            else{
                System.err.println("Comando invalido!");
            }
        }
    }
}
