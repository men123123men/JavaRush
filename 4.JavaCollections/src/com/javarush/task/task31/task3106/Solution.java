package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.Arrays;
import java.util.Vector;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String resultFileName = args[0];

        String[] fileNamePart = Arrays.stream(args).skip(1).sorted().toArray(String[]::new);

        Vector<InputStream> inputStreamVector = new Vector<>();

        for (String str: fileNamePart)
            inputStreamVector.add(new FileInputStream(str));

        try(FileOutputStream fileOutputStream = new FileOutputStream(resultFileName);
            ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(inputStreamVector.elements()))){
            streamTransfer(zipInputStream,fileOutputStream);
            zipInputStream.closeEntry();
        }

    }
    public static void streamTransfer(InputStream in, OutputStream out) throws IOException {
        byte[] buffer =new byte[1024];
        int countOfBytes;
        while ((countOfBytes = in.read(buffer))>0) {
            out.write(buffer, 0, countOfBytes);
            out.flush();
        }
    }
}
