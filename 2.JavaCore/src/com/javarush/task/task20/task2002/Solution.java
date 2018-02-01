package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("/Users/admin/Desktop/your_file_name.txt", null);
            //System.out.println(your_file_name.getPath());
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User user = new User();
            user.setFirstName("Rubi");
            user.setLastName("Rail");
//            user.setBirthDate(new Date(858944516168L));
            user.setMale(true);
            user.setCountry(User.Country.OTHER);

            User user1 = new User();
            user1.setFirstName("Vasa1");
            user1.setLastName("Peta1");
            user1.setBirthDate(new Date(150894456163L));
//            user1.setMale(false);
            user1.setCountry(User.Country.RUSSIA);

            User user3 = new User();
            user3.setFirstName("Solo");
            user3.setLastName("Han");
            user3.setBirthDate(new Date(158944516169L));
            user3.setMale(true);
//            user3.setCountry(User.Country.UKRAINE);

            javaRush.users.add(user);
            javaRush.users.add(user1);
            javaRush.users.add(user3);



            javaRush.save(outputStream);
            outputStream.flush();

            javaRush.users.forEach(System.out::println);


            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            loadedObject.users.forEach(System.out::println);


            System.out.println("\n\njavaRush.equals(loadedObject) = "+javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

public void save(OutputStream outputStream) throws Exception {
    //implement this method - реализуйте этот метод
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
    for(User user:users){
        writer.write(user.getFirstName()==null? "null" :user.getFirstName());                              writer.write(";");
        writer.write(user.getLastName()==null? "null" :user.getLastName());                                writer.write(";");
        writer.write(user.getBirthDate()==null? "null" :Long.toString(user.getBirthDate().getTime()));     writer.write(";");
        writer.write(Boolean.toString(user.isMale()));                                                     writer.write(";");
        writer.write(user.getCountry()==null? "null" :user.getCountry().getDisplayedName());               writer.write("\n");
    }
    writer.flush();
}

public void load(InputStream inputStream) throws Exception {
    //implement this method - реализуйте этот метод
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    String currentLine;
    User currentUser;
    while (reader.ready()){
        currentLine = reader.readLine();
        String[] str = currentLine.split(";");
        currentUser = new User();
        if(!str[0].equals("null")) currentUser.setFirstName(str[0]);
        if(!str[1].equals("null")) currentUser.setLastName(str[1]);
        if(!str[2].equals("null")) currentUser.setBirthDate(new Date(Long.parseLong(str[2])));
        currentUser.setMale(Boolean.parseBoolean(str[3]));
        switch (str[4]){
            case "Ukraine": currentUser.setCountry(User.Country.UKRAINE); break;
            case "Russia":  currentUser.setCountry(User.Country.RUSSIA);  break;
            case "Other":   currentUser.setCountry(User.Country.OTHER);   break;
        }
        this.users.add(currentUser);
    }
}
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
