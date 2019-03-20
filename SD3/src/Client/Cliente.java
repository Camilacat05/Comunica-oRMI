/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import RMIInterface.Interfaces;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Sam
 */
public class Cliente {
    public Interfaces init() {

        String remoteHostName = "192.168.43.21";
        int remotePort = 9002;
        String connectLocation = "//" + remoteHostName + ":" + remotePort + "/Hello";

        Interfaces hello = null;
        try {
            System.out.println("\nConnecting to client at : " + connectLocation);
            hello = (Interfaces) Naming.lookup(connectLocation);
        } catch (MalformedURLException | RemoteException | NotBoundException e1) {}
        
        return hello;
    }
}
