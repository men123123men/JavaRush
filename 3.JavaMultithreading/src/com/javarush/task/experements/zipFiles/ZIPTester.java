package com.javarush.task.experements.zipFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.*;

public class ZIPTester {

    public static File pack(String dirNameString) throws IOException {
        Path dir = Paths.get(dirNameString);

        if (Files.notExists(dir) || !Files.isDirectory(dir))
            throw new FileNotFoundException(dir + " not found");

        // путь к zip-файлу(он будет там же где и папка подлежащая архивации)
        File zipFile = new File(dir+".zip");

        //if (zipFile.exists()) zipFile.delete();

        try(Stream<Path> pathStream = Files.walk(dir).filter(Files::isRegularFile);
            FileOutputStream fos   = new FileOutputStream(zipFile);
            ZipOutputStream zos    = new ZipOutputStream(fos)) {

            zos.setLevel(Deflater.BEST_SPEED);

            // для каждеого файла в директории подлежащей архивации нужно:
            // 1) "приделать" к ZipOutputStream очередную запись ZipEntry с путем к файлу
            // 2) "залить" в ZipOutputStream содержимое этого файла
            for(Path currentFile: pathStream.collect(Collectors.toList())){
                zos.putNextEntry(new ZipEntry(dir.relativize(currentFile).toString()));
                Files.copy(currentFile,zos);
                zos.closeEntry();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return zipFile;
    }

    public static File unPack(File inputZIPFile) throws FileNotFoundException {

        if (!inputZIPFile.exists()||!inputZIPFile.isFile()||!inputZIPFile.toString().endsWith(".zip"))
            throw new FileNotFoundException(inputZIPFile + " bed zip-file!");

        // путь к директории в которую будет все складываться
        File dir = new File(inputZIPFile.toString().replace(".zip", Integer.toString(new Random().nextInt(1000))));

        // нам нужен ZipFile для того чтобы:
        // 1) получить набор всех ZipEntry
        // 2) для получения InputStream "сцепленного" с каждой ZipEntry
        //    с помощью которых мы и запишем все в файлы
        try (ZipFile zFile = new ZipFile(inputZIPFile)) {
            for(ZipEntry entry: zFile.stream().filter(e->!e.isDirectory()).collect(Collectors.toList())){
                File destFile = new File(dir, entry.getName()); // определение абсолютного пути файла из каждой записи
                destFile.getParentFile().mkdirs();              // создание папки для каждого файла(если таковая еще не создана)
                Files.copy(zFile.getInputStream(entry),destFile.toPath()); // распаковывание записи
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dir;
    }

    public static void addFileToExistingZip(Path zipPath, Path filePath) throws IOException {

        ZipEntry fileZipEnty = new ZipEntry(Paths.get("new",filePath.getFileName().toString()).toString());

        Map<String,ByteArrayOutputStream> zipContent = new HashMap<>();
        ZipEntry currentZipEnty;
        ByteArrayOutputStream currentBytes;

        try(ZipInputStream in = new ZipInputStream(Files.newInputStream(zipPath))){
            while ((currentZipEnty = in.getNextEntry())!=null) {
                if(currentZipEnty.getName().equals(fileZipEnty.getName()))
                    continue;
                currentBytes = new ByteArrayOutputStream();
                in.transferTo(currentBytes);

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

    public static void addFileToExistingZipUsingFileSystem(Path zipPath, Path filePath) throws IOException{
        Path newFilePath = Paths.get("new", filePath.getFileName().toString());
        Path tempZip = Files.createTempFile("test", ".zip");

        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(tempZip));
             ZipFile zipFile = new ZipFile(zipPath.toString())) {

            for (ZipEntry current : zipFile.stream().filter(e -> !e.isDirectory()).collect(Collectors.toList())) {

                zos.putNextEntry(current);
                zipFile.getInputStream(current).transferTo(zos);
                zos.closeEntry();

            }
            zos.putNextEntry(new ZipEntry(newFilePath.toString()));
            Files.copy(filePath, zos);
            zos.closeEntry();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Files.copy(tempZip, zipPath, StandardCopyOption.REPLACE_EXISTING);
        Files.deleteIfExists(tempZip);
    }

    public static void main(String[] args) throws IOException {
        String dirNameString = "/Users/admin/Desktop/Если кончился инет";

        File zipFile      =   pack(dirNameString);
//        File resultFolder = unPack(zipFile);

//        Files.walk(resultFolder.toPath()).forEach(System.out::println);

//        if (Desktop.isDesktopSupported())
//            Desktop.getDesktop().open(resultFolder);

    }
}

