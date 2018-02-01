package com.javarush.task.experements.generics.philosophyOfJava;

public class LinkedStack<T> {


    private static class Node<U>{
        U item;
        Node<U> next;

        private Node() {
            item =null;
            next=null;
        }
        public Node(U item, Node<U> next){
            this.item = item;
            this.next = next;
        }
        boolean end() {
            return item ==null && next==null;
        }
    }
    private Node<T> top = new Node<>();
    public void push(T item){
        top = new Node<T>(item, top);
    }
    public T pop(){
        T result = top.item;
        if(!top.end())
            top = top.next;
        return result;
    }
    public static void main(String[] args) throws InterruptedException {
        LinkedStack<String> lss = new LinkedStack<>();
        for(String string: ("12 \n23 \t34  45").split("\\s+"))
            lss.push(string);
        String currentStr;
        while ((currentStr =lss.pop())!=null)
            System.out.println(currentStr);



    }

}
