package com.javarush.task.task20.task2018;

import java.io.*;

/* 
Найти ошибки
*/
public class Solution implements Serializable {
    public static class A {
        protected String name = "A";
        public A(){}
        public A(String name) { this.name += name; }
        public String getName(){ return name;}
    }

    public class B extends A implements Serializable{
        public B(){}
        public B(String name) {
            super(name);
            this.name += name;
        }

        public void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException{
            in.defaultReadObject();
            name = (String) in.readObject();
        }
        public void writeObject(ObjectOutputStream out) throws IOException{
            out.defaultWriteObject();
            out.writeObject(name);
        }
    }

    public static void main(String[] args)
            throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Solution solution = new Solution();
        B b = solution.new B("B2");
        System.out.println(b.name);

        oos.writeObject(b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

//        B b1 = (B)ois.readObject();
//        System.out.println(b1.name);
    }
}
