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
            query = "INSERT INTO balon(nombre_balon, id_talla_balon, id_sucursal,precio_costo, precio_venta,margen_ganancia,descripcion,cantidad) values(?,?,?,?,?,?,?,?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, ba.getNombre_balon());
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

    public ArrayList<Balon> listaBalon() throws Exception {
        ArrayList<Balon> lista = null;

        try {
            this.conectar();
            query = "select * from balon";
            sta = this.getCn().prepareCall(query);
            res = sta.executeQuery();
            lista = new ArrayList();

            while (res.next()) {
                Balon ba = new Balon();
                ba.setId_balon(res.getInt("id_balon"));
                ba.setNombre_balon(res.getString("nombre_balon"));
                ba.setId_talla_balon(res.getInt("id_talla_balon"));
                ba.setId_sucursal(res.getInt("id_sucursal"));
                ba.setPrecio_costo(res.getDouble("precio_costo"));
                ba.setPrecio_venta(res.getDouble("precio_venta"));
                ba.setMargen_ganancia(res.getDouble("margen_ganancia"));
                ba.setDescripcion(res.getString("descripcion"));
                ba.setCantidad(res.getInt("cantidad"));
                lista.add(ba);
            }
        } catch (Exception e) {
            System.out.println("ERROR LISTAR BALON DAO " + e);
        } finally {
            this.cerrar();
        }
        return lista;
    }

    public void modificar(Balon ba) throws Exception {
        try {
            this.conectar();
            query = "UPDATE balon SET nombre_balon=?, id_talla_balon=?, id_sucursal=?,precio_costo=?, precio_venta=?,margen_ganancia=?,descripcion=?,cantidad=? WHERE id_balon=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, ba.getNombre_balon());
            sta.setInt(2, ba.getId_talla_balon());
            sta.setInt(3, ba.getId_sucursal());
            sta.setDouble(4, ba.getPrecio_costo());
            sta.setDouble(5, ba.getPrecio_venta());
            sta.setDouble(6, ba.getMargen_ganancia());
            sta.setString(7, ba.getDescripcion());
            sta.setInt(8, ba.getCantidad());
            sta.setInt(9, ba.getId_balon());
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
            query = "DELETE FROM balon WHERE id_balon = ?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, ba.getId_balon());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error sucursal BALON dao: " + e);
        } finally {
            this.cerrar();
        }
    }

}
