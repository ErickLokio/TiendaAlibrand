package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Talla;
import modelo.TallaZapatilla;

/**
 * @author Walter Caal
 */
public class TallaZapatillaDao extends DAO{
    private String query;
    private ResultSet res;
    private PreparedStatement sta;
    
    public void ingresar(TallaZapatilla tal) throws Exception{
        try {
            this.conectar();
            query="insert into talla_zapatilla(nombre_talla_zapatilla) values(?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, tal.getTallaZapatilla());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaZapatillaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
    }
    
    public void eliminar(TallaZapatilla tal) throws Exception{
        try {
            this.conectar();
            query="delete from talla_zapatilla where id_talla_zapatilla=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, tal.getIdTallaZapatilla());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaZapatillaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
    
    public void modificar(TallaZapatilla tal) throws Exception{
        try {
            this.conectar();
            query="update talla_zapatilla set nombre_talla_zapatilla=? where id_talla_zapatilla=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, tal.getTallaZapatilla());
            sta.setInt(2, tal.getIdTallaZapatilla());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaZapatillaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
    
    public ArrayList<TallaZapatilla> listar() throws Exception{
        ArrayList<TallaZapatilla> lstTalla = null;
        try {
            this.conectar();
            query = "select * from talla_zapatilla";
            sta = this.getCn().prepareStatement(query);
            res =sta.executeQuery();
            lstTalla = new ArrayList<>();
            
            while(res.next()){
                TallaZapatilla tal = new TallaZapatilla();
                tal.setIdTallaZapatilla(res.getInt("id_talla"));
                tal.setTallaZapatilla(res.getString("nombre_talla"));
                lstTalla.add(tal);
            }
        } catch (Exception ex) {
            Logger.getLogger(TallaZapatillaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        return lstTalla;
    }
}
