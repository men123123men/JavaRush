package com.javarush.task.experements.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {
    public static void main(String[] args) throws IOException{



        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(3000));
        ssc.configureBlocking(false);                  // accept() делаем неблокирующим


        Selector selector =  Selector.open();         // select() является блокирующей операцией
        ssc.register(selector, SelectionKey.OP_ACCEPT);


        ByteBuffer buffer = ByteBuffer.allocate(202);
        System.out.println("Everything OK!");


        while (true){

            int select = selector.select();
            Iterator<SelectionKey> iter = selector.selectedKeys().iterator();

            while (iter.hasNext()){
                try {
                    SelectionKey currentKey = iter.next();

                    if (currentKey.isAcceptable()) { // currentKey.channel() == ssc

                        SocketChannel channel = ssc.accept(); // возврвщает null если нету никого на подключение
                        channel.configureBlocking(false);  // read() делаем неблокирующим
                        channel.register(selector, SelectionKey.OP_READ);
                        System.out.println("Еще одно подключение");

                    } else if(currentKey.isReadable()){

                        ((SocketChannel) currentKey.channel()).read(buffer);
                        buffer.flip(); //
                        System.out.print(new String(buffer.array(), buffer.position(), buffer.remaining()));
                        buffer.clear();

                    }
                } finally {
                    iter.remove();
                }

            }


        }

    }
}
