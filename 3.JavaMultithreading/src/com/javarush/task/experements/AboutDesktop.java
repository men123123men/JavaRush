package com.javarush.task.experements;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class AboutDesktop {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        long start = System.nanoTime();


        if(Desktop.isDesktopSupported()){   // НЕ мгновенная операция(на этом моменте он что-то открывает)!!!!
            System.out.printf("%.3f секунды ушло на получение информации о Desktop %n",((double)System.nanoTime()-start)/1_000_000_000);
            Desktop desktop = Desktop.getDesktop();

            //desktop.browse(new URI("https://radio.yandex.ru/mood/calm"));
            //desktop.browseFileDirectory(new File("/Users/admin/Desktop/Если кончился инет/11)Java 8 Stream modifiers • Vertex Academy.pdf"));
            //desktop.open(new File("/Users/admin/Desktop/numbers2.txt"));
            //desktop.moveToTrash(new File("/Users/admin/Downloads/jsredir.html"));  // удаляет не спрашивая разрешения
            //desktop.print(new File("/Users/admin/Desktop/Persons 2"));  // пытается распечатать на принтере
            //desktop.isSupported()



//            System.out.printf("Прошло : %.3f секунд %n",((double)System.nanoTime()-start)/1_000_000_000);



        }
//        System.out.printf("Прошло : %.3f секунд %n",((double)System.nanoTime()-start)/1_000_000_000);

        String[] stres = {"1","2","3"};
        String str = "12345";

        System.out.println(Arrays.stream(stres).anyMatch(str::startsWith));
        System.out.println(Arrays.stream(stres).anyMatch(str::endsWith));
        //System.exit(0);

    }
}
