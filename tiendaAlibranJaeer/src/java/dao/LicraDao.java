package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Licra;

/**
 *
 * @author erick osoy
 */
public class LicraDao extends DAO {

    private ResultSet res;
    private PreparedStatement sta;
    private String query;

    public void Guardar(Licra li) throws Exception {

        try {
            this.conectar();
            query = "INSERT INTO productoinventario(nombre_producto,id_talla_licra,id_sucursal,precio_venta,precio_costo,margen_ganancia,descripcion,cantidad) values(?,?,?,?,?,?,?,?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, li.getNombre_licra());
            sta.setInt(2, li.getId_talla_licra());
            sta.setInt(3, li.getId_sucursal());
            sta.setDouble(4, li.getPrecio_costo());
            sta.setDouble(5, li.getPrecio_venta());
            sta.setDouble(6, li.getMargen_ganancia());
            sta.setString(7, li.getDescripcion());
            sta.setInt(8, li.getCantidad());
            sta.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR INSERTAR LICRA DAO" + e);
        } finally {
            this.cerrar();
        }
    }

    
    public ArrayList<Licra> listarLicra() throws Exception {
        ArrayList<Licra> lstBalon = null;
        try {
            this.conectar();
            query = "SELECT productoinventario.id_producto, productoinventario.nombre_producto, productoinventario.id_talla_camisola, productoinventario.id_sucursal, "
                    + "productoinventario.precio_costo, productoinventario.precio_venta, productoinventario.margen_ganancia, productoinventario.descripcion, productoinventario.cantidad, sucursal.nombre_sucursal, sucursal.direccion, talla_licra.nombre_talla_licra\n"
                    + "FROM productoinventario\n"
                    + "INNER JOIN sucursal ON sucursal.id_sucursal = productoinventario.id_sucursal\n"
                    + "INNER JOIN talla_licra ON talla_licra.id_talla_licra = productoinventario.id_talla_licra";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lstBalon = new ArrayList<>();

            while (res.next()) {
                Licra cam = new Licra();
                cam.setId_licra(res.getInt("id_producto"));
                cam.setNombre_licra(res.getString("nombre_producto"));
                cam.setTalla(res.getString("nombre_talla_licra"));
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
            System.out.println("ERROR LISTAR BALON DAO" + ex);
        } finally {
            this.cerrar();
        }
        return lstBalon;
    }
    
    public void modificar(Licra li) throws Exception {
        try {
            this.conectar();
            query = "UPDATE productoinventario SET nombre_producto=?,id_sucursal=?,precio_venta=?,precio_costo=?,margen_ganancia=?, descripcion=?, cantidad=? WHERE id_producto=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, li.getNombre_licra());
            sta.setInt(2, li.getId_sucursal());
            sta.setDouble(3, li.getPrecio_costo());
            sta.setDouble(4, li.getPrecio_venta());
            sta.setDouble(5, li.getMargen_ganancia());
            sta.setString(6, li.getDescripcion());
            sta.setInt(7, li.getCantidad());
            sta.setInt(8, li.getId_licra());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error modificar LICRA dao: " + e);
        } finally {
            this.cerrar();
        }
    }

    public void eliminar(Licra li) throws SQLException, Exception {
        try {
            this.conectar();
            query = "DELETE FROM productoinventario WHERE id_producto=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, li.getId_licra());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error LICRA eliminar dao: " + e);
        } finally {
            this.cerrar();
        }
    }
}
