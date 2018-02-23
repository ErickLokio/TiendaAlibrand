package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Balon;

/**
 *
 * @author erick osoy
 */
public class BalonDao extends DAO {

    private ResultSet res;
    private PreparedStatement sta;
    private String query;

    public void Guardar(Balon ba) throws Exception {

        try {
            this.conectar();
            query = "INSERT INTO productoinventario(nombre_producto, id_talla_balon, id_sucursal, precio_costo, precio_venta,margen_ganancia,descripcion,cantidad) values(?,?,?,?,?,?,?,?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, ba.getNombre_producto());
            sta.setInt(2, ba.getId_talla_balon());
            sta.setInt(3, ba.getId_sucursal());
            sta.setDouble(4, ba.getPrecio_costo());
            sta.setDouble(5, ba.getPrecio_venta());
            sta.setDouble(6, ba.getMargen_ganancia());
            sta.setString(7, ba.getDescripcion());
            sta.setInt(8, ba.getCantidad());
            sta.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR INSERTAR BALON DAO" + e);
        } finally {
            this.cerrar();
        }
    }

    public ArrayList<Balon> listarBalon() throws Exception {
        ArrayList<Balon> lstBalon = null;
        try {
            this.conectar();
            query = "SELECT productoinventario.id_producto, productoinventario.nombre_producto, productoinventario.id_talla_camisola, productoinventario.id_sucursal, "
                    + "productoinventario.precio_costo, productoinventario.precio_venta, productoinventario.margen_ganancia, productoinventario.descripcion, productoinventario.cantidad, sucursal.nombre_sucursal, sucursal.direccion, talla_balon.nombre_talla_balon\n"
                    + "FROM productoinventario\n"
                    + "INNER JOIN sucursal ON sucursal.id_sucursal = productoinventario.id_sucursal\n"
                    + "INNER JOIN talla_balon ON talla_balon.id_talla_balon = productoinventario.id_talla_balon";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lstBalon = new ArrayList<>();

            while (res.next()) {
                Balon cam = new Balon();
                cam.setId_producto(res.getInt("id_producto"));
                cam.setNombre_producto(res.getString("nombre_producto"));
                cam.setTalla_balon(res.getString("nombre_talla_balon"));
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

    public void modificar(Balon ba) throws Exception {
        try {
            this.conectar();
            query = "UPDATE productoinventario SET nombre_producto=?,id_sucursal=?,precio_costo=?, precio_venta=?,margen_ganancia=?,descripcion=?,cantidad=? WHERE id_producto=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, ba.getNombre_producto());
            sta.setInt(2, ba.getId_sucursal());
            sta.setDouble(3, ba.getPrecio_costo());
            sta.setDouble(4, ba.getPrecio_venta());
            sta.setDouble(5, ba.getMargen_ganancia());
            sta.setString(6, ba.getDescripcion());
            sta.setInt(7, ba.getCantidad());
            sta.setInt(8, ba.getId_producto());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error modificar BALON dao: " + e);
        } finally {
            this.cerrar();
        }
    }

    public void eliminar(Balon ba) throws SQLException, Exception {
        try {
            this.conectar();
            query = "DELETE FROM productoinventario WHERE id_producto = ?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, ba.getId_producto());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error sucursal BALON dao: " + e);
        } finally {
            this.cerrar();
        }
    }

}
