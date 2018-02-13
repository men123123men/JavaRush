package com.javarush.task.experements.myRMI.cyberforumRu;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyRemoteClient {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
//        MyRemote service = (MyRemote) Naming.lookup("rmi://localhost/RemoteHello"); // так было в самом начале

//        rmi://<HOST_NAME>[:<PORT>]/<SERVICE_NAME>
//        порт по умолчанию 1099

//        MyRemote service = (MyRemote) Naming.lookup("rmi:///RemoteHello");
        // "RemoteHello"
        // "/RemoteHello"
        // "rmi:///RemoteHello"
        // "rmi://localhost/RemoteHello"
        // "rmi://localhost:1099/RemoteHello"


        Registry registry = LocateRegistry.getRegistry(null, 0); // null=="localhost" ; 0 == 1099
        MyRemote service = (MyRemote) registry.lookup("RemoteHello");


        String s = service.sayHello();
        System.out.println(s);
    }







}