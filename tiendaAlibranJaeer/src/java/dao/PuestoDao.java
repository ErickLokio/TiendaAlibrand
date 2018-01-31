package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Puesto;

/**
 *
 * @author Walter
 */
public class PuestoDao extends DAO{
    private ResultSet res;
    private PreparedStatement sta;
    private String query;
    
    public ArrayList<Puesto> listar() throws Exception{
        ArrayList<Puesto> lstPuesto=null;
        try {
            this.conectar();
            query="select * from puesto";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lstPuesto = new ArrayList<>();
            
            while(res.next()){
                Puesto modPues = new Puesto();
                modPues.setIdPuesto(res.getInt("id_puesto"));
                modPues.setPuesto(res.getString("nombre_puesto"));
                lstPuesto.add(modPues);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(PuestoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        return lstPuesto;
    }
}
