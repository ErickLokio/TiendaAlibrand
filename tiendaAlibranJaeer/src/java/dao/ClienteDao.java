package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Walter
 */
public class ClienteDao extends DAO{
   private String query;
   private ResultSet res ;
   private PreparedStatement sta;
   
   public void ingresar(){
       try {
           this.conectar();
           query = "";
           
       } catch (Exception ex) {
           Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }
}
