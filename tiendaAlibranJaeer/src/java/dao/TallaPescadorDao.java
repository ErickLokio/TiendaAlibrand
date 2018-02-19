package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.TallaPescador;

/**
 * @author Walter Caal
 */
public class TallaPescadorDao extends DAO{
    private String query;
    private ResultSet res;
    private PreparedStatement sta;
    
    public void ingresar(TallaPescador tal) throws Exception{
        try {
            this.conectar();
            query="insert into talla_pescador(nombre_talla_pescador) values(?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, tal.getTallaPescador());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaPescadorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
    }
    
    public void eliminar(TallaPescador tal) throws Exception{
        try {
            this.conectar();
            query="delete from talla_pescador where id_talla_pescador=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, tal.getIdTallaPescador());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaPescadorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
    }
    
    public void modificar(TallaPescador tal) throws Exception{
        try {
            this.conectar();
            query="update talla_pescador set nombre_talla_pescador=? where id_talla_pescador=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, tal.getTallaPescador());
            sta.setInt(2, tal.getIdTallaPescador());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaPescadorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
    
    public ArrayList<TallaPescador> listar() throws Exception{
        ArrayList<TallaPescador> lstTalla = null;
        try {
            this.conectar();
            query = "select * from talla_pescador";
            sta = this.getCn().prepareStatement(query);
            res =sta.executeQuery();
            lstTalla = new ArrayList<>();
            
            while(res.next()){
                TallaPescador tal = new TallaPescador();
                tal.setIdTallaPescador(res.getInt("id_talla_pescador"));
                tal.setTallaPescador(res.getString("nombre_talla_pescador"));
                lstTalla.add(tal);
            }
        } catch (Exception ex) {
            Logger.getLogger(TallaPescadorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        return lstTalla;
    }
}
