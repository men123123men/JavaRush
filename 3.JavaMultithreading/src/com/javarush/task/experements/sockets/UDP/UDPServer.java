package com.javarush.task.experements.sockets.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {

        final int port = 5555;

        try(DatagramSocket socket = new DatagramSocket(port)) { // встаем на прослушку

            DatagramPacket packet = new DatagramPacket(new byte[256],256);

            while (true) {
                socket.receive(packet); //блокируемся и ждем пакета
                String massage = new String(packet.getData(),0,packet.getLength());
                System.out.printf("Пришедшая от  %s строка: %s",packet.getSocketAddress(),massage);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
