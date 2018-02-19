package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.TallaLicra;

/**
 * @author Walter Caal
 */
public class TallaLicraDao extends DAO{
    private String query;
    private ResultSet res;
    private PreparedStatement sta;
    
    public void ingresar(TallaLicra tal) throws Exception{
        try {
            this.conectar();
            query="insert into talla_licra(nombre_talla_licra) values(?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, tal.getTallaLicra());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaLicraDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
    }
    
    public void eliminar(TallaLicra tal) throws Exception{
        try {
            this.conectar();
            query="delete from talla_licra where id_talla_licra=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, tal.getIdTallaLicra());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaLicraDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
    }
    
    public void modificar(TallaLicra tal) throws Exception{
        try {
            this.conectar();
            query="update talla_licra set nombre_talla_licra=? where id_talla_licra=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, tal.getTallaLicra());
            sta.setInt(2, tal.getIdTallaLicra());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaLicraDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
    
    public ArrayList<TallaLicra> listar() throws Exception{
        ArrayList<TallaLicra> lstTalla = null;
        try {
            this.conectar();
            query = "select * from talla_licra";
            sta = this.getCn().prepareStatement(query);
            res =sta.executeQuery();
            lstTalla = new ArrayList<>();
            
            while(res.next()){
                TallaLicra tal = new TallaLicra();
                tal.setIdTallaLicra(res.getInt("id_talla_licra"));
                tal.setTallaLicra(res.getString("nombre_talla_licra"));
                lstTalla.add(tal);
            }
        } catch (Exception ex) {
            Logger.getLogger(TallaLicraDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        return lstTalla;
    }
}
