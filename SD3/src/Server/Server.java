/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Sam
 */
public class Server {
    public static void main(String[] argv) throws RemoteException, AlreadyBoundException, MalformedURLException, UnknownHostException {

        System.err.println("Executando  Server RMI!");
        
        Functions Hello = new Functions();

        int port = 9002;

        try { // special exception handler for registry creation
            LocateRegistry.createRegistry(port);
            System.out.println("java RMI registry created.");
        } catch (RemoteException e) {
            // do nothing, error means registry already exists
            System.out.println("java RMI registry already exists.");
        }

        String hostname = new MyIp().get();

        String bindLocation = "//" + hostname + ":" + port + "/Hello";
        Naming.bind(bindLocation, Hello); // TODO Auto-generated catch block
        // TODO Auto-generated catch block
        System.out.println("Addition Server is ready at:" + bindLocation);
        
    }
}
