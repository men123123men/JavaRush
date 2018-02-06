package com.javarush.task.task31.task3109;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Properties;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) throws IOException, BackingStoreException {
//        Solution solution = new Solution();
//        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
//        properties.list(System.out);
//
//        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
//        properties.list(System.out);
//
//        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
//        properties.list(System.out);

//        Path path1 = Paths.get("/Users/admin/Downloads/20September/JavaRushTasks/JavaRushPlugin.properties");
////        Files.lines(path1).forEach(System.out::println);
//
//        Path path2 = Files.copy(path1,Paths.get(path1.getParent().toString()+"Modified "+path1.getFileName()), StandardCopyOption.REPLACE_EXISTING);
//        Properties properties = new Properties();
//        properties.load(Files.newInputStream(path2));
//
//
//
////        Desktop.getDesktop().browseFileDirectory(path2.toFile());
//
//        System.out.println("\t\t\t\t\t\tFile content:");
//        Files.lines(path2).forEach(System.out::println);
////        System.out.println("\t\t\t\t\t\tPropertes content");
////        properties.elements().asIterator().forEachRemaining(System.out::println);
//        System.out.println(properties.size());
//
//        properties.clear();
//
//        System.out.println("\t\t\t\t\t\tFile content after clean:");
//        Files.lines(path2).forEach(System.out::println);
////        System.out.println("\t\t\t\t\t\tPropertes content after clean");
////        properties.elements().asIterator().forEachRemaining(System.out::println);
//        System.out.println(properties.size());



        Preferences numberPref = Preferences.userNodeForPackage(Number.class);
        System.out.println("С классом \"сцеплены\" такие характеристики{"+Arrays.toString(numberPref.keys())+"}");
        numberPref.put("Моя характеристика","какое-то значение моей характеристики");
        System.out.println("С классом \"сцеплены\" такие характеристики{"+Arrays.toString(numberPref.keys())+"}");



    }

    public Properties getProperties(String fileName) {
        Properties result = new Properties();
        try(InputStream input = Files.newInputStream(Paths.get(fileName))){
            if(fileName.endsWith("xml"))
                result.loadFromXML(input);
            else
                result.load(input);
        } catch (IOException e) {
            result.clear();
        }
        return result;
    }
}
