package com.javarush.task.experements.zipFiles;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPTester {
    public static void main(String[] args) throws IOException {

        String urlString = "https://javarush.ru/testdata/secretPasswords.txt";
        System.out.printf("%-51s : %s%n","Скачиваем файл",urlString);

        Path compressedFile = compressURLfile(urlString);
        System.out.printf("%-41s (%d байт) : %s%n","Архивируаем и сохраняем во временный файл",Files.size(compressedFile),compressedFile);

        Path deCompressedFile = decompressFile(compressedFile);
        System.out.printf("%-41s (%d байт) : %s%n%n","РазАрхивировываем и получаем файл",Files.size(deCompressedFile),deCompressedFile);

        System.out.println("Содержимое которого :");
        Files.lines(deCompressedFile).forEach(System.out::println);


        if (Desktop.isDesktopSupported())
            Desktop.getDesktop().open(deCompressedFile.toFile());










    }

    public static Path compressURLfile(String urlString){
        Path compressedFile=null;
        GZIPOutputStream gzipOutputStream = null;

        try(InputStream inputStream = new URL(urlString).openStream()){

            compressedFile = Files.createTempFile("3333",urlString.replaceAll("(.*/)","")+".gz");

            gzipOutputStream = new GZIPOutputStream(Files.newOutputStream(compressedFile));

            inputStream.transferTo(gzipOutputStream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                gzipOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return compressedFile;
    }

    public static Path decompressFile (Path gzipFile) {

        Path decompressedFile = null;
        String fileName = System.getProperty("user.dir")+ File.separator+gzipFile.getFileName().toString().replaceAll("(\\d)|(.gz)","");

        try(GZIPInputStream input = new GZIPInputStream(Files.newInputStream(gzipFile))){

            decompressedFile = Paths.get(fileName);

            Files.deleteIfExists(decompressedFile);

            Files.copy(input,decompressedFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return decompressedFile;
    }







}
