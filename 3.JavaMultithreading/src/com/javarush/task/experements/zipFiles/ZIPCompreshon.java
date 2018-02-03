package com.javarush.task.experements.zipFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ZIPCompreshon {

    // /Users/admin/Desktop/XML Sitemap.xml

    public static void main(String[] args) throws IOException {
        // как и в прошлый статьях, мы будем использовать для сжатия карту моего сайта
        String file     = "/Users/admin/Desktop/XML Sitemap.xml";
        String gzipFile = "/Users/admin/Desktop/XML Sitemap.xml.gz";
        String newFile  = "/Users/admin/Desktop/new_sitemap.xml";

        // сжатие файла с помощью GZIP
        compressGzipFile(file, gzipFile);

        // распаковка файла с помощью GZIP
        decompressGzipFile(gzipFile, newFile);

        Files.lines(Paths.get(newFile))
                .forEach(System.out::println);
    }

    // архивация файла с помощью GZIP
    private static void compressGzipFile(String file, String gzipFile) {

        try(FileInputStream fis     = new FileInputStream(file);
            GZIPOutputStream gzipOS = new GZIPOutputStream(new FileOutputStream(gzipFile))){

            fis.transferTo(gzipOS);
            gzipOS.write(fis.readAllBytes());

            Files.copy(Paths.get(file), gzipOS);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // распаковка файла с помощью GZIP
    private static void decompressGzipFile(String gzipFile, String newFile) {

        try (GZIPInputStream gis    = new GZIPInputStream(new FileInputStream(gzipFile));
             FileOutputStream fos   = new FileOutputStream(newFile)) {

//            gis.transferTo(fos);
//            fos.write(gis.readAllBytes());

            Files.copy(gis,Paths.get(newFile));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
