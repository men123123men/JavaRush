package com.javarush.task.experements.sockets;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_TechnoSphere {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(5555);

        Socket socket = serverSocket.accept();
        System.out.println("Клиент подключился");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String line;
        while (true) {
            if(socket.isClosed())
                System.out.println("Отвалился");
            line = in.readUTF();
            System.out.println(line);
            out.writeUTF(line);
            out.flush();
        }
    }
}
