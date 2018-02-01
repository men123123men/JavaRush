package com.javarush.task.task25.task2509;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public abstract class SocketTask<T> implements CancellableTask<T> {
    private Socket socket;

    protected synchronized void setSocket(Socket socket) {
        this.socket = socket;
    }
    @Override
    public synchronized void cancel() throws IOException {
        //close all resources here


            socket.close();

    }
    @Override
    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                //close all resources here by using proper SocketTask method
                //call super-class method in finally block
                try{
                    SocketTask.this.cancel();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally{
                    super.cancel(mayInterruptIfRunning);}
                return false;
            }
        };
    }
}