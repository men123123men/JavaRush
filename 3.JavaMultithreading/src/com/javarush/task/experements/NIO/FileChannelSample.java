package com.javarush.task.experements.NIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelSample {
    public static void main(String[] args){
        Path path1 = Paths.get("/Users/admin/Desktop/your_file_name.txt");
        Path path2 = Paths.get("/Users/admin/Desktop/your_file_name2.txt");

//        StandardOpenOption.CREATE       если файл уже есть ничего не произойдет
//        StandardOpenOption.CREATE_NEW;  если файл уже усть throw new FileAlreadyExistsException()

        try(FileChannel input  = FileChannel.open(path1, StandardOpenOption.READ);
            FileChannel output = FileChannel.open(path2, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            ByteBuffer buffer = ByteBuffer.allocate(3);

            while (input.read(buffer) != -1) {
                buffer.flip();

//            while (buffer.remaining()>0)
//                output.write(buffer);
//            buffer.clear();

                output.write(buffer);
                buffer.compact();
            }

            Files.lines(path2).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
