package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Chumpa;

/**
 *
 * @author erick osoy
 */
public class ChumpaDao extends DAO {

    private ResultSet res;
    private PreparedStatement sta;
    private String query;

    public void Guardar(Chumpa chu) throws Exception {

        try {
            this.conectar();
            query = "INSERT INTO productoinventario(nombre_producto, id_talla_chumpa,id_sucursal,precio_costo, precio_venta,margen_ganancia,descripcion,cantidad) values(?,?,?,?,?,?,?,?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, chu.getNombre_chumpa());
            sta.setInt(2, chu.getId_talla());
            sta.setInt(3, chu.getId_sucursal());
            sta.setDouble(4, chu.getPrecio_costo());
            sta.setDouble(5, chu.getPrecio_venta());
            sta.setDouble(6, chu.getMargen_ganancia());
            sta.setString(7, chu.getDescripcion());
            sta.setInt(8, chu.getCantidad_total());
            sta.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR INSERTAR CHUMPA DAO" + e);
        } finally {
            this.cerrar();
        }
    }

    public ArrayList<Chumpa> listaChumpa() throws Exception {
        ArrayList<Chumpa> lista = null;

        try {
            this.conectar();
            query = "SELECT productoinventario.id_producto, productoinventario.nombre_producto, productoinventario.id_sucursal, "
                    + "productoinventario.precio_costo, productoinventario.precio_venta, productoinventario.margen_ganancia, "
                    + "productoinventario.descripcion, productoinventario.cantidad, productoinventario.id_talla_chumpa, "
                    + "talla_chumpa.nombre_talla_chumpa, sucursal.nombre_sucursal, sucursal.direccion\n"
                    + "FROM productoinventario\n"
                    + "INNER JOIN sucursal ON 	sucursal.id_sucursal = productoinventario.id_sucursal\n"
                    + "INNER JOIN talla_chumpa ON talla_chumpa.id_talla_chumpa = productoinventario.id_talla_chumpa";
            sta = this.getCn().prepareCall(query);
            res = sta.executeQuery();
            lista = new ArrayList();

            while (res.next()) {
                Chumpa chu = new Chumpa();
                chu.setId_chumpa(res.getInt("id_producto"));
                chu.setNombre_chumpa(res.getString("nombre_producto"));
                chu.setId_talla(res.getInt("id_talla_chumpa"));
                chu.setTalla(res.getString("nombre_talla_chumpa"));
                chu.setId_sucursal(res.getInt("id_sucursal"));
                chu.setSucursal(res.getString("nombre_sucursal"));
                chu.setPrecio_costo(res.getDouble("precio_costo"));
                chu.setPrecio_venta(res.getDouble("precio_venta"));
                chu.setMargen_ganancia(res.getDouble("margen_ganancia"));
                chu.setDescripcion(res.getString("descripcion"));
                chu.setCantidad_total(res.getInt("cantidad"));
                lista.add(chu);
            }
        } catch (Exception e) {
            System.out.println("ERROR LISTAR Chumpa DAO " + e);
        } finally {
            this.cerrar();
        }
        return lista;
    }

    public void modificar(Chumpa chu) throws Exception {
        try {
            this.conectar();
            query = "UPDATE productoinventario SET nombre_producto=?, id_talla_chumpa=?, id_sucursal=?,precio_costo=?, precio_venta=?,margen_ganancia=?,descripcion=?,cantidad=? WHERE id_producto=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, chu.getNombre_chumpa());
            sta.setInt(2, chu.getId_talla());
            sta.setInt(3, chu.getId_sucursal());
            sta.setDouble(4, chu.getPrecio_costo());
            sta.setDouble(5, chu.getPrecio_venta());
            sta.setDouble(6, chu.getMargen_ganancia());
            sta.setString(7, chu.getDescripcion());
            sta.setInt(8, chu.getCantidad_total());
            sta.setInt(9, chu.getId_chumpa());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error modificar CHUMPA dao: " + e);
        } finally {
            this.cerrar();
        }
    }

    public void eliminar(Chumpa chu) throws SQLException, Exception {
        try {
            this.conectar();
            query = "DELETE FROM productoinventario WHERE id_producto =?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, chu.getId_chumpa());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error CHUMPA dao: " + e);
        } finally {
            this.cerrar();
        }
    }

}
