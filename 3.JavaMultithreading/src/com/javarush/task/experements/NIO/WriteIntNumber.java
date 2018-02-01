package com.javarush.task.experements.NIO;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

public class WriteIntNumber {
    public static void main(String[] args){


        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
        //buffer.order(ByteOrder.LITTLE_ENDIAN);// если захотим вдруг перевернуть порядок байт

        for(int i=0; i<=260; i++){
            buffer.putInt(i);
            System.out.printf("%3d) %10s%18s%n",i,Integer.toBinaryString(i), Arrays.toString(buffer.array()));
            buffer.clear();
        }

        IntBuffer intBuffer =  IntBuffer.allocate(5);

        intBuffer.put(Integer.MAX_VALUE);
        intBuffer.put(Integer.MIN_VALUE);

        System.out.println(Arrays.toString(intBuffer.array()));


    }



}
