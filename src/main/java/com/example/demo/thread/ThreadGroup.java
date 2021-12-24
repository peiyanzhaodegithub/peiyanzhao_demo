package com.example.demo.thread;

public class ThreadGroup {

    public static void main(String[] args) {
        java.lang.ThreadGroup group = new java.lang.ThreadGroup("group");
        new Thread(group, ()->{

        }).start();


    }

}
