package com.javarush.task.experements.myRMI.cyberforumRu;

import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteServiceImpl extends UnicastRemoteObject implements MyRemote {

    protected MyRemoteServiceImpl() throws RemoteException { super();/*super(2222);*/ }
    @Override
    public String sayHello() throws RemoteException {
        return "Server say 'Hello'";
    }


     public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException, NamingException {

         // Эквивалент rmic (который стал deprecated)
         // Но нам она в этом примере не нужно т.к. MyRemoteServiceImpl extends UnicastRemoteObject
//        Remote stub = UnicastRemoteObject.exportObject(service, 0);

        // Создание экземпляра инерфейса
         MyRemote service = new MyRemoteServiceImpl();  // так было в самом начале

         // эти 2 варианта надо запускать после запуска утилиты rmiregistry в терминале
//        Naming.rebind("rmi://localhost/RemoteHello", service);  // так было в самом начале (напрочь отказывается работать так)

//         Context context = new InitialContext();
//         context.bind("rmi://localhost/RemoteHello", service);  // так тоже не работает

        // Эквивалент запуска rmiregistry
        Registry registry = LocateRegistry.createRegistry(1099);// 1099 != 0
        registry.bind("RemoteHello", service);   // имя сервиса надо задать(для каждого экзкмпляра Remote интерфейса свой)
                                                 // указывается без протокола ip и port'а

         System.out.println("Everything OK!");

    }
}










