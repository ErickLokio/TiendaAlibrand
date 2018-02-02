package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Camisola;

/**
 *
 * @author Walter
 */
public class CamisolaDao extends DAO {

    private String query;
    private PreparedStatement sta;
    private ResultSet res;

    public void ingresar(Camisola cam) throws Exception {
        
        try {
            this.conectar();
            query = "insert into camisola(nombre_camisola, id_talla, id_sucursal, precio_costo, precio_venta, margen_ganancia, descripcion, cantidad) values(?,?,?,?,?,?,?,?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, cam.getNombreCamisola());
            sta.setInt(2, cam.getIdTalla());
            sta.setInt(3, cam.getIdSucursal());
            sta.setDouble(4, cam.getPrecioCosto());
            sta.setDouble(5, cam.getPrecioVenta());
            sta.setDouble(6, cam.getMargenGanancia());
            sta.setString(7, cam.getDescripcion());
            sta.setInt(8, cam.getCantidad());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(CamisolaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
    
    public void eliminar(Camisola cam) throws Exception{
        try {
            this.conectar();
            query="delete from camisola where id_camisola=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, cam.getIdCamisola());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(CamisolaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
    
    public void modificar(Camisola cam) throws Exception{
        try {
            this.conectar();
            query="update camisola set nombre_camisola=?, id_talla=?, id_sucursal=?, precio_costo=?, precio_venta=?, margen_ganancia, descripcion=?, cantidad=? where id_camisola=? limit 1";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, cam.getNombreCamisola());
            sta.setInt(2, cam.getIdTalla());
            sta.setInt(3, cam.getIdSucursal());
            sta.setDouble(4, cam.getPrecioCosto());
            sta.setDouble(5, cam.getPrecioVenta());
            sta.setDouble(6, cam.getMargenGanancia());
            sta.setString(7, cam.getDescripcion());
            sta.setInt(8, cam.getCantidad());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(CamisolaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
    
    public ArrayList<Camisola> listar() throws Exception{
        ArrayList<Camisola> lstCamisola=null;
        try {
            this.conectar();
            query="select * from camisola";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lstCamisola = new ArrayList<>();
            
            while(res.next()){
                Camisola cam = new Camisola();
                cam.setIdCamisola(res.getInt("id_camisola"));
                cam.setNombreCamisola(res.getString("nombre_camisola"));
                cam.setIdTalla(res.getInt("id_talla"));
                cam.setIdSucursal(res.getInt("id_sucursal"));
                cam.setPrecioCosto(res.getDouble("precio_costo"));
                cam.setPrecioVenta(res.getDouble("precio_venta"));
                cam.setMargenGanancia(res.getDouble("margen_ganancia"));
                cam.setDescripcion(res.getString("descripcion"));
                cam.setCantidad(res.getInt("cantidad"));
                lstCamisola.add(cam);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(CamisolaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        return lstCamisola;
    }
}
