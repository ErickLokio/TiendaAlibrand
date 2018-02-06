package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pantaloneta;

/**
 * @author Walter
 */
public class PantalonetaDao extends DAO {

    private String query;
    private ResultSet res;
    private PreparedStatement sta;

    public void ingresar(Pantaloneta pan) throws Exception {
        try {
            this.conectar();
            query = "insert into pantaloneta(nombre_pantaloneta, id_talla_pantaloneta, id_sucursal, precio_costo, precio_venta, margen_ganancia, descripcion, cantidad) values(?,"
                    + " ?,?,?,?,?,?,?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, pan.getNombrePantaloneta());
            sta.setInt(2, pan.getIdTallaPantaloneta());
            sta.setInt(3, pan.getIdSucursal());
            sta.setDouble(4, pan.getPrecioCosto());
            sta.setDouble(5, pan.getPrecioVenta());
            sta.setDouble(6, pan.getMargenGanancia());
            sta.setString(7, pan.getDescripcion());
            sta.setInt(8, pan.getCantidad());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(PantalonetaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
    
    public void modificar(Pantaloneta pan) throws Exception{
        try {
            this.conectar();
            query="update pantaloneta set nombre_pantaloneta=?, id_talla_pantaloneta=?, precio_costo=?, precio_venta=?, margen_ganancia=?, cantidad=? where id_pantaloneta=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, pan.getNombrePantaloneta());
            sta.setInt(2, pan.getIdTallaPantaloneta());
            sta.setDouble(3, pan.getPrecioCosto());
            sta.setDouble(4, pan.getPrecioVenta());
            sta.setDouble(5, pan.getMargenGanancia());
            sta.setInt(6, pan.getCantidad());
            sta.setInt(7, pan.getIdPantaloneta());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(PantalonetaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
    
    public void eliminar(Pantaloneta pan) throws Exception{
        try {
            this.conectar();
            query="delete from pantaloneta where id_pantaloneta=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, pan.getIdPantaloneta());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(PantalonetaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
    
    public ArrayList<Pantaloneta> listar() throws Exception{
        ArrayList<Pantaloneta> lstPantaloneta=null;
        
        try {
            this.conectar();
            query="select * from pantaloneta";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lstPantaloneta = new ArrayList<>();
            
            while(res.next()){
                Pantaloneta pan = new Pantaloneta();
                pan.setIdPantaloneta(res.getInt("id_pantaloneta"));
                pan.setCantidad(res.getInt("cantidad"));
                pan.setDescripcion(res.getString("descripcion"));
                pan.setIdSucursal(res.getInt("id_sucursal"));
                pan.setIdTallaPantaloneta(res.getInt("id_talla_pantaloneta"));
                pan.setMargenGanancia(res.getDouble("margen_ganancia"));
                pan.setNombrePantaloneta(res.getString("nombre_pantaloneta"));
                pan.setPrecioCosto(res.getDouble("precio_costo"));
                pan.setPrecioVenta(res.getDouble("precio_venta"));
                lstPantaloneta.add(pan);
            }
        } catch (Exception ex) {
            Logger.getLogger(PantalonetaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        return lstPantaloneta;
    }
}
