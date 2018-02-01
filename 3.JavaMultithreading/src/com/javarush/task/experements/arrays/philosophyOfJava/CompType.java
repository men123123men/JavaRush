package com.javarush.task.experements.arrays.philosophyOfJava;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;

public class CompType {
    public static void main(String[] args){
        Element[] elements = {new Element(4,"d"),new Element(5,"c"), new Element(6,"e") };
        Arrays.sort(elements);

        System.out.println(Arrays.toString(elements));


    }


}
class Element implements Comparable<Element>{
//    Comparator<Element> comparator= (e1,e2)->{
//        int first=Integer.compare(e1.a,e2.a);
//        return first==0? e1.str.compareTo(e2.str): first;
//    };
    Comparator<Element> comparator2 =
        Comparator.comparing(Element::getA,Comparator.reverseOrder())
                .thenComparing(Element::getStr,String.CASE_INSENSITIVE_ORDER);

    @Override
    public int compareTo(@NotNull Element o) {
        //return Integer.compare(a,o.a);
        //return str.compareTo(o.str);
        //return Integer.compare(a,o.a)==0?str.compareTo(o.str):Integer.compare(a,o.a);
        return comparator2.compare(this,o);
    }

    int a;

    public Element(int a, String str) {
        this.a = a;
        this.str = str;
    }

    String str;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Element{" +
                "a=" + a +
                ", str='" + str + '\'' +
                '}';
    }
}