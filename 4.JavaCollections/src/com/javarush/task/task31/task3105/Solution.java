package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
    //        Первый аргумент - полный путь к файлу fileName.
    //        Второй аргумент - путь к zip-архиву.
    //        Добавить файл (fileName) внутрь архива в директорию 'new'.
    //        Если в архиве есть файл с таким именем, то заменить его.

        String fileName = args[0];
        String zipFileName = args[1];

    //        String dirNameString = "/Users/admin/Desktop/Если кончился инет";
    //        File zipFile      =   pack(dirNameString);
    //        String fileName = "/Users/admin/Desktop/иерархия классов InputStream.png";
    //        String zipFileName = zipFile.toString();



        // сделанно через файловую систему(а надо было через оперативку)
//        Path zipFilePath = Paths.get(zipFileName);
//        Path filePath = Paths.get(fileName);
//        Path newFilePath = Paths.get("new", filePath.getFileName().toString());
//        Path tempZip = Files.createTempFile("test", ".zip");
//
//        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(tempZip));
//             ZipFile zipFile = new ZipFile(zipFilePath.toString())) {
//
//            for (ZipEntry current : zipFile.stream().filter(e -> !e.isDirectory()).collect(Collectors.toList())) {
//
//                zos.putNextEntry(current);
//                zipFile.getInputStream(current).transferTo(zos);
//                zos.closeEntry();
//
//            }
//            zos.putNextEntry(new ZipEntry(newFilePath.toString()));
//            Files.copy(filePath, zos);
//            zos.closeEntry();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Files.copy(tempZip, zipFilePath, StandardCopyOption.REPLACE_EXISTING);

            Path      zipPath = Paths.get(zipFileName);
            Path filePath = Paths.get(fileName);
            ZipEntry fileZipEnty = new ZipEntry(Paths.get("new",filePath.getFileName().toString()).toString());

            Map<String,ByteArrayOutputStream> zipContent = new HashMap<>();
            ZipEntry currentZipEnty;
            ByteArrayOutputStream currentBytes;

            try(ZipInputStream in = new ZipInputStream(Files.newInputStream(zipPath))){
                while ((currentZipEnty = in.getNextEntry())!=null) {
                    if(currentZipEnty.getName().equals(fileZipEnty.getName()))
                        continue;
                    currentBytes = makeByteArrayOutputStream(in);
                    zipContent.put(currentZipEnty.getName(), currentBytes);
                }
            }

            try(ZipOutputStream out = new ZipOutputStream(Files.newOutputStream(zipPath))){
                for(Map.Entry<String,ByteArrayOutputStream> pair: zipContent.entrySet()){
                    currentZipEnty = new ZipEntry(pair.getKey());
                    currentBytes = pair.getValue();

                    out.putNextEntry(currentZipEnty);
                    currentBytes.writeTo(out);
                    out.closeEntry();
                }
                out.putNextEntry(fileZipEnty);
                Files.copy(filePath,out);
                out.closeEntry();
            }

    }

    public static ByteArrayOutputStream makeByteArrayOutputStream(InputStream in) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int countWritedBytes;

        while ((countWritedBytes = in.read(buffer)) > 0)
            result.write(buffer, 0, countWritedBytes);

        return result;
    }
}
