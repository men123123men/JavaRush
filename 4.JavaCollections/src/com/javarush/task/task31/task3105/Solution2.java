package com.javarush.task.task31.task3105;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.*;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        Path folderPath = Paths.get("/Users/admin/Desktop/Если кончился инет");
        int randomNumber = new Random().nextInt(1000);

        Path zipFolderPath = Paths.get(folderPath.toString()+Integer.toString(randomNumber)+".zip");

// этот кусок кода отвечает за архивацию
        try(ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFolderPath))){
            for(Path current:Files.walk(folderPath).filter(Files::isRegularFile).collect(Collectors.toList())){
                zipOutputStream.putNextEntry(new ZipEntry(folderPath.relativize(current).toString()));
                Files.copy(current,zipOutputStream);
                zipOutputStream.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

// этот кусок кода отвечает за РАЗархивацию
//        Path folderForUnzip = Paths.get("/Users/admin/Desktop/Если кончился инет(тестовый разархив)");
//
//        try(ZipFile zipFIle = new ZipFile(zipFolderPath.toString())) {
//            Path currentFile;
//            for(ZipEntry current: zipFIle.stream().filter(e->!e.isDirectory()).collect(Collectors.toList())){
//                currentFile = Paths.get(folderForUnzip.toString(),current.getName());
//                currentFile.toFile().getParentFile().mkdirs();
//                zipFIle.getInputStream(current).transferTo(Files.newOutputStream(currentFile));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

// эту мы "редактируем" архив посредством создания нового
        Path filePath = Paths.get("/Users/admin/Desktop/Оглавление у Шилдта.jpg");
        Path newFilePath = Paths.get("new",filePath.getFileName().toString());

        Path tempZip = Files.createTempFile("test",".zip");


        try(ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(tempZip));
            ZipFile zipFile = new ZipFile(zipFolderPath.toString())){

            for(ZipEntry current: zipFile.stream().filter(e->!e.isDirectory()).collect(Collectors.toList())){

                zipOutputStream.putNextEntry(current);
                streamTransfer(zipFile.getInputStream(current),zipOutputStream);
                zipOutputStream.closeEntry();

            }
            zipOutputStream.putNextEntry(new ZipEntry(newFilePath.toString()));
            Files.copy(filePath,zipOutputStream);
            zipOutputStream.closeEntry();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Files.copy(tempZip,zipFolderPath, StandardCopyOption.REPLACE_EXISTING);

    }
    public static long streamTransfer(InputStream in, OutputStream out) throws IOException {
        long allWritedButes=0;

        byte[] buffer = new byte[1024];
        int countWritedBytes;

        while (in.available()>0) {
            countWritedBytes = in.read(buffer);
            out.write(buffer,0,countWritedBytes);
            allWritedButes+=countWritedBytes;
        }
        return allWritedButes;
    }

}
