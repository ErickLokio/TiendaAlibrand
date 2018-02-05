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
            query = "INSERT INTO espinillera(nombre_espinillera, id_talla_espinillera, id_sucursal,precio_venta,precio_costo,margen_ganancia,descripcion,cantidad) values(?,?,?,?,?,?,?,?)";
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
    
    
    
    public ArrayList<Espinillera> listaEspinillera() throws Exception{
    ArrayList<Espinillera> lista = null;
    
    try{
        this.conectar();
        query = "select * from espinillera";
        sta = this.getCn().prepareCall(query);
        res = sta.executeQuery();
        lista = new ArrayList();
        
        while(res.next()){
            Espinillera su = new Espinillera();
            su.setId_espinillera(res.getInt("id_espinillera"));
            su.setNombre_espnillera(res.getString("nombre_espinillera"));
            su.setId_talla_espinillera(res.getInt("id_talla_espinillera"));
            su.setId_sucursal(res.getInt("id_sucursal"));
            su.setPrecio_costo(res.getDouble("precio_costo"));
            su.setPrecio_venta(res.getDouble("precio_venta"));
            su.setMargen_ganancia(res.getDouble("margen_ganancia"));
            su.setDescripcion(res.getString("descripcion"));
            su.setCantidad(res.getInt("cantidad"));
            lista.add(su);
        }
    }catch(Exception e){
        System.out.println("ERROR LISTAR ESPINILLERA DAO "+e);
    }finally{
        this.cerrar();
    }
    return lista;
}
    
    
    
    
    public void modificar(Espinillera esp) throws Exception{
        try {
            this.conectar();
            query = "UPDATE espinillera SET nombre_espinillera=?,id_talla_espinillera=?,id_sucursal=?,precio_venta=?,precio_costo=?,margen_ganancia=?, descripcion=?, cantidad=? WHERE id_espinillera=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, esp.getNombre_espnillera());
            sta.setInt(2, esp.getId_talla_espinillera());
            sta.setInt(3, esp.getId_sucursal());
            sta.setDouble(4, esp.getPrecio_costo());
            sta.setDouble(5, esp.getPrecio_venta());
            sta.setDouble(6, esp.getMargen_ganancia());
            sta.setString(7, esp.getDescripcion());
            sta.setInt(8, esp.getCantidad());
            sta.setInt(9, esp.getId_espinillera());
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
            query = "DELETE FROM espinillera WHERE id_espinillera=?";
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
