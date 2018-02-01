package com.javarush.task.experements.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDokworkRu {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);

        Socket clientSocket = serverSocket.accept();

        InputStream in = clientSocket.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String line = null;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            System.out.flush();
        }

    }


}
