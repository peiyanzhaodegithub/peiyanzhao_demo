package com.example.demo.clone;


import org.springframework.util.SerializationUtils;

public class ClassClone {


    public static void main(String[] args) {
        Dog dog = new Dog("毛毛",1);

        Dog dog1 = (Dog) dog.clone();

        System.out.println(dog1.getName());
    }


    public static class Dog implements Cloneable{

        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Dog(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Dog() {
        }

        @Override
        public Object clone(){
            Dog dog = null;
            try {
                dog = (Dog) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return dog;
        }

    }




}
