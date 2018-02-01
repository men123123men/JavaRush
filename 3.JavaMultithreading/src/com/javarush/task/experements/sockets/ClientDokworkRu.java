package com.javarush.task.experements.sockets;

import java.io.*;
import java.net.Socket;

public class ClientDokworkRu {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 9999);

        OutputStream outFromSocket = socket.getOutputStream();

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(outFromSocket));


        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String line = null;

        while ((line = keyboard.readLine()) != null) {
            out.write(line + "\n");
            out.flush();
        }

    }
}
