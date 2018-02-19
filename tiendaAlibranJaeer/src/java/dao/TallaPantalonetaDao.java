package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.TallaPantaloneta;

/**
 * @author Walter Caal
 */
public class TallaPantalonetaDao extends DAO{
    private String query;
    private ResultSet res;
    private PreparedStatement sta;
    
    public void ingresar(TallaPantaloneta tal) throws Exception{
        try {
            this.conectar();
            query="insert into talla_pantaloneta(nombre_talla_pantaloneta) values(?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, tal.getTallaPantaloneta());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaPantalonetaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
    }
    
    public void eliminar(TallaPantaloneta tal) throws Exception{
        try {
            this.conectar();
            query="delete from talla_pantaloneta where id_talla_pantaloneta=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, tal.getIdTallaPantaloneta());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaPantalonetaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
    }
    
    public void modificar(TallaPantaloneta tal) throws Exception{
        try {
            this.conectar();
            query="update talla set nombre_talla_pantaloneta=? where id_talla_pantaloneta=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, tal.getTallaPantaloneta());
            sta.setInt(2, tal.getIdTallaPantaloneta());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaPantalonetaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
    
    public ArrayList<TallaPantaloneta> listar() throws Exception{
        ArrayList<TallaPantaloneta> lstTalla = null;
        try {
            this.conectar();
            query = "select * from talla_pantaloneta";
            sta = this.getCn().prepareStatement(query);
            res =sta.executeQuery();
            lstTalla = new ArrayList<>();
            
            while(res.next()){
                TallaPantaloneta tal = new TallaPantaloneta();
                tal.setIdTallaPantaloneta(res.getInt("id_talla_pantaloneta"));
                tal.setTallaPantaloneta(res.getString("nombre_talla_pantaloneta"));
                lstTalla.add(tal);
            }
        } catch (Exception ex) {
            Logger.getLogger(TallaPantalonetaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        return lstTalla;
    }
}
