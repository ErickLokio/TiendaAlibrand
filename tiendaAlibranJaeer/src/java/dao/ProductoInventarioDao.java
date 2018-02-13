package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ProductoEspinillera;
import modelo.ProductoInventario;
import modelo.Talla;
import modelo.TallaEspinillera;
import modelo.innerProductoInventario;

/**
 * @author Walter
 */
public class ProductoInventarioDao extends DAO {

    private String query;
    private ResultSet res;
    private PreparedStatement sta;

    public void ingresar(ProductoInventario proInv) throws Exception {
        try {
            this.conectar();
            query = "insert into productoinventario(nombre_producto, id_talla_balon, id_talla, id_talla_espinillera, id_talla_pantaloneta, id_tipo_zapatilla, id_talla_zapatilla,id_sucursal, precio_costo, precio_venta, margen_ganancia, cantidad, descripcion) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, proInv.getNombreProducto());
            sta.setInt(2, proInv.getIdTallaBalon());
            sta.setInt(3, proInv.getIdTalla());
            sta.setInt(4, proInv.getIdTallaEspinillera());
            sta.setInt(5, proInv.getIdTallaPantaloneta());
            sta.setInt(6, proInv.getIdTipoZapatilla());
            sta.setInt(7, proInv.getIdTallaZapatilla());
            sta.setInt(8, proInv.getIdSucursal());
            sta.setDouble(9, proInv.getPrecioCosto());
            sta.setDouble(10, proInv.getPrecioVenta());
            sta.setDouble(11, proInv.getMargenGanancia());
            sta.setInt(12, proInv.getCantidad());
            sta.setString(13, proInv.getDescripcion());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProductoInventarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrar();
        }
    }

    public void ingresarEspinillera(ProductoInventario proInv) throws Exception {
        try {
            this.conectar();
            query = "insert into productoinventario(nombre_producto, id_talla_espinillera, id_sucursal, precio_costo, precio_venta, margen_ganancia, cantidad, descripcion) values(?,?,?,?,?,?,?,?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, proInv.getNombreProducto());
            sta.setInt(2, proInv.getIdTallaEspinillera());
            sta.setInt(3, proInv.getIdSucursal());
            sta.setDouble(4, proInv.getPrecioCosto());
            sta.setDouble(5, proInv.getPrecioVenta());
            sta.setDouble(6, proInv.getMargenGanancia());
            sta.setInt(7, proInv.getCantidad());
            sta.setString(8, proInv.getDescripcion());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProductoInventarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrar();
        }
    }

    public void ingresarPescador(ProductoInventario proInv) throws Exception {
        try {
            this.conectar();
            query = "insert into productoinventario(nombre_producto, id_talla, id_sucursal, precio_costo, precio_venta, margen_ganancia, cantidad, descripcion) values(?,?,?,?,?,?,?,?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, proInv.getNombreProducto());
            sta.setInt(2, proInv.getIdTalla());
            sta.setInt(3, proInv.getIdSucursal());
            sta.setDouble(4, proInv.getPrecioCosto());
            sta.setDouble(5, proInv.getPrecioVenta());
            sta.setDouble(6, proInv.getMargenGanancia());
            sta.setInt(7, proInv.getCantidad());
            sta.setString(8, proInv.getDescripcion());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProductoInventarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrar();
        }
    }

    public void eliminar(int idProducto) throws Exception {
        try {
            this.conectar();
            query = "delete from productoinventario where id_producto=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, idProducto);
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProductoInventarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrar();
        }

    }

    public void modificar(ProductoInventario proInv) throws Exception {
        try {  
            this.conectar();
            query = "update productoinventario set nombre_producto=?, id_talla_balon=?, id_talla=?, id_talla_espinillera, id_talla_pantaloneta=?, id_talla_zapatilla=?, id_tipo_zapatilla=?, id_sucursal=?, precio_costo=?, precio_venta=?, margen_ganancia=?, descripcion=?, cantidad=? where id_producto=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, proInv.getNombreProducto());
            sta.setInt(2, proInv.getIdTallaBalon());
            sta.setInt(3, proInv.getIdTalla());
            sta.setInt(4, proInv.getIdTallaEspinillera());
            sta.setInt(5, proInv.getIdTallaPantaloneta());
            sta.setInt(6, proInv.getIdTallaZapatilla());
            sta.setInt(7, proInv.getIdTipoZapatilla());
            sta.setInt(8, proInv.getIdSucursal());
            sta.setDouble(9, proInv.getPrecioCosto());
            sta.setDouble(10, proInv.getPrecioVenta());
            sta.setDouble(11, proInv.getMargenGanancia());
            sta.setString(12, proInv.getDescripcion());
            sta.setInt(13, proInv.getCantidad());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProductoInventarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrar();
        }
    }
    
