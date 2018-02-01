//: arrays/CopyingArrays.java
// Using System.arraycopy()
package com.javarush.task.experements.arrays.philosophyOfJava;
import java.util.*;

public class CopyingArrays {
  public static void main(String[] args) {
      int[] i = {1,2,3,4,5,6,7};
      System.out.println("i = " + Arrays.toString(i));

      int[] j = {101,102,103,104,105,106,107,108,109,110};
      System.out.println("j = " + Arrays.toString(j));

      // arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
      // srcPos + length < src.length // чтобы массив src (из которого берем) не закончился
      // destPos+ length < dest.length // чтоб массив dest (в который пишем) всё влезло
      // длина массива (в который пишем) не изменяется (т.е. знначения в нём перетираются)

      System.arraycopy(j, 6, i, 3, 4);
      System.out.println("j = " + Arrays.toString(j));
      System.out.println("i = " + Arrays.toString(i));
      System.out.println();

      int[] k = {3,3,3,3,3};
      System.arraycopy(i, 0, k, 0, k.length);
      System.out.println("k = " + Arrays.toString(k));


      Arrays.fill(k, 3);
      System.arraycopy(k, 0, i, 0, k.length);
      System.out.println("i = " + Arrays.toString(i));

      // Objects:
      Integer[] u = new Integer[10];
      Integer[] v = new Integer[5];
      Arrays.fill(u, new Integer(47));
      Arrays.fill(v, new Integer(99));
      System.out.println("u = " + Arrays.toString(u));
      System.out.println("v = " + Arrays.toString(v));
      System.arraycopy(v, 0, u, u.length/2, v.length);
      System.out.println("u = " + Arrays.toString(u));
  }
} /* Output:
i = [47, 47, 47, 47, 47, 47, 47]
j = [99, 99, 99, 99, 99, 99, 99, 99, 99, 99]
j = [47, 47, 47, 47, 47, 47, 47, 99, 99, 99]
k = [47, 47, 47, 47, 47]
i = [103, 103, 103, 103, 103, 47, 47]
u = [47, 47, 47, 47, 47, 47, 47, 47, 47, 47]
v = [99, 99, 99, 99, 99]
u = [47, 47, 47, 47, 47, 99, 99, 99, 99, 99]
*///:~
