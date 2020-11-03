package com.nowcoder.community.exam;

public class Huawei02 {

        public static final String s1="sss";
        public static final String s2="ssss";

    public class Suo1 extends Thread{
        public void run(){
            while (true){
                synchronized (Huawei02.s1){
                    System.out.println("s1...");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (Huawei02.s2){
                        System.out.println("s2..");
                    }
                }
            }
        }
    }
    public class Suo2 extends Thread{
        public void run(){
            while (true){
                synchronized (Huawei02.s2){
                    System.out.println("s2...");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (Huawei02.s1){
                        System.out.println("s1..");
                    }
                }
            }
        }
    }

}
