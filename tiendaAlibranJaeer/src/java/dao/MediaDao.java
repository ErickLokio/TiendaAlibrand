package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Media;

/**
 *
 * @author erick osoy
 */
public class MediaDao extends DAO {

    private ResultSet res;
    private PreparedStatement sta;
    private String query;

    public void Guardar(Media me) throws Exception {

        try {
            this.conectar();
            query = "INSERT INTO productoinventario(nombre_producto, id_sucursal, precio_venta, precio_costo ,margen_ganancia ,descripcion,cantidad) values(?,?,?,?,?,?,?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, me.getNombre_media());
            sta.setInt(2, me.getId_sucursal());
            sta.setDouble(3, me.getPrecio_costo());
            sta.setDouble(4, me.getPrecio_venta());
            sta.setDouble(5, me.getMargen_ganancia());
            sta.setString(6, me.getDescripcion());
            sta.setInt(7, me.getCantidad());
            sta.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR INSERTAR MEDIA DAO" + e);
        } finally {
            this.cerrar();
        }
    }

    public ArrayList<Media> listaMedia() throws Exception {
        ArrayList<Media> lista = null;

        try {
            this.conectar();
            query = "select * from media";
            sta = this.getCn().prepareCall(query);
            res = sta.executeQuery();
            lista = new ArrayList();

            while (res.next()) {
                Media su = new Media();
                su.setId_media(res.getInt("id_media"));
                su.setNombre_media(res.getString("nombre_media"));
                su.setId_sucursal(res.getInt("id_sucursal"));
                su.setPrecio_costo(res.getDouble("precio_costo"));
                su.setPrecio_venta(res.getDouble("precio_venta"));
                su.setMargen_ganancia(res.getDouble("margen_ganancia"));
                su.setDescripcion(res.getString("descripcion"));
                su.setCantidad(res.getInt("cantidad"));
                lista.add(su);
            }
        } catch (Exception e) {
            System.out.println("ERROR LISTAR MEDIA DAO " + e);
        } finally {
            this.cerrar();
        }
        return lista;
    }
    

    public void modificar(Media me) throws Exception {
        try {
            this.conectar();
            query = "UPDATE media SET nombre_media=?,id_sucursal=?,precio_venta=?,precio_costo=?,margen_ganancia=?, descripcion=?, cantidad=? WHERE id_media=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, me.getNombre_media());
            sta.setInt(2, me.getId_sucursal());
            sta.setDouble(3, me.getPrecio_costo());
            sta.setDouble(4, me.getPrecio_venta());
            sta.setDouble(5, me.getMargen_ganancia());
            sta.setString(6, me.getDescripcion());
            sta.setInt(7, me.getCantidad());
            sta.setInt(8, me.getId_media());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error modificar LICRA dao: " + e);
        } finally {
            this.cerrar();
        }
    }

    public void eliminar(Media me) throws SQLException, Exception {
        try {
            this.conectar();
            query = "DELETE FROM media WHERE id_media=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, me.getId_media());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error MEDIA eliminar dao: " + e);
        } finally {
            this.cerrar();
        }
    }
}