    public void modificarEspinillera(ProductoEspinillera proEsp) throws Exception {
        try {
            this.conectar();
            query = "update productoinventario set nombre_producto=?, id_talla_espinillera, id_sucursal=?, precio_costo=?, precio_venta=?, margen_ganancia=?, descripcion=?, cantidad=? where id_producto=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, proEsp.getNombreProducto());
            sta.setInt(2, proEsp.getIdTallaEspinillera());                    
            sta.setInt(3, proEsp.getIdSucursal());
            sta.setDouble(4, proEsp.getPrecioCosto());
            sta.setDouble(5, proEsp.getPrecioVenta());
            sta.setDouble(6, proEsp.getMargenGanancia());
            sta.setString(7, proEsp.getDescripcion());
            sta.setInt(8, proEsp.getCantidad());
            sta.setInt(9, proEsp.getId_producto());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProductoInventarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrar();
        }
    }

    public ArrayList<Talla> listarTalla() throws Exception {
        ArrayList<Talla> lstTalla = null;
        try {
            this.conectar();
            query = "select * from talla";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lstTalla = new ArrayList<>();

            while (res.next()) {
                Talla talMod = new Talla();
                talMod.setIdTalla(res.getInt("id_talla"));
                talMod.setTalla(res.getString("nombre_talla"));
                lstTalla.add(talMod);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoInventarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrar();
        }
        return lstTalla;
    }

    public ArrayList<TallaEspinillera> listarTallaEspinillera() throws Exception {
        ArrayList<TallaEspinillera> lstTalla = null;
        try {
            this.conectar();
            query = "select * from talla_espinillera";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lstTalla = new ArrayList<>();

            while (res.next()) {
                TallaEspinillera talMod = new TallaEspinillera();
                talMod.setIdTallaEspinillera(res.getInt("id_talla_espinillera"));
                talMod.setTallaEspinillera(res.getString("nombre_talla_espinillera"));
                lstTalla.add(talMod);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoInventarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrar();
        }
        return lstTalla;
    }

    public ArrayList<ProductoInventario> listar() throws Exception {
        ArrayList<ProductoInventario> lstProInv = null;
        try {
            this.conectar();
            query = "select * from productoinventario";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lstProInv = new ArrayList<>();

            while (res.next()) {
                ProductoInventario proInv = new ProductoInventario();
                proInv.setCantidad(res.getInt("cantidad"));
                proInv.setDescripcion(res.getString("descripcion"));
                proInv.setIdSucursal(res.getInt("id_sucursal"));
                proInv.setIdTalla(res.getInt("id_talla"));
                proInv.setIdTallaBalon(res.getInt("id_talla_balon"));
                proInv.setIdTallaEspinillera(res.getInt("id_talla_espinillera"));
                proInv.setIdTallaPantaloneta(res.getInt("id_talla_pantaloneta"));
                proInv.setIdTallaZapatilla(res.getInt("id_talla_zapatilla"));
                proInv.setIdTipoZapatilla(res.getInt("id_tipo_zapatilla"));
                proInv.setId_producto(res.getInt("id_producto"));
                System.out.println("id producto: " + res.getInt("id_producto"));
                proInv.setMargenGanancia(res.getDouble("margen_ganancia"));
                proInv.setNombreProducto(res.getString("nombre_producto"));
                proInv.setPrecioCosto(res.getDouble("precio_costo"));
                proInv.setPrecioVenta(res.getDouble("precio_venta"));
                lstProInv.add(proInv);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoInventarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrar();
        }
        return lstProInv;
    }

    public ArrayList<innerProductoInventario> listarTodo() throws Exception {
        ArrayList<innerProductoInventario> lstInnerProducto = new ArrayList<>();
        try {
            this.conectar();
            query = "SELECT productoinventario.id_producto, productoinventario.nombre_producto, productoinventario.id_talla_balon, productoinventario.id_talla, productoinventario.id_talla_espinillera, productoinventario.id_talla_pantaloneta, productoinventario.id_talla_zapatilla, productoinventario.id_tipo_zapatilla, productoinventario.id_sucursal, productoinventario.precio_costo, productoinventario.precio_venta, productoinventario.margen_ganancia, productoinventario.descripcion, productoinventario.cantidad, talla.*, talla_balon.*, talla_espinillera.*, talla_pantaloneta.*, talla_zapatilla.*, sucursal.*\n"
                    + "FROM productoinventario\n"
                    + "LEFT JOIN talla ON talla.id_talla = productoinventario.id_talla\n"
                    + "LEFT JOIN talla_balon ON talla_balon.id_talla_balon = productoinventario.id_talla_balon\n"
                    + "LEFT JOIN talla_espinillera ON talla_espinillera.id_talla_espinillera = productoinventario.id_talla_espinillera\n"
                    + "LEFT JOIN talla_pantaloneta ON talla_pantaloneta.id_talla_pantaloneta = productoinventario.id_talla_pantaloneta\n"
                    + "LEFT JOIN talla_zapatilla ON talla_zapatilla.id_talla_zapatilla = productoinventario.id_talla_zapatilla\n"
                    + "LEFT JOIN sucursal ON sucursal.id_sucursal = productoinventario.id_sucursal\n"
                    + "UNION\n"
                    + "SELECT productoinventario.id_producto, productoinventario.nombre_producto, productoinventario.id_talla_balon, productoinventario.id_talla, productoinventario.id_talla_espinillera, productoinventario.id_talla_pantaloneta, productoinventario.id_talla_zapatilla, productoinventario.id_tipo_zapatilla, productoinventario.id_sucursal, productoinventario.precio_costo, productoinventario.precio_venta, productoinventario.margen_ganancia, productoinventario.descripcion, productoinventario.cantidad, talla.*, talla_balon.*, talla_espinillera.*, talla_pantaloneta.*, talla_zapatilla.*, sucursal.*\n"
                    + "FROM productoinventario JOIN talla ON talla.id_talla = productoinventario.id_talla\n"
                    + "RIGHT JOIN talla_balon ON talla_balon.id_talla_balon = productoinventario.id_talla_balon\n"
                    + "RIGHT JOIN talla_espinillera ON talla_espinillera.id_talla_espinillera = productoinventario.id_talla_espinillera\n"
                    + "RIGHT JOIN talla_pantaloneta ON talla_pantaloneta.id_talla_pantaloneta = productoinventario.id_talla_pantaloneta\n"
                    + "RIGHT JOIN talla_zapatilla ON talla_zapatilla.id_talla_zapatilla = productoinventario.id_talla_zapatilla\n"
                    + "RIGHT JOIN sucursal ON sucursal.id_sucursal = productoinventario.id_sucursal";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            while(res.next()){
                innerProductoInventario innPro = new innerProductoInventario();
                innPro.setId_producto(res.getInt("id_producto"));
                innPro.setNombreProducto(res.getString("nombre_producto"));
                innPro.setCantidad(res.getInt("cantidad"));
                innPro.setDescripcion(res.getString("descripcion"));
                innPro.setIdSucursal(res.getInt("id_sucursal"));
                innPro.setIdTalla(res.getInt("id_talla"));
                innPro.setIdTallaBalon(res.getInt("id_talla_balon"));
                innPro.setIdTallaEspinillera(res.getInt("id_talla_espinillera"));
                innPro.setIdTallaPantaloneta(res.getInt("id_talla_pantaloneta"));
                innPro.setIdTipoZapatilla(res.getInt("id_talla_zapatilla"));
                innPro.setMargenGanancia(res.getInt("margen_ganancia"));
                innPro.setIdTallaZapatilla(res.getInt("id_talla_zapatilla"));
                innPro.setNombreTalla(res.getString("nombre_talla"));
                innPro.setNombreTallaBalon(res.getString("nombre_talla_balon"));
                innPro.setNombreTallaEspinillera(res.getString("nombre_talla_espinillera"));
                innPro.setNombreTallaPantaloneta(res.getString("nombre_talla_pantaloneta"));
                innPro.setNombreTallaZapatilla(res.getString("nombre_zapatilla"));
                innPro.setPrecioCosto(res.getDouble("precio_costo"));
                innPro.setPrecioVenta(res.getDouble("precio_venta"));
                innPro.setSucursal(res.getString("nombre_sucursal"));
                System.out.println("hola: "+res.getString("nombre_sucursal"));
                lstInnerProducto.add(innPro);                        
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoInventarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrar();
        }

        return lstInnerProducto;
    }
    
    public ArrayList<ProductoEspinillera> listarProductoEspinillera() throws Exception{
        ArrayList<ProductoEspinillera> lstProEspinillera = null;
        try {
            this.conectar();
            query = "select productoinventario.id_producto, productoinventario.nombre_producto, productoinventario.id_talla_espinillera, "
                    + "productoinventario.id_sucursal, productoinventario.precio_costo, productoinventario.precio_venta, productoinventario.margen_ganancia, productoinventario.descripcion, productoinventario.cantidad, "
                    + "sucursal.nombre_sucursal, sucursal.direccion, talla_espinillera.nombre_talla_espinillera "
                    + "FROM productoinventario "
                    + "INNER JOIN sucursal ON sucursal.id_sucursal = productoinventario.id_sucursal "
                    + "INNER JOIN talla_espinillera ON talla_espinillera.id_talla_espinillera = productoinventario.id_talla_espinillera ";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lstProEspinillera = new ArrayList<>();
            
            while(res.next()){
                ProductoEspinillera modProEsp = new ProductoEspinillera();
                modProEsp.setId_producto(res.getInt("id_producto"));
                modProEsp.setNombreProducto(res.getString("nombre_producto"));
                modProEsp.setCantidad(res.getInt("cantidad"));
                modProEsp.setDescripcion(res.getString("descripcion"));
                modProEsp.setIdSucursal(res.getInt("id_sucursal"));
                modProEsp.setSucursal(res.getString("nombre_sucursal"));
                modProEsp.setIdTallaEspinillera(res.getInt("id_talla_espinillera"));
                modProEsp.setMargenGanancia(res.getDouble("margen_ganancia"));
                modProEsp.setNombreTallaEspinillera(res.getString("nombre_talla_espinillera"));
                modProEsp.setPrecioCosto(res.getDouble("precio_costo"));
                modProEsp.setPrecioVenta(res.getDouble("precio_venta"));
                lstProEspinillera.add(modProEsp);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ProductoInventarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
       return lstProEspinillera;
    }
}
