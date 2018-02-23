package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pantaloneta;

/**
 * @author Walter
 */
public class PantalonetaDao extends DAO {

    private String query;
    private ResultSet res;
    private PreparedStatement sta;

    public void ingresar(Pantaloneta pan) throws Exception {
        try {
            this.conectar();
            query = "insert into productoinventario(nombre_producto, id_talla_pantaloneta, id_sucursal, precio_costo, precio_venta, margen_ganancia, descripcion, cantidad) values(?,?,?,?,?,?,?,?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, pan.getNombrePantaloneta());
            sta.setInt(2, pan.getIdTallaPantaloneta());
            sta.setInt(3, pan.getIdSucursal());
            sta.setDouble(4, pan.getPrecioCosto());
            sta.setDouble(5, pan.getPrecioVenta());
            sta.setDouble(6, pan.getMargenGanancia());
            sta.setString(7, pan.getDescripcion());
            sta.setInt(8, pan.getCantidad());
            sta.executeUpdate();
        } catch (Exception ex) {
            System.out.println("ERROR INSERTAR PANTALONETA DAO " +ex);
        } finally {
            this.cerrar();
        }
    }

    public void modificar(Pantaloneta pan) throws Exception {
        try {
            this.conectar();
            query = "update productoinventario set nombre_producto=?,precio_costo=?, precio_venta=?, margen_ganancia=?, cantidad=? where id_producto=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, pan.getNombrePantaloneta());
            sta.setDouble(2, pan.getPrecioCosto());
            sta.setDouble(3, pan.getPrecioVenta());
            sta.setDouble(4, pan.getMargenGanancia());
            sta.setInt(5, pan.getCantidad());
            sta.setInt(6, pan.getIdPantaloneta());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(PantalonetaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrar();
        }
    }

    public void eliminar(Pantaloneta pan) throws Exception {
        try {
            this.conectar();
            query = "delete from productoinventario where id_producto=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, pan.getIdPantaloneta());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(PantalonetaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrar();
        }
    }

    public ArrayList<Pantaloneta> listarPantaloneta() throws Exception {
        ArrayList<Pantaloneta> lstPantaloneta = null;
        try {
            this.conectar();
            query = "SELECT productoinventario.id_producto, productoinventario.nombre_producto, productoinventario.id_talla_camisola, productoinventario.id_sucursal, "
                    + "productoinventario.precio_costo, productoinventario.precio_venta, productoinventario.margen_ganancia, productoinventario.descripcion, productoinventario.cantidad, sucursal.nombre_sucursal, sucursal.direccion, talla_pantaloneta.nombre_talla_pantaloneta\n"
                    + "FROM productoinventario\n"
                    + "INNER JOIN sucursal ON sucursal.id_sucursal = productoinventario.id_sucursal\n"
                    + "INNER JOIN talla_pantaloneta ON talla_pantaloneta.id_talla_pantaloneta = productoinventario.id_talla_pantaloneta";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lstPantaloneta = new ArrayList<>();

            while (res.next()) {
                Pantaloneta cam = new Pantaloneta();
                cam.setIdPantaloneta(res.getInt("id_producto"));
                cam.setNombrePantaloneta(res.getString("nombre_producto"));
                cam.setTalla(res.getString("nombre_talla_pantaloneta"));
                cam.setIdSucursal(res.getInt("id_sucursal"));
                cam.setSucursal(res.getString("nombre_sucursal"));
                cam.setPrecioCosto(res.getDouble("precio_costo"));
                cam.setPrecioVenta(res.getDouble("precio_venta"));
                cam.setMargenGanancia(res.getDouble("margen_ganancia"));
                cam.setDescripcion(res.getString("descripcion"));
                cam.setCantidad(res.getInt("cantidad"));
                lstPantaloneta.add(cam);
            }
        } catch (Exception ex) {
            System.out.println("ERROR LISTAR BALON DAO" + ex);
        } finally {
            this.cerrar();
        }
        return lstPantaloneta;
    }
}
