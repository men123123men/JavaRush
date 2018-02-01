package com.javarush.task.experements.sockets;

import java.io.*;
import java.net.Socket;

public class Client_TechnoSphere {
    public static void main(String[] args){

        try(Socket socket = new Socket("localhost",5555);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream())){

            System.out.println("Подключился к серверу");

            Thread send    = new Thread(()->{
                String line;
                while (!Thread.currentThread().isInterrupted()) {
                    try{
                        line = keyboard.readLine();
                        if(line.equals("exit")) {
                            Thread.currentThread().interrupt();
                            continue;
                        }
                        out.writeUTF(line);
                    } catch (IOException e) {
                    e.printStackTrace();
                    }
                }
            });
            Thread receive = new Thread(()->{
                try{
                    while (true)
                        System.out.println(in.readUTF());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            receive.start();
            send.start();

            //receive.setDaemon(true);

        } catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
