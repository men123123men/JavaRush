package com.javarush.task.experements.serialization.philosophy;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Login implements Serializable {
    private Date date;
    private String username;
    private transient String password;
    public Login(String name, String pwd) {
        username = name;
        password = pwd;
        date = new Date();
    }
    public String toString() {
        return "logon info: \n   username: " + username +
                "\n   date: " + date + "\n   password: " + password+"\n";
    }

    public static void main(String[] args) throws Exception {
        Login a = new Login("Hulk", "myLittlePony");
        System.out.println("logon a = " + a);
        File file = new File("/Users/admin/Downloads/20September/JavaRushTasks/3.JavaMultithreading/src/com/javarush/task/experements/serialization/philosophy", "Login.out");

        ObjectOutputStream o = new ObjectOutputStream( new FileOutputStream(file));
        o.writeObject(a);
        o.close();


        TimeUnit.SECONDS.sleep(1); // Delay
        System.out.println("Recovering object at " + new Date());


        ObjectInputStream in = new ObjectInputStream( new FileInputStream(file));
        a = (Login)in.readObject();
        System.out.println("\nlogon a = " + a);
    }
}
