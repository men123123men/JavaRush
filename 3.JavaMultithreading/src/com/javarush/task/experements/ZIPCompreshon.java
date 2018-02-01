package com.javarush.task.experements;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ZIPCompreshon {

    // /Users/admin/Desktop/XML Sitemap.xml

    public static void main(String[] args) {
        // как и в прошлый статьях, мы будем использовать для сжатия карту моего сайта
        String file     = "/Users/admin/Desktop/XML Sitemap.xml";
        String gzipFile = "/Users/admin/Desktop/XML Sitemap.xml.gz";
        String newFile  = "/Users/admin/Desktop/new_sitemap.xml";

        // сжатие файла с помощью GZIP
        compressGzipFile(file, gzipFile);

        // распаковка файла с помощью GZIP
        decompressGzipFile(gzipFile, newFile);



        try{
            Files.lines(Paths.get(newFile))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // архивация файла с помощью GZIP
    private static void compressGzipFile(String file, String gzipFile) {

        try(FileInputStream fis     = new FileInputStream(file);
            GZIPOutputStream gzipOS = new GZIPOutputStream(new FileOutputStream(gzipFile))){

            byte[] buffer = new byte[1024];
            int len;

            while((len=fis.read(buffer)) != -1)
                gzipOS.write(buffer, 0, len);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // распаковка файла с помощью GZIP
    private static void decompressGzipFile(String gzipFile, String newFile) {

        try (GZIPInputStream gis    = new GZIPInputStream(new FileInputStream(gzipFile));
             FileOutputStream fos   = new FileOutputStream(newFile)) {

            byte[] buffer = new byte[1024];
            int len;

            while((len = gis.read(buffer)) != -1)
                fos.write(buffer, 0, len);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
