package com.javarush.task.experements.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerQuizfulNet {

    public static void main(String[] ar) throws IOException {

        ServerSocket ss = new ServerSocket(7777); // может быть любое число от 1025 до 65535

        Socket socket = ss.accept();

        InputStream sin = socket.getInputStream();
        OutputStream sout = socket.getOutputStream();

        DataInputStream in = new DataInputStream(sin);
        DataOutputStream out = new DataOutputStream(sout);


        String line = null;
        while(true) {


            line = in.readUTF();

            out.writeUTF(line.toUpperCase());
            out.flush();
//
//            line = new String(sin.readAllBytes());
//
//            System.out.println(line);
//            sout.write(line.getBytes());
//            sout.flush();
        }
    }

}
