package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            query = "insert into productoinventario(nombre_producto, id_talla_camisola, id_sucursal, precio_costo, precio_venta, margen_ganancia, descripcion, cantidad) values(?,?,?,?,?,?,?,?)";
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
        } finally {
            this.cerrar();
        }
    }

    public void eliminar(Camisola cam) throws Exception {
        try {
            this.conectar();
            query = "delete from productoinventario where id_producto=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, cam.getIdCamisola());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(CamisolaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrar();
        }
    }

    public void modificar(Camisola ca) throws Exception {
        try {
            this.conectar();
            query = "UPDATE productoinventario SET nombre_producto=?,id_sucursal=?,precio_costo=?, precio_venta=?,margen_ganancia=?,descripcion=?,cantidad=? WHERE id_producto=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, ca.getNombreCamisola());
            sta.setInt(2, ca.getIdSucursal());
            sta.setDouble(3, ca.getPrecioCosto());
            sta.setDouble(4, ca.getPrecioVenta());
            sta.setDouble(5, ca.getMargenGanancia());
            sta.setString(6, ca.getDescripcion());
            sta.setInt(7, ca.getCantidad());
            sta.setInt(8, ca.getIdCamisola());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error modificar CAMISOLA dao: " + e);
        } finally {
            this.cerrar();
        }
    }

    public ArrayList<Camisola> listar() throws Exception {
        ArrayList<Camisola> lstCamisola = null;
        try {
            this.conectar();
            query = "SELECT productoinventario.id_producto, productoinventario.nombre_producto, productoinventario.id_talla_camisola, productoinventario.id_sucursal, "
                    + "productoinventario.precio_costo, productoinventario.precio_venta, productoinventario.margen_ganancia, productoinventario.descripcion, productoinventario.cantidad, sucursal.nombre_sucursal, sucursal.direccion, talla_camisola.nombre_talla_camisola\n"
                    + "FROM productoinventario\n"
                    + "INNER JOIN sucursal ON sucursal.id_sucursal = productoinventario.id_sucursal\n"
                    + "INNER JOIN talla_camisola ON talla_camisola.id_talla_camisola = productoinventario.id_talla_camisola";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lstCamisola = new ArrayList<>();

            while (res.next()) {
                Camisola cam = new Camisola();
                cam.setIdCamisola(res.getInt("id_producto"));
                cam.setNombreCamisola(res.getString("nombre_producto"));
                cam.setIdTalla(res.getInt("id_talla_camisola"));
                cam.setTalla(res.getString("nombre_talla_camisola"));
                cam.setIdSucursal(res.getInt("id_sucursal"));
                cam.setSucursal(res.getString("nombre_sucursal"));
                cam.setDireccion(res.getString("direccion"));
                cam.setPrecioCosto(res.getDouble("precio_costo"));
                cam.setPrecioVenta(res.getDouble("precio_venta"));
                cam.setMargenGanancia(res.getDouble("margen_ganancia"));
                cam.setDescripcion(res.getString("descripcion"));
                cam.setCantidad(res.getInt("cantidad"));
                lstCamisola.add(cam);
            }
        } catch (Exception ex) {
            Logger.getLogger(CamisolaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrar();
        }
        return lstCamisola;
    }
}
