package com.javarush.task.task20.task2003;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        FileInputStream fis = new FileInputStream (new Scanner(System.in).nextLine());
        load(fis);
    }
    public void save(OutputStream outputStream) throws Exception {
        Properties propFromMap = new Properties();
        properties.forEach((key, value) -> propFromMap.setProperty(key,value));
        //propFromMap.putAll(properties);

        propFromMap.store(outputStream, "no comment");
    }
    public void load(InputStream inputStream) throws Exception {
        Properties propFromIS = new Properties();
        propFromIS.load(inputStream);
        propFromIS.forEach((key, value) -> properties.put((String) key,(String) value));
        //properties.putAll(new Hashtable<String ,String >(propFromIS));

    }

    public static void main(String[] args) throws Exception{
        FileOutputStream fos = new FileOutputStream("your_file_name.txt");
        FileInputStream fis = new FileInputStream("JavaRushPlugin.properties");
        Solution sol = new Solution();
        sol.load(fis);
        Solution.properties.forEach((k,v)-> System.out.printf("Key :%25s\t\tValue : %s\n",k,v));
        sol.save(fos);
    }
}
