package com.javarush.task.experements.sockets.UDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {

        final int port = 5555;

        try(DatagramSocket socket = new DatagramSocket()) {

            InetSocketAddress socketAddress = new InetSocketAddress("localhost",port);
            DatagramPacket packet = new DatagramPacket(new byte[256],256,socketAddress);

            Scanner scanner = new Scanner(System.in);
            String massage;
            while (true) {
                massage = scanner.nextLine()+"\n";
                packet.setData(massage.getBytes());
                socket.send(packet);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
