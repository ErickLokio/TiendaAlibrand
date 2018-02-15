package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Balon;
import modelo.Talla_Zapatilla;
import modelo.TipoZapatilla;
import modelo.Zapatilla;

/**
 *
 * @author erick osoy
 */
public class ZapatillaDao extends DAO {

    private ResultSet res;
    private PreparedStatement sta;
    private String query;

    
    public void Guardar(Zapatilla za) throws Exception {

        try {
            this.conectar();
            query = "INSERT INTO productoinventario(nombre_producto, id_talla_zapatilla, id_tipo_zapatilla, id_sucursal, precio_costo, precio_venta,margen_ganancia,descripcion,cantidad) values(?,?,?,?,?,?,?,?,?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, za.getNombre_producto());
            sta.setInt(2, za.getId_talla_zapatilla());
            sta.setInt(3, za.getId_tipo_zapatilla());
            sta.setInt(4, za.getId_sucursal());
            sta.setDouble(5, za.getPrecio_costo());
            sta.setDouble(6, za.getPrecio_venta());
            sta.setDouble(7, za.getMargen_ganancia());
            sta.setString(8, za.getDescripcion());
            sta.setInt(9, za.getCantidad());
            sta.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR INSERTAR ZAPATILLA DAO" + e);
        } finally {
            this.cerrar();
        }
    }
    
    
    public ArrayList<Zapatilla> listaZapatilla() throws Exception {
        ArrayList<Zapatilla> lista = null;

        try {
            this.conectar();
            query = "select * from productoinventario";
            sta = this.getCn().prepareCall(query);
            res = sta.executeQuery();
            lista = new ArrayList();

            while (res.next()) {
                Zapatilla za = new Zapatilla();
                za.setId_producto(res.getInt("id_producto"));
                za.setNombre_producto(res.getString("nombre_producto"));
                za.setId_talla_zapatilla(res.getInt("id_talla_zapatilla"));
                za.setId_tipo_zapatilla(res.getInt("id_tipo_zapatilla"));
                za.setId_sucursal(res.getInt("id_sucursal"));
                za.setPrecio_costo(res.getDouble("precio_costo"));
                za.setPrecio_venta(res.getDouble("precio_venta"));
                za.setMargen_ganancia(res.getDouble("margen_ganancia"));
                za.setDescripcion(res.getString("descripcion"));
                za.setCantidad(res.getInt("cantidad"));
                lista.add(za);
            }
        } catch (Exception e) {
            System.out.println("ERROR LISTAR ZAPATILLA DAO " + e);
        } finally {
            this.cerrar();
        }
        return lista;
    }
    
    
    public void modificar(Zapatilla za) throws Exception {
        try {
            this.conectar();
            query = "UPDATE productoinventario SET nombre_producto=?, id_talla_zapatilla=?, id_tipo_zapatilla, id_sucursal=?,precio_costo=?, precio_venta=?,margen_ganancia=?,descripcion=?,cantidad=? WHERE id_producto=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, za.getNombre_producto());
            sta.setInt(2, za.getId_talla_zapatilla());
            sta.setInt(3, za.getId_tipo_zapatilla());
            sta.setInt(4, za.getId_sucursal());
            sta.setDouble(5, za.getPrecio_costo());
            sta.setDouble(6, za.getPrecio_venta());
            sta.setDouble(7, za.getMargen_ganancia());
            sta.setString(8, za.getDescripcion());
            sta.setInt(9, za.getCantidad());
            sta.setInt(10, za.getId_producto());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error modificar ZAPATILLA dao: " + e);
        } finally {
            this.cerrar();
        }
    }

    public void eliminar(Zapatilla za) throws SQLException, Exception {
        try {
            this.conectar();
            query = "DELETE FROM productoinventario WHERE id_balon = ?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, za.getId_producto());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error sucursal ZAPATILLA dao: " + e);
        } finally {
            this.cerrar();
        }
    }
    
    
    
    
    
    
    /* 
        METODOS DE LISTAR 
    */
        public ArrayList<Talla_Zapatilla> listaTalla_Zapatilla() throws Exception {
        ArrayList<Talla_Zapatilla> lista = null;

        try {
            this.conectar();
            query = "select * from Talla_Zapatilla";
            sta = this.getCn().prepareCall(query);
            res = sta.executeQuery();
            lista = new ArrayList();

            while (res.next()) {
                Talla_Zapatilla za = new Talla_Zapatilla();
                za.setId_talla_zapatilla(res.getInt("id_talla_zapatilla"));
                za.setNombre_zapatilla(res.getString("nombre_zapatilla"));
                lista.add(za);
            }
        } catch (Exception e) {
            System.out.println("ERROR LISTAR Talla_Zapatilla DAO " + e);
        } finally {
            this.cerrar();
        }
        return lista;
    }
    
        
    public ArrayList<TipoZapatilla> listaTipoZapatilla() throws Exception {
        ArrayList<TipoZapatilla> lista = null;

        try {
            this.conectar();
            query = "select * from Tipo_Zapatilla";
            sta = this.getCn().prepareCall(query);
            res = sta.executeQuery();
            lista = new ArrayList();

            while (res.next()) {
                TipoZapatilla za = new TipoZapatilla();
                za.setId_tipo_zapatilla(res.getInt("id_tipo_zapatilla"));
                za.setNombre_tipo_zapatilla(res.getString("nombre_tipo_zapatilla"));
                lista.add(za);
            }
        } catch (Exception e) {
            System.out.println("ERROR LISTAR Talla_Zapatilla DAO " + e);
        } finally {
            this.cerrar();
        }
        return lista;
    }
    
    /* 
        FIN METODOS DE LISTAR 
    */
    
}
