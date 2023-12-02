package com.example.zzz;

import java.util.Vector;
import java.util.List;

public class ThreadTest3 extends Thread{
    private List<Integer> armz;
    public ThreadTest3(List<Integer> armz) throws Exception{
        if(armz == null){
            throw new Exception("Esta vazio animal!");
        }
        this.armz = armz;
    }
    public void run(){
        for(int i = 0; i<this.armz.size(); i++){
            synchronized(this.armz){
                System.out.println("this is: " + (i+1));
                try{
                    Thread.sleep(500);
                }catch(Exception e ){
                    System.err.println(e);
                }
            }
        }
    }
}