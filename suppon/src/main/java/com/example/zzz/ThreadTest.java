package com.example.zzz;

import java.util.Vector;
import java.util.List;

public class ThreadTest implements Runnable{
    private Thread thread = new Thread(this);
    private List<Integer> armz;

    public ThreadTest(List<Integer> armz) throws Exception{
        if(armz == null){
            throw new Exception("Ta vazio animal!");
        }
        this.armz = armz;
    }
    public void start(){
        this.thread.start();
    }
    public void run(){
        for(int i = 50; i<100; i++){
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