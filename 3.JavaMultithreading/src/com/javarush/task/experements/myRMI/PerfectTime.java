package com.javarush.task.experements.myRMI;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class PerfectTime extends UnicastRemoteObject implements PerfectTimeI{
    protected PerfectTime() throws RemoteException { }
    @Override
    public long getPerfectTime() throws RemoteException { return System.currentTimeMillis(); }



    public static void main(String[] args) throws IOException, AlreadyBoundException {

        // Создать и установить менеджер безопасности, который поддерживает RMI
//        if (System.getSecurityManager() == null)
//           System.setSecurityManager(new RMISecurityManager());

        // Создать один или несколько экземпляров удаленного объекта
        PerfectTime pt = new PerfectTime();

        // Запуск репозитория
//        Process process = Runtime.getRuntime().exec("rmiregistry 2005 &");
        Registry registry = LocateRegistry.createRegistry(2005);


        // Зарегистрировать как минимум один удаленный объект в RMI репозитории удаленных объектов в целях загрузки
        Naming.bind("//192.168.10.99:2005/PerfectTime", pt);
        System.out.println("Ready to do time");



//        final Registry registry = LocateRegistry.createRegistry(2099);

//
//        final RemoteHelloService service = new RemoteHelloServiceImpl();
//        Remote stub = UnicastRemoteObject.exportObject(service, 0);
//
//        System.out.print("Binding service...");
//        registry.bind(BINDING_NAME, stub);
//        System.out.println(" OK");

    }

}
