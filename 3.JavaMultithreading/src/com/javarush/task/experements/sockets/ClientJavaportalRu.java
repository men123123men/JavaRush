package com.javarush.task.experements.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientJavaportalRu {

    public static void main(String[] args) throws IOException{


        Socket fromserver  = new Socket("localhost",4444);

        BufferedReader in  = new BufferedReader(new InputStreamReader(fromserver.getInputStream()));
        PrintWriter out = new PrintWriter(fromserver.getOutputStream(),true);


        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String fuser,fserver;

        while ((fuser = keyboard.readLine())!=null) {
            out.println(fuser);
            fserver = in.readLine();
            System.out.println(fserver);

//            if (fuser.equalsIgnoreCase("close")) break;
//            if (fuser.equalsIgnoreCase("exit")) break;
        }


        keyboard.close();
        fromserver.close();
    }

}
