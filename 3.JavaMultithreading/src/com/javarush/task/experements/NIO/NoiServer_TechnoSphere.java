package com.javarush.task.experements.NIO;

import java.nio.ByteBuffer;
import java.nio.channels.Selector;

public class NoiServer_TechnoSphere {
    private Selector selector;
    private ByteBuffer readBuffer = ByteBuffer.allocate(8192);
    //private EchoWorker

}
