//: arrays/CopyingArrays.java
// Using System.arraycopy()
package com.javarush.task.experements.arrays.philosophyOfJava;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;

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
    public static byte[] readAllBytes(RandomAccessFile input) throws IOException {
        int bufferSize = 10;
        byte[] result = new byte[0];
        byte[] buffer = new byte[bufferSize];
        int countOfReadBytes;

        while ((countOfReadBytes = input.read(buffer, 0, buffer.length)) > 0) {
            byte[] newResult = new byte[result.length + countOfReadBytes];
            System.arraycopy(result, 0, newResult, 0, result.length);
            System.arraycopy(buffer, 0, newResult, result.length, countOfReadBytes);
            result = newResult;
        }

        return  result;
    }

    public static byte[] readAllBytes(InputStream in) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int bufferSize = 10;
        byte[] buffer = new byte[bufferSize];
        int count;

        while ((count = in.read(buffer))>0)
            baos.write(buffer,0,count);

        return baos.toByteArray();
    }

}
