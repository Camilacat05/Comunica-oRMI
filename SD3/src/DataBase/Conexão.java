/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sam
 */
public class Conexão {
    public Connection conect(){
        try {
            System.out.println("Banco de dados conectado");
            return DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/SistemasDistribuidos", "postgres","@4BPMpicospi");
	} catch (SQLException e) {
            System.out.println("Conexão falhada! Verifique o console de saída");
            e.printStackTrace();
            return null;
        }
    }
    
    public void registraDriver(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Onde está o seu driver JDBC do PostgreSQL? " + "Inclua em sua biblioteca");
            e.printStackTrace();
            return;
        }
	System.out.println("\nPostgreSQL JDBC Driver registrado!");
    }

}