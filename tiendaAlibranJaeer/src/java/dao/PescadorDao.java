package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pescador;

/**
 * @author Walter
 */
public class PescadorDao extends DAO{
    private String query;
    private ResultSet res;
    private PreparedStatement sta;
    
    public void ingresar(Pescador pes) throws Exception{
        try {
            this.conectar();
            query="insert into productoinventario(nombre_producto,id_alla_pescador, id_sucursal, precio_costo, precio_venta, margen_ganancia, descripcion, cantidad) values(?,?,?,?,?,?,?,?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, pes.getNombrePescador());
            sta.setInt(2, pes.getId_talla_pescador());
            sta.setInt(3, pes.getIdSucursal());
            sta.setDouble(4, pes.getPrecioCosto());
            sta.setDouble(5, pes.getPrecioVenta());
            sta.setDouble(6, pes.getMargenGanancia());
            sta.setString(7, pes.getDescripcion());
            sta.setInt(8, pes.getCatidad());
            sta.executeUpdate();
        } catch (Exception ex) {
            System.out.println("ERROR INSERTAR PESCADOR" +ex);
        }finally{
            this.cerrar();
        }
    }
    
    public void eliminar(Pescador pes) throws Exception{
        try {
            this.conectar();
            query="delete from productoinventario where id_producto=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, pes.getIdPescador());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(PescadorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
    
      public ArrayList<Pescador> listarPescador() throws Exception {
        ArrayList<Pescador> lstPescador = null;
        try {
            this.conectar();
            query = "SELECT productoinventario.id_producto, productoinventario.nombre_producto, productoinventario.id_talla_camisola, productoinventario.id_sucursal, "
                    + "productoinventario.precio_costo, productoinventario.precio_venta, productoinventario.margen_ganancia, productoinventario.descripcion, productoinventario.cantidad, sucursal.nombre_sucursal, sucursal.direccion, talla_pescador.nombre_talla_pescador\n"
                    + "FROM productoinventario\n"
                    + "INNER JOIN sucursal ON sucursal.id_sucursal = productoinventario.id_sucursal\n"
                    + "INNER JOIN talla_pescador ON talla_pescador.id_talla_pescador = productoinventario.id_alla_pescador";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lstPescador = new ArrayList<>();

            while (res.next()) {
                Pescador cam = new Pescador();
                cam.setIdPescador(res.getInt("id_producto"));
                cam.setNombrePescador(res.getString("nombre_producto"));
                cam.setTalla(res.getString("nombre_talla_pescador"));
                cam.setSucursal(res.getString("nombre_sucursal"));
                cam.setPrecioCosto(res.getDouble("precio_costo"));
                cam.setPrecioVenta(res.getDouble("precio_venta"));
                cam.setMargenGanancia(res.getDouble("margen_ganancia"));
                cam.setDescripcion(res.getString("descripcion"));
                cam.setCatidad(res.getInt("cantidad"));
                lstPescador.add(cam);
            }
        } catch (Exception ex) {
            System.out.println("ERROR LISTAR BALON DAO" + ex);
        } finally {
            this.cerrar();
        }
        return lstPescador;
    }

    
    
    public void modificar(Pescador pes) throws Exception{
        try {
            this.conectar();
            query=" update productoinventario set nombre_producto=?,precio_costo=?, precio_venta=?,margen_ganancia=?,descripcion=?, cantidad=? where id_producto=?" ;
            sta=this.getCn().prepareStatement(query);
            sta.setString(1, pes.getNombrePescador());
            sta.setDouble(2, pes.getPrecioCosto());
            sta.setDouble(3, pes.getPrecioVenta());
            sta.setDouble(4, pes.getMargenGanancia());
            sta.setString(5, pes.getDescripcion());
            sta.setInt(6, pes.getCatidad());
            sta.setInt(7, pes.getIdPescador());
            sta.executeUpdate();
        } catch (Exception ex) {
            System.out.println("ERROR MODIFICAR DAO" +ex);
        }finally{
            this.cerrar();
        }
    }
}
