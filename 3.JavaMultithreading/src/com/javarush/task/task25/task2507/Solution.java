package com.javarush.task.task25.task2507;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/* 
Работать в поте лица!
*/
public class Solution extends Thread {
    private static final int BUFFER_SIZE = 2000;    //2000 bytes
    private final Socket socket;
    private final InputStream in;
    private boolean остановилиЛи;

    public Solution(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }
    @Override
    public void interrupt() {
        //implement logic here
        остановилиЛи = true;
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            super.interrupt();
        }

    }
    @Override
    public void run() {
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            while (!остановилиЛи) {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                } else {
                    if (count > 0) {
                        //process buffer here
                        System.out.println(new String(buf,0,count));
                    }
                }
            }
        } catch (IOException ignored) {}

    }

    public static void main(String[] args) {
    }
}
