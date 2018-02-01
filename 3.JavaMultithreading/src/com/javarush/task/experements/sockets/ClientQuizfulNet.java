package com.javarush.task.experements.sockets;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ClientQuizfulNet {

    public static void main(String[] ar) throws IOException {
        String address = "127.0.0.1";

        InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес.

        Socket socket = new Socket(ipAddress, 7777);

        InputStream sin = socket.getInputStream();
        OutputStream sout = socket.getOutputStream();

        DataInputStream in = new DataInputStream(sin);
        DataOutputStream out = new DataOutputStream(sout);


        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        while (true) {

            line = keyboard.readLine();

            out.writeUTF(line);
            out.flush();

            line = in.readUTF();

            System.out.println(line);

        }

    }


}
