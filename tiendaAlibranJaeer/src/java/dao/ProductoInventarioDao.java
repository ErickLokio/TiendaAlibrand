package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ProductoInventario;

/**
 * @author Walter
 */
public class ProductoInventarioDao extends DAO{
    private String query;
    private ResultSet res;
    private PreparedStatement sta;
    
    public void ingresar(ProductoInventario proInv) throws Exception{
        try {
            this.conectar();
            query="insert into productoinventario(nombre_producto, id_talla_balon, id_talla, id_talla_espinillera, id_talla_pantaloneta, id_tipo_zapatilla, id_talla_zapatilla,id_sucursal, precio_costo, precio_venta, margen_ganancia, descripcion, cantidad) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            sta=this.getCn().prepareStatement(query);
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
        }finally{
            this.cerrar();
        }
    }
    
    public void eliminar(ProductoInventario proInv) throws Exception{
        try {
            this.conectar();
            query="delete from productoinventario where id_producto=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, proInv.getId_producto());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProductoInventarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
    }
    
    public void modificar(ProductoInventario proInv) throws Exception{
        try {
            this.conectar();
            query="update productoinventario set nombre_producto=?, id_talla_balon=?, id_talla=?, id_talla_espinillera, id_talla_pantaloneta=?, id_talla_zapatilla=?, id_tipo_zapatilla=?, id_sucursal=?, precio_costo=?, precio_venta=?, margen_ganancia=?, descripcion=?, cantidad=? where id_producto=?";
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
        }finally{
            this.cerrar();
        }
    }
    
    public ArrayList<ProductoInventario> listar() throws Exception{
        ArrayList<ProductoInventario> lstProInv = null;
        try {
            this.conectar();
            query="select * from productoinventario";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lstProInv = new ArrayList<>();
            
            while(res.next()){
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
                System.out.println("id producto: "+res.getInt("id_producto"));
                proInv.setMargenGanancia(res.getDouble("margen_ganancia"));
                proInv.setNombreProducto(res.getString("nombre_producto"));
                proInv.setPrecioCosto(res.getDouble("precio_costo"));
                proInv.setPrecioVenta(res.getDouble("precio_venta"));
                lstProInv.add(proInv);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoInventarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        return lstProInv;
    }
    
}
