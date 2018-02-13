package com.javarush.task.experements.myRMI.javatalksRu;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteHelloServiceImpl implements RemoteHelloService {

    @Override
    public Object sayHello(String name) {

        try {
            System.out.printf("%8s from %s%n",name, UnicastRemoteObject.getClientHost());
        } catch (ServerNotActiveException e) {
            System.out.println(e.getMessage());
        }
        if ("Killer".equals(name)) {
            System.out.println("Shutting down...");
            System.exit(1);
        }

        return "Hello, " + name + "! It is " + System.currentTimeMillis() + " ms now";
    }

    public static void main(String... args) throws Exception {
        System.out.print("Starting registry...");
        final Registry registry = LocateRegistry.createRegistry(1099);
        System.out.println(" OK");

        Remote stub = UnicastRemoteObject.exportObject(new RemoteHelloServiceImpl(), 0);
//      Экспортируем удалённый объект и получаем stub, посредством которого клиент будет вызывать методы нашего объекта.
//      Второй параметр exportObject — порт, который будет использоваться для соеденения с удалённым объектом,
//      0 — выбор любого свободного порта.
//      stub нужно передать клиенту.

        System.out.print("Binding service...");
        registry.bind("sample/HelloService", stub); // имя сервиса указывается без протокола ip и port'а
        System.out.println(" OK");

        while (true)
            Thread.sleep(Integer.MAX_VALUE);

    }
}