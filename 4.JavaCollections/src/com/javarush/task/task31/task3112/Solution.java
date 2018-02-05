package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws Exception {
        String fileNameWindows = "D:/MyDownloads";
        String fileNameMacOS = "/Users/admin/Desktop/numbers.txt";

        String test = "https://javarush.ru/testdata/secretPasswords.txt";
//        URL url = new URL(test);
//        String result = Paths.get(url.getPath()).getFileName().toString();
//        System.out.println(Paths.get(url.getPath()).getFileName());


        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get(fileNameWindows));

        for (String line : Files.readAllLines(passwords))
            System.out.println(line);
    }


    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException, URISyntaxException {
        URL url = new URL(urlString);

        //Path filePath = Paths.get(downloadDirectory.toString() + "/" + fileName);

        Path tempFilePath = Files.createTempFile(Paths.get(url.getPath()).getFileName().toString(),null);

        Files.copy(url.openStream(),tempFilePath, StandardCopyOption.REPLACE_EXISTING);

        return Files.move(tempFilePath,downloadDirectory);

    }










//    public static Path downloadFile(String urlString, Path downloadDirectory) {
//
//        try(BufferedInputStream input = new BufferedInputStream(new URL(urlString).openStream());
//            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(downloadDirectory.toFile()))){
//
//////////        тупо в цикле считывают и записывают (появились в JDK 9)
////            output.write(input.readAllBytes());
////            input.transferTo(output); // return колличество байт
//
//
////            byte[] buffer = new byte[1024];
////            int length =0;
////            while((length=input.read(buffer))!=-1)
////                output.write(buffer,0,length);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return downloadDirectory;
//    }
}
