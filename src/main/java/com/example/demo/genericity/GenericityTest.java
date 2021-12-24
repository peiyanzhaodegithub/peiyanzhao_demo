package com.example.demo.genericity;

import java.util.ArrayList;
import java.util.List;

public class GenericityTest {


    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("aaa");
        list.add(1);
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) instanceof String){
                System.out.println((String) list.get(i));
            }
            if (list.get(i) instanceof Integer){
                System.out.println((Integer) list.get(i));
            }
        }
    }
}
