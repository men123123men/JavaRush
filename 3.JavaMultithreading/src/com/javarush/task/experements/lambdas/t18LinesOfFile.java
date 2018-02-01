package com.javarush.task.experements.lambdas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class t18LinesOfFile {
    public static void main(String[] aargs){
        String faleName = "/Users/admin/Desktop/3 слова.txt";
        Path path = Paths.get(faleName);

        List<String> lines = new ArrayList<>();


        try(BufferedReader bfr = new BufferedReader(new FileReader(faleName));
            BufferedReader bfrFromFiles = Files.newBufferedReader(path);
            Scanner fileScanner = new Scanner(path);
            Stream<String> linesFromFiles = Files.lines(path)
        ){

            while(bfr.ready())
                lines.add(bfr.readLine());
            lines.clear();


            while(bfrFromFiles.ready())
                lines.add(bfrFromFiles.readLine());
            lines.clear();


            while ((fileScanner.hasNextLine()))
                lines.add(fileScanner.nextLine());
            lines.clear();


            //lines.addAll(lineStream.collect(Collectors.toList()));
            lines = linesFromFiles.collect(Collectors.toList());
            lines.clear();

            lines = bfr.lines().collect(Collectors.toList());
            lines.clear();

        }catch(IOException exc){
            exc.printStackTrace();
        }












        lines.forEach(System.out::println);

    }
}
