package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class Main {
    public static void main(String args[]) throws IOException {

        String filePath = "property.ini";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        Properties properties = new Properties();
        HashMap<String, String> arraySettings = new HashMap<String, String>();
        try {
            fileInputStream = new FileInputStream(filePath);
            properties.load(fileInputStream);
            Enumeration enumeration = properties.keys();
                                        //properties.setProperty("test", "test");
            while (enumeration.hasMoreElements()){
                String key = enumeration.nextElement().toString();
                arraySettings.put(key, properties.getProperty(key));
                                        //if (arraySettings.get(key).equals("test")) arraySettings.remove("test");
            }
            System.out.println(arraySettings);
            fileOutputStream = new FileOutputStream(filePath);
            properties.store(fileOutputStream, "no comment");
        } catch (FileNotFoundException e) {
            new File("property.ini").createNewFile();
            System.out.println("createNewFile");
            e.getMessage();
        } catch (InvalidPropertiesFormatException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        } finally {
            fileOutputStream.close();
            fileInputStream.close();
        }
    }
}
