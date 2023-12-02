package com.example.zzz;

import java.util.*;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        try{
            System.out.println( "Hello, Jhuan!" );

            List<Integer> armz = new Vector<Integer>();

            ThreadTest3 thread3 = new ThreadTest3(armz);
            try{
                ThreadTest thread1 = new ThreadTest(armz);
                ThreadTest2 thread2 = new ThreadTest2(armz);
                thread1.start();
                thread2.start();
            }catch (Exception e) {
                System.err.println(e);
            }

            Scanner sc = new Scanner(System.in);

            System.out.println("Deseja fechar a main?");
            sc.nextLine();
            sc.close();
            System.out.println("main fechada irmao");
            thread3.start();

            return;
        }catch(Exception e){}
    }
}