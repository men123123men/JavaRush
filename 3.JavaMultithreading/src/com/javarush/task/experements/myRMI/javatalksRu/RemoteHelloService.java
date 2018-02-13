package com.javarush.task.experements.myRMI.javatalksRu;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteHelloService extends Remote {
    Object sayHello(String name) throws RemoteException;
}