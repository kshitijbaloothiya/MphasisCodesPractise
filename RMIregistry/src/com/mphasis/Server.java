package com.mphasis;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

// Creating Remote interface for our application
interface app extends Remote {
    void printMsg();
}

// Implementing the remote interface
class ImplApp implements app {

    // Implementing the interface method
    public void printMsg() {
        System.out.println("This is an example RMI program");
    }
}

public class Server {

    public static void main(String[] args) {
        try {
            // Instantiating the implementation class
            ImplApp obj = new ImplApp();

            // Exporting the object of implementation class
            // (here we are exporting the remote object to the stub)
            app stub = (app) UnicastRemoteObject.exportObject(obj, 0);

            // Binding the remote object (stub) in the registry
            Registry registry = LocateRegistry.getRegistry();

            registry.bind("Hello", stub);
            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
