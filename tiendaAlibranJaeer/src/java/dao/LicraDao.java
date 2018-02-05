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
            query = "INSERT INTO licra(nombre_licra, id_sucursal,precio_venta,precio_costo,margen_ganancia,descripcion,cantidad) values(?,?,?,?,?,?,?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, li.getNombre_licra());
            sta.setInt(2, li.getId_sucursal());
            sta.setDouble(3, li.getPrecio_costo());
            sta.setDouble(4, li.getPrecio_venta());
            sta.setDouble(5, li.getMargen_ganancia());
            sta.setString(6, li.getDescripcion());
            sta.setInt(7, li.getCantidad());
            sta.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR INSERTAR LICRA DAO" + e);
        } finally {
            this.cerrar();
        }
    }

    public ArrayList<Licra> listaLicra() throws Exception {
        ArrayList<Licra> lista = null;

        try {
            this.conectar();
            query = "select * from licra";
            sta = this.getCn().prepareCall(query);
            res = sta.executeQuery();
            lista = new ArrayList();

            while (res.next()) {
                Licra su = new Licra();
                su.setId_licra(res.getInt("id_licra"));
                su.setNombre_licra(res.getString("nombre_licra"));
                su.setId_sucursal(res.getInt("id_sucursal"));
                su.setPrecio_costo(res.getDouble("precio_costo"));
                su.setPrecio_venta(res.getDouble("precio_venta"));
                su.setMargen_ganancia(res.getDouble("margen_ganancia"));
                su.setDescripcion(res.getString("descripcion"));
                su.setCantidad(res.getInt("cantidad"));
                lista.add(su);
            }
        } catch (Exception e) {
            System.out.println("ERROR LISTAR LICRA DAO " + e);
        } finally {
            this.cerrar();
        }
        return lista;
    }

    public void modificar(Licra li) throws Exception {
        try {
            this.conectar();
            query = "UPDATE licra SET nombre_licra=?,id_sucursal=?,precio_venta=?,precio_costo=?,margen_ganancia=?, descripcion=?, cantidad=? WHERE id_licra=?";
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
            query = "DELETE FROM licra WHERE id_licra=?";
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
