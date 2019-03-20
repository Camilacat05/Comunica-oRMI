/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Sam
 */
public interface Interfaces extends Remote {
    public String enviaDados(int[] vetor) throws RemoteException;
}
