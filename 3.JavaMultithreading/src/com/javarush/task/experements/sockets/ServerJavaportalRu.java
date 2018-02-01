package com.javarush.task.experements.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerJavaportalRu {  // работает с nc localhost 4444 ...
    public static void main(String[] args) throws IOException {

        ServerSocket servers = new ServerSocket(4444);

        while (true) {
            Socket clientSoket = servers.accept();
            new Thread(()-> echoMake(clientSoket)).start();
        }

    }

    private static void echoMake(Socket clientSoket) {

        try(clientSoket) {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSoket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSoket.getOutputStream(), true);

            String input, output;

            while ((input = in.readLine()) != null) {
                if (input.equalsIgnoreCase("exit")) break;
                System.out.printf("%d %d ",clientSoket.getPort(),clientSoket.getLocalPort());
                System.out.println(input);
                output = "S ::: " + input;
                out.println(output);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
