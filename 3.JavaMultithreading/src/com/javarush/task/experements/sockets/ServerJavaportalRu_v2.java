package com.javarush.task.experements.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ServerJavaportalRu_v2 {

    private final int port;
    private final ExecutorService executorService;
    private List<Socket> clientSockets;
    private Semaphore semaphoreForSockets;

    public ServerJavaportalRu_v2(int port, int threadsNumber) {
        this.port = port;
        executorService = Executors.newFixedThreadPool(threadsNumber);
        clientSockets = new ArrayList<>();
        semaphoreForSockets = new Semaphore(threadsNumber-2);
    }

    public static void main(String[] args){

        ServerJavaportalRu_v2 app = new ServerJavaportalRu_v2(4444, 5);
        app.startServer();

//        while (true) {
//
//
//            Runnable runnable =  ()-> soutClientInput(clientSoket);
//            Runnable runnable2 = ()-> sentServerKeyboard(clientSoket);
//
//            fixedThreadPool.execute(runnable);
//            fixedThreadPool.execute(runnable2);
//
//        }

    }
    public void startServer(){
        executorService.execute(this::registrateClients);
        executorService.execute(this::keyboardListenner);
    }


    private void registrateClients(){
        try(ServerSocket servers = new ServerSocket(port)) {
            while (true) {

                //semaphoreForSockets.acquire();

                Socket clientSocket = servers.accept();
                clientSockets.add(clientSocket);
                Runnable clientListener = ()->startNewThreadFor(clientSocket);
                executorService.execute(clientListener);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //catch (InterruptedException e) { e.printStackTrace(); }
    }

    private void startNewThreadFor(Socket clientSocket) {
        String line;
        try(InputStream inputStream = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                serverBroadcasting(line,clientSocket);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void serverBroadcasting(String massage,Socket skipSocket) {
        try {
            Iterator<Socket> iterator = clientSockets.iterator();
            while (iterator.hasNext()){
                Socket currentSocket = iterator.next();
                if (currentSocket.isClosed()) {
                    iterator.remove();
                    System.out.println("Один отвалился)");
                    //semaphoreForSockets.release();
                    continue;
                }
                if (currentSocket.equals(skipSocket)) continue;
                currentSocket.getOutputStream().write((massage+"\n").getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void keyboardListenner(){
        Scanner scanner = new Scanner(System.in);
        while (true)
            serverBroadcasting(scanner.nextLine(),null);
    }
}
