package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.TallaCamisola;

/**
 * @author Walter Caal
 */
public class TallaCamisolaDao extends DAO{
    private String query;
    private ResultSet res;
    private PreparedStatement sta;
    
    public void ingresar(TallaCamisola tal) throws Exception{
        try {
            this.conectar();
            query="insert into talla_camisola(nombre_talla_camisola) values(?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, tal.getTallaCamisola());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaCamisolaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
    }
    
    public void eliminar(TallaCamisola tal) throws Exception{
        try {
            this.conectar();
            query="delete from talla_camisola where id_talla_camisola=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, tal.getIdTallaCamisola());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaCamisolaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
    }
    
    public void modificar(TallaCamisola tal) throws Exception{
        try {
            this.conectar();
            query="update talla_camisola set nombre_talla_camisola=? where id_talla_camisola=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, tal.getTallaCamisola());
            sta.setInt(2, tal.getIdTallaCamisola());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaCamisolaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
    
    public ArrayList<TallaCamisola> listar() throws Exception{
        ArrayList<TallaCamisola> lstTalla = null;
        try {
            this.conectar();
            query = "select * from talla_camisola";
            sta = this.getCn().prepareStatement(query);
            res =sta.executeQuery();
            lstTalla = new ArrayList<>();
            
            while(res.next()){
                TallaCamisola tal = new TallaCamisola();
                tal.setIdTallaCamisola(res.getInt("id_talla_camisola"));
                tal.setTallaCamisola(res.getString("nombre_talla_camisola"));
                lstTalla.add(tal);
            }
        } catch (Exception ex) {
            Logger.getLogger(TallaCamisolaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        return lstTalla;
    }
}
