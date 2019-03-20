/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Client.Cliente;
import DataBase.Conexão;
import DataBase.Querys;
import RMIInterface.Interfaces;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author Sam
 */
public class Main {
    public static void main(String[] args) throws RemoteException, SQLException{
        int vetor[] = new int[10];
        
        Random gerador = new Random();
        int i;
        //Gerando dados randomicamente PS: Dados entre 0 e 100
        for (i = 0; i<10; i++){
            vetor[i] = gerador.nextInt(100);
            System.out.print(vetor[i] + " ");
        }
                
        Cliente cliente = new Cliente();
        Interfaces a = cliente.init();
        System.out.println("Ordenados: "+a.enviaDados(vetor)); 
        
        //Querys c = new Querys();
        //System.out.println("Resposta: "+c.RecebeLista());
        
    }
}

        