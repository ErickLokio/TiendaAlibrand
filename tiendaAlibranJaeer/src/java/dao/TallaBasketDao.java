package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Talla;
import modelo.TallaBalonBasket;

/**
 * @author Walter Caal
 */
public class TallaBasketDao extends DAO{
    private String query;
    private ResultSet res;
    private PreparedStatement sta;
    
    public void ingresar(TallaBalonBasket tal) throws Exception{
        try {
            this.conectar();
            query="insert into talla_balon_basket(nombre_talla_balon_basket) values(?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, tal.getTallaBalonBasket());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaBasketDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
    }
    
    public void eliminar(TallaBalonBasket tal) throws Exception{
        try {
            this.conectar();
            query="delete from talla_balon_basket where id_talla_balon_basket=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, tal.getIdTallaBalonBasket());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaBasketDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
    }
    
    public void modificar(TallaBalonBasket tal) throws Exception{
        try {
            this.conectar();
            query="update talla_balon_basket set nombre_talla_balon_basket=? where id_talla_balon_basket=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, tal.getTallaBalonBasket());
            sta.setInt(2, tal.getIdTallaBalonBasket());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaBasketDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
    
    public ArrayList<TallaBalonBasket> listar() throws Exception{
        ArrayList<TallaBalonBasket> lstTalla = null;
        try {
            this.conectar();
            query = "select * from talla_balon_basket";
            sta = this.getCn().prepareStatement(query);
            res =sta.executeQuery();
            lstTalla = new ArrayList<>();
            
            while(res.next()){
                TallaBalonBasket tal = new TallaBalonBasket();
                tal.setIdTallaBalonBasket(res.getInt("id_talla_balon_basket"));
                tal.setTallaBalonBasket(res.getString("nombre_talla_balon_basket"));
                lstTalla.add(tal);
            }
        } catch (Exception ex) {
            Logger.getLogger(TallaBasketDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        return lstTalla;
    }
}
