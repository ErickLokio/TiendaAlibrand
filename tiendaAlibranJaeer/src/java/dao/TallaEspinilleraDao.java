package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Talla;
import modelo.TallaEspinillera;

/**
 * @author Walter Caal
 */
public class TallaEspinilleraDao extends DAO{
    private String query;
    private ResultSet res;
    private PreparedStatement sta;
    
    public void ingresar(TallaEspinillera tal) throws Exception{
        try {
            this.conectar();
            query="insert into talla_espinillea(nombre_talla_espinillera) values(?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, tal.getTallaEspinillera());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaEspinilleraDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
    }
    
    public void eliminar(TallaEspinillera tal) throws Exception{
        try {
            this.conectar();
            query="delete from talla_espinillera where id_talla_espinillera=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, tal.getIdTallaEspinillera());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaEspinilleraDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
    }
    
    public void modificar(TallaEspinillera tal) throws Exception{
        try {
            this.conectar();
            query="update talla_espinillera set nombre_talla_espinillera=? where id_talla_espinillera=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, tal.getTallaEspinillera());
            sta.setInt(2, tal.getIdTallaEspinillera());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TallaEspinilleraDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
    
    public ArrayList<TallaEspinillera> listar() throws Exception{
        ArrayList<TallaEspinillera> lstTalla = null;
        try {
            this.conectar();
            query = "select * from talla_espinillera";
            sta = this.getCn().prepareStatement(query);
            res =sta.executeQuery();
            lstTalla = new ArrayList<>();
            
            while(res.next()){
                TallaEspinillera tal = new TallaEspinillera();
                tal.setIdTallaEspinillera(res.getInt("id_talla_espinillera"));
                tal.setTallaEspinillera(res.getString("nombre_talla_espinillera"));
                lstTalla.add(tal);
            }
        } catch (Exception ex) {
            Logger.getLogger(TallaEspinilleraDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        return lstTalla;
    }
}
