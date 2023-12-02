package com.example.zzz;

import java.util.List;
import java.util.Vector;
import java.util.Collection.*;

public class ThreadTest2 extends Thread{
    private List<Integer> armz;

    public ThreadTest2(List<Integer> armz) throws Exception{
        if(armz == null){
            throw new Exception("Ta vazio animal!");
        }
        this.armz = armz;
    }
    public void run(){
        for(int i = 0; i<50; i++){
            synchronized(this.armz){
                this.armz.add(i);
                System.out.println(i);
                try{
                    Thread.sleep(500);
                }catch(Exception e ){
                    System.err.println(e);
                }
            }
        }
    }
}