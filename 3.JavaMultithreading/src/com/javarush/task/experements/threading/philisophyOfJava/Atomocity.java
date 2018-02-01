package com.javarush.task.experements.threading.philisophyOfJava;

import java.io.IOException;

public class Atomocity {
    public Atomocity() {
        super();
    }

    int i;
    int a;
    int b;
    void foo(){a=i++;}
    void bar(){b=++i;}

    // cd /Users/admin/Downloads/20September/JavaRushTasks/out/production/3.JavaMultithreading/com/javarush/task/experements/threading/philisophyOfJava

    // javap -c Atomocity
   public static void main(String[] args) throws IOException, InterruptedException {
       System.out.println("Ok");
//        // указываем в конструкторе ProcessBuilder,
//        // что нужно запустить программу ls с параметрами -l /dev
//        ProcessBuilder procBuilder = new ProcessBuilder("ls","-l","/dev");
//
//        // перенаправляем стандартный поток ошибок на
//        // стандартный вывод
//        procBuilder.redirectErrorStream(true);
//
//        // запуск программы
//        Process process = procBuilder.start();
//
//        // читаем стандартный поток вывода
//        // и выводим на экран
//        InputStream stdout = process.getInputStream();
//        InputStreamReader isrStdout = new InputStreamReader(stdout);
//        BufferedReader brStdout = new BufferedReader(isrStdout);
//
//        String line = null;
//        while((line = brStdout.readLine()) != null) {
//            System.out.println(line);
//        }
//
//        // ждем пока завершится вызванная программа
//        // и сохраняем код, с которым она завершилась в
//        // в переменную exitVal
//        int exitVal = process.waitFor();
//
    }
}
