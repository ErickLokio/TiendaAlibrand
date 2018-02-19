package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Talla;

/**
 * @author Walter Caal
 */
public class TallaDao extends DAO{
    private String query;
    private ResultSet res;
    private PreparedStatement sta;
    
    public void ingresar(Talla tal) throws Exception{
        try {
            this.conectar();
            query="insert into talla(nombre_talla) values(?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, tal.getTalla());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
    }
    
    public void eliminar(Talla tal) throws Exception{
        try {
            this.conectar();
            query="delete from talla where id_talla=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, tal.getIdTalla());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
    }
    
    public void modificar(Talla tal) throws Exception{
        try {
            this.conectar();
            query="update talla set nombre_talla=? where id_talla=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, tal.getTalla());
            sta.setInt(2, tal.getIdTalla());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
    
    public ArrayList<Talla> listar() throws Exception{
        ArrayList<Talla> lstTalla = null;
        try {
            this.conectar();
            query = "select * from talla";
            sta = this.getCn().prepareStatement(query);
            res =sta.executeQuery();
            lstTalla = new ArrayList<>();
            
            while(res.next()){
                Talla tal = new Talla();
                tal.setIdTalla(res.getInt("id_talla"));
                tal.setTalla(res.getString("nombre_talla"));
                lstTalla.add(tal);
            }
        } catch (Exception ex) {
            Logger.getLogger(TallaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        return lstTalla;
    }
}
