package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Espinillera;

/**
 *
 * @author erick osoy
 */
public class EspinilleraDao extends DAO {

    private ResultSet res;
    private PreparedStatement sta;
    private String query;

    
    
    
     public void Guardar(Espinillera esp) throws Exception{
    
        try{
            this.conectar();
            query = "INSERT INTO productoinventario(nombre_producto, id_talla_espinillera, id_sucursal,precio_venta,precio_costo,margen_ganancia,descripcion,cantidad) values(?,?,?,?,?,?,?,?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, esp.getNombre_espnillera());
            sta.setInt(2, esp.getId_talla_espinillera());
            sta.setInt(3, esp.getId_sucursal());
            sta.setDouble(4, esp.getPrecio_costo());
            sta.setDouble(5, esp.getPrecio_venta());
            sta.setDouble(6, esp.getMargen_ganancia());
            sta.setString(7, esp.getDescripcion());
            sta.setInt(8, esp.getCantidad());
            sta.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR INSERTAR ESPINILLERA DAO" +e);
        }finally{
            this.cerrar();
        }
    }
    
    
    
         public ArrayList<Espinillera> listarEspinillera() throws Exception {
        ArrayList<Espinillera> lstBalon = null;
        try {
            this.conectar();
            query = "SELECT productoinventario.id_producto, productoinventario.nombre_producto, productoinventario.id_talla_camisola, productoinventario.id_sucursal, "
                    + "productoinventario.precio_costo, productoinventario.precio_venta, productoinventario.margen_ganancia, productoinventario.descripcion, productoinventario.cantidad, sucursal.nombre_sucursal, sucursal.direccion, talla_espinillera.nombre_talla_espinillera\n"
                    + "FROM productoinventario\n"
                    + "INNER JOIN sucursal ON sucursal.id_sucursal = productoinventario.id_sucursal\n"
                    + "INNER JOIN talla_espinillera ON talla_espinillera.id_talla_espinillera = productoinventario.id_talla_espinillera";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lstBalon = new ArrayList<>();

            while (res.next()) {
                Espinillera cam = new Espinillera();
                cam.setId_espinillera(res.getInt("id_producto"));
                cam.setNombre_espnillera(res.getString("nombre_producto"));
                cam.setTalla(res.getString("nombre_talla_espinillera"));
                cam.setId_sucursal(res.getInt("id_sucursal"));
                cam.setSucursal(res.getString("nombre_sucursal"));
                cam.setPrecio_costo(res.getDouble("precio_costo"));
                cam.setPrecio_venta(res.getDouble("precio_venta"));
                cam.setMargen_ganancia(res.getDouble("margen_ganancia"));
                cam.setDescripcion(res.getString("descripcion"));
                cam.setCantidad(res.getInt("cantidad"));
                lstBalon.add(cam);
            }
        } catch (Exception ex) {
            System.out.println("ERROR LISTAR BALON DAO" +ex);
        } finally {
            this.cerrar();
        }
        return lstBalon;
    }
    
    
    
    
    public void modificar(Espinillera esp) throws Exception{
        try {
            this.conectar();
            query = "UPDATE productoinventario SET nombre_producto=?,id_sucursal=?,precio_venta=?,precio_costo=?,margen_ganancia=?, descripcion=?, cantidad=? WHERE id_producto=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, esp.getNombre_espnillera());
            sta.setInt(2, esp.getId_sucursal());
            sta.setDouble(3, esp.getPrecio_costo());
            sta.setDouble(4, esp.getPrecio_venta());
            sta.setDouble(5, esp.getMargen_ganancia());
            sta.setString(6, esp.getDescripcion());
            sta.setInt(7, esp.getCantidad());
            sta.setInt(8, esp.getId_espinillera());
            sta.executeUpdate(); 
        } catch (SQLException e) {
            System.out.println("Error modificar espinillera dao: "+e);
        } finally {
            this.cerrar();
        }
    }
    
    
    
    
    public void eliminar (Espinillera esp) throws SQLException, Exception{
        try {
            this.conectar();
            query = "DELETE FROM productoinventario WHERE id_producto=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, esp.getId_espinillera());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error espinillera eliminar dao: "+e);
        } finally {
            this.cerrar();
        }
    }
    
}
