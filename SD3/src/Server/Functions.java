/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataBase.Conexão;
import DataBase.Querys;
import RMIInterface.Interfaces;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Sam
 */
public class Functions extends UnicastRemoteObject implements Interfaces {
    private static final long serialVersionUID = 1L;

    public Functions() throws RemoteException { }
    
    public String enviaDados(int[] vetor){
        String ordenados = null;
        ordenados = bubbleSort(vetor);
        
        Conexão c = new Conexão();
        c.registraDriver();
        Querys e = new Querys();
        e.InserirLista(ordenados);
        
        return ordenados;
    }
    
    private static String bubbleSort(int vetor[]){
        System.out.print("Valores Desordenados: ");
        
        String retorno = "";       
        boolean troca = true;
        int aux,i;
        
        for (i = 0; i<10; i++){
            System.out.print(" " + vetor[i]);
        }
        
        while (troca) {
            troca = false;
            for (i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    troca = true;
                }
            }
        }
        System.out.print("\nValores Ordenados: ");
        for (i = 0; i<10; i++){
            System.out.print(" " + vetor[i]);
            retorno = retorno + Integer.toString(vetor[i]) + " ";
        }
        return retorno;       
       }

}