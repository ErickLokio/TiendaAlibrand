package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Talla;
import modelo.TallaChumpa;

/**
 * @author Walter Caal
 */
public class TallaChumpaDao extends DAO{
    private String query;
    private ResultSet res;
    private PreparedStatement sta;
    
    public void ingresar(TallaChumpa tal) throws Exception{
        try {
            this.conectar();
            query="insert into talla_chumpa(nombre_talla_chumpa) values(?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, tal.getTallaChumpa());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaChumpaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
    }
    
    public void eliminar(TallaChumpa tal) throws Exception{
        try {
            this.conectar();
            query="delete from talla_chumpa where id_talla_chumpa=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, tal.getIdTallaChumpa());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaChumpaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
    }
    
    public void modificar(TallaChumpa tal) throws Exception{
        try {
            this.conectar();
            query="update talla_chumpa set nombre_talla_chumpa=? where id_talla_chumpa=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, tal.getTallaChumpa());
            sta.setInt(2, tal.getIdTallaChumpa());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaChumpaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
    
    public ArrayList<TallaChumpa> listar() throws Exception{
        ArrayList<TallaChumpa> lstTalla = null;
        try {
            this.conectar();
            query = "select * from talla_chumpa";
            sta = this.getCn().prepareStatement(query);
            res =sta.executeQuery();
            lstTalla = new ArrayList<>();
            
            while(res.next()){
                TallaChumpa tal = new TallaChumpa();
                tal.setIdTallaChumpa(res.getInt("id_talla_chumpa"));
                tal.setTallaChumpa(res.getString("nombre_talla_chumpa"));
                lstTalla.add(tal);
            }
        } catch (Exception ex) {
            Logger.getLogger(TallaChumpaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        return lstTalla;
    }
}
