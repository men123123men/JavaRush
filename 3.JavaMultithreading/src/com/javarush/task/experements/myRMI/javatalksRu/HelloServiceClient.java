package com.javarush.task.experements.myRMI.javatalksRu;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloServiceClient {

    public static void main(String... args) throws Exception {

        Registry registry = LocateRegistry.getRegistry(null, 0);  // "localhost" == null; 1099 == 0
        RemoteHelloService service = (RemoteHelloService) registry.lookup("sample/HelloService");


        String[] names = { "John", "Jan", "Иван", "Johan", "Hans", "Bill", "Kill" };
        for (String name : names)
            System.out.println(service.sayHello(name));

    }

}