/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sam
 */
public class Querys {
    public int InserirLista(String lista){
        
        String SQL = "INSERT INTO valores(ordenados) " + "VALUES(?)";

        Conexão c = new Conexão();
        
        try (Connection conn = c.conect(); PreparedStatement pstmt = conn.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS)){
            pstmt.setString(1,lista);    

            pstmt.executeUpdate();
            
            ResultSet retornoDoID = pstmt.getGeneratedKeys();
            retornoDoID.next();
            Integer id;
            id = retornoDoID.getInt(1);
        }catch(Exception e){
            //System.out.println(e.getMessage());
        }
        
        return 0;
    }
   
    public String RecebeLista() throws SQLException{
        
        String SQL = "SELECT * FROM valores WHERE id_valor IN (SELECT MAX(id_valor) FROM valores)";

        Conexão c = new Conexão();
        Connection conn = c.conect();
        PreparedStatement stmt = conn.prepareStatement(SQL);
        ResultSet rs;
        rs = stmt.executeQuery();
        rs.next();
        return rs.getString("ordenados");
   
    }
    
    void printStackTrace() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
