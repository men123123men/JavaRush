package com.javarush.task.experements.NIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class NioClient_TechnoSphere {
    static final String ADDRESS = "localhost";
    static final int PORT = 9090;
    private ByteBuffer buffer = ByteBuffer.allocate(16);

    private void run() throws Exception{

        Selector selector = Selector.open();

        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false); // делаем канал неблокурующим
        channel.register(selector, SelectionKey.OP_CONNECT); //
        channel.connect(new InetSocketAddress(ADDRESS,PORT));

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

        new Thread(()->{
            try(Scanner scanner = new Scanner(System.in)) {

                String line;
                while (!(line = scanner.nextLine()).equals("q")) {

                    queue.put(line);

                    SelectionKey key = channel.keyFor(selector); // в этих 2ух строках
                    key.interestOps(SelectionKey.OP_WRITE);      // порождаем событие на запись

                    selector.wakeup(); // чтобы selector.select() базблокировываелся

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }).start();

        //SelectionKey.OP_READ;
        //SelectionKey.OP_WRITE;
        //SelectionKey.OP_CONNECT;
        //SelectionKey.OP_ACCEPT;

        while (true){
            selector.select(); // это метод блокирующий
            for(SelectionKey selectionKey: selector.selectedKeys()){
                if(selectionKey.isConnectable()) {// если событие на подключение
                    channel.finishConnect();      // подкючить
                    selectionKey.interestOps(SelectionKey.OP_WRITE);

                } else if(selectionKey.isReadable()){
                    buffer.clear();
                    channel.read(buffer);
                    System.out.println("Recived = "+new String(buffer.array()));

                } else if(selectionKey.isWritable()){
                    String line = queue.poll();
                    if(line!=null)
                        channel.write(ByteBuffer.wrap(line.getBytes()));
                    selectionKey.interestOps(SelectionKey.OP_READ);
                }
            }

        }

    }

    public static void main(String[] args)throws Exception{
        new NioClient_TechnoSphere().run();
    }

}