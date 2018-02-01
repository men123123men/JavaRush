package com.javarush.task.task18.task1812;

import java.io.IOException;
import java.util.Scanner;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    AmigoOutputStream stream;
    public QuestionFileOutputStream(AmigoOutputStream stream) { this.stream = stream; }

    @Override
    public void flush() throws IOException { stream.flush(); }

    @Override
    public void write(int b) throws IOException { stream.write(b); }

    @Override
    public void write(byte[] b) throws IOException { stream.write(b); }

    @Override
    public void write(byte[] b, int off, int len) throws IOException { stream.write(b,off,len); }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        if (new Scanner(System.in).nextLine().equals("Д"))
            stream.close();
    }
}

