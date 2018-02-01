package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = null;
        Reader fr = null;
        Writer fw = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            fr = new FileReader(reader.readLine());
            fw = new FileWriter(reader.readLine());
int count=1;
while (fr.ready())
    if (count++ % 2 == 0)
        fw.write(fr.read());
int d;
for (int i = 1; fr.ready() ; i++) {
    d=fr.read();
    if(i%2==0){
        fw.write(d);
    }
}



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                reader.close();
                fr.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
