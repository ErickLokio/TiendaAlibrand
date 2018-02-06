package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pescador;

/**
 * @author Walter
 */
public class PescadorDao extends DAO{
    private String query;
    private ResultSet res;
    private PreparedStatement sta;
    
    public void ingresar(Pescador pes) throws Exception{
        try {
            this.conectar();
            query="insert into pescador (nombre_pescador, id_talla, id_sucursal, precio_costo, precio_venta, margen_ganancia, descripcion, cantidad) values(?,?,?,?,?,?,?,?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, pes.getNombrePescador());
            sta.setInt(2, pes.getIdTalla());
            sta.setInt(3, pes.getIdSucursal());
            sta.setDouble(4, pes.getPrecioCosto());
            sta.setDouble(5, pes.getPrecioVenta());
            sta.setDouble(6, pes.getMargenGanancia());
            sta.setString(7, pes.getDescripcion());
            sta.setInt(8, pes.getCatidad());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(PescadorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
    
    public void eliminar(Pescador pes) throws Exception{
        try {
            this.conectar();
            query="delete from pescador where id_pescador=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, pes.getIdPescador());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(PescadorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
    
    public ArrayList<Pescador> listar() throws Exception{
        ArrayList<Pescador> lstPescador=null;
        try {
            this.conectar();
            query = "select * from pescador";
            sta = this.getCn().prepareStatement(query);  
            res = sta.executeQuery();
            lstPescador = new ArrayList();
            
            while(res.next()){
                Pescador pes = new Pescador();
                pes.setCatidad(res.getInt("cantidad"));
                pes.setDescripcion(res.getString("descripcion"));
                pes.setIdPescador(res.getInt("id_pescador"));
                pes.setIdSucursal(res.getInt("id_suscursal"));
                pes.setIdTalla(res.getInt("id_talla"));
                pes.setMargenGanancia(res.getDouble("margen_ganancia"));
                pes.setNombrePescador(res.getString("nombre_pescador"));
                pes.setPrecioCosto(res.getDouble("precio_costo"));
                pes.setPrecioVenta(res.getDouble("precio_venta"));
                lstPescador.add(pes);
            }
        } catch (Exception ex) {
            Logger.getLogger(PescadorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        return lstPescador;
    }
    
    public void modificar(Pescador pes) throws Exception{
        try {
            this.conectar();
            query="update pescador set nombre_pescador=?, descripcion=?, cantidad=?, id_talla=?, margen_ganancia=?, precio_costo=?, precio_venta=? where id_pescador=?" ;
            
            sta=this.getCn().prepareStatement(query);
            sta.setString(1, pes.getNombrePescador());
            sta.setString(2, pes.getDescripcion());
            sta.setInt(3, pes.getCatidad());
            sta.setInt(4, pes.getIdTalla());
            sta.setDouble(5, pes.getMargenGanancia());
            sta.setDouble(6, pes.getPrecioCosto());
            sta.setDouble(7, pes.getPrecioVenta());
            sta.setInt(8, pes.getIdPescador());
            
        } catch (Exception ex) {
            Logger.getLogger(PescadorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
}
