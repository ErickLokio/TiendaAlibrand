package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.TallaBalon;

/**
 * @author Walter Caal
 */
public class TallaBalonDao extends DAO{
    private String query;
    private ResultSet res;
    private PreparedStatement sta;
    
    public void ingresar(TallaBalon tal) throws Exception{
        try {
            this.conectar();
            query="insert into talla(nombre_talla_balon) values(?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, tal.getTallaBalon());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaBalonDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
    }
    
    public void eliminar(TallaBalon tal) throws Exception{
        try {
            this.conectar();
            query="delete from talla_balon where id_talla_balon=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, tal.getIdTallaBalon());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaBalonDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
    }
    
    public void modificar(TallaBalon tal) throws Exception{
        try {
            this.conectar();
            query="update talla set nombre_talla_balon=? where id_talla_balon=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, tal.getTallaBalon());
            sta.setInt(2, tal.getIdTallaBalon());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaBalonDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
    
    public ArrayList<TallaBalon> listar() throws Exception{
        ArrayList<TallaBalon> lstTalla = null;
        try {
            this.conectar();
            query = "select * from talla_balon";
            sta = this.getCn().prepareStatement(query);
            res =sta.executeQuery();
            lstTalla = new ArrayList<>();
            
            while(res.next()){
                TallaBalon tal = new TallaBalon();
                tal.setIdTallaBalon(res.getInt("id_talla_balon"));
                tal.setTallaBalon(res.getString("nombre_talla_balon"));
                lstTalla.add(tal);
            }
        } catch (Exception ex) {
            Logger.getLogger(TallaBalonDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        return lstTalla;
    }
}
