package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cotizacion;
import modelo.Factura;
import modelo.ProductoInventario;

/**
 *
 * @author erick osoy
 */
public class FacturaDao extends DAO {

    private ResultSet res;
    private PreparedStatement sta;
    private String query;

    public void guardarFactura(Factura fa) throws Exception {

        try {
            this.conectar();
            query = "INSERT INTO FacturaFinal(nombre_cliente, nit, fecha,id_producto_1,cantidad_1,precio_unitario_1,descuento_1,total_1,"
                    + " id_producto_2,cantidad_2,precio_unitario_2,descuento_2,total_2, id_producto_3,cantidad_3,precio_unitario_3,descuento_3,total_3,"
                    + " id_producto_4,cantidad_4,precio_unitario_4,descuento_4,total_4, id_producto_5,cantidad_5,precio_unitario_5,descuento_5,total_5,"
                    + " id_producto_6,cantidad_6,precio_unitario_6,descuento_6,total_6, id_producto_7,cantidad_7,precio_unitario_7,descuento_7,total_7,"
                    + " id_producto_8,cantidad_8,precio_unitario_8,descuento_8,total_8, id_producto_9,cantidad_9,precio_unitario_9,descuento_9,total_9, total_factura)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            sta = this.getCn().prepareStatement(query);
            //----DAOTS GENERALES
            sta.setString(1, fa.getNombre_cliente());
            sta.setLong(2, fa.getNit());
            sta.setString(3, fa.getFecha());

            //--- PRODUCTO 1
            sta.setInt(4, fa.getId_producto_1());
            sta.setInt(5, fa.getCantidad_1());
            sta.setDouble(6, fa.getPrecio_unitario_1());
            sta.setDouble(7, fa.getDescuento_1());
            sta.setDouble(8, fa.getTotal_1());
            //--- PRODUCTO 2
            sta.setInt(9, fa.getId_producto_2());
            sta.setInt(10, fa.getCantidad_2());
            sta.setDouble(11, fa.getPrecio_unitario_2());
            sta.setDouble(12, fa.getDescuento_2());
            sta.setDouble(13, fa.getTotal_2());
            //--- PRODUCTO 3
            sta.setInt(14, fa.getId_producto_3());
            sta.setInt(15, fa.getCantidad_3());
            sta.setDouble(16, fa.getPrecio_unitario_3());
            sta.setDouble(17, fa.getDescuento_3());
            sta.setDouble(18, fa.getTotal_3());
            //--- PRODUCTO 4
            sta.setInt(19, fa.getId_producto_4());
            sta.setInt(20, fa.getCantidad_4());
            sta.setDouble(21, fa.getPrecio_unitario_4());
            sta.setDouble(22, fa.getDescuento_4());
            sta.setDouble(23, fa.getTotal_4());
            //--- PRODUCTO 5
            sta.setInt(24, fa.getId_producto_5());
            sta.setInt(25, fa.getCantidad_5());
            sta.setDouble(26, fa.getPrecio_unitario_5());
            sta.setDouble(27, fa.getDescuento_5());
            sta.setDouble(28, fa.getTotal_5());
            //--- PRODUCTO 6
            sta.setInt(29, fa.getId_producto_6());
            sta.setInt(30, fa.getCantidad_6());
            sta.setDouble(31, fa.getPrecio_unitario_6());
            sta.setDouble(32, fa.getDescuento_6());
            sta.setDouble(33, fa.getTotal_6());
            //--- PRODUCTO 7
            sta.setInt(34, fa.getId_producto_7());
            sta.setInt(35, fa.getCantidad_7());
            sta.setDouble(36, fa.getPrecio_unitario_7());
            sta.setDouble(37, fa.getDescuento_7());
            sta.setDouble(38, fa.getTotal_7());
            //--- PRODUCTO 8
            sta.setInt(39, fa.getId_producto_8());
            sta.setInt(40, fa.getCantidad_8());
            sta.setDouble(41, fa.getPrecio_unitario_8());
            sta.setDouble(42, fa.getDescuento_8());
            sta.setDouble(43, fa.getTotal_8());
            //--- PRODUCTO 5
            sta.setInt(44, fa.getId_producto_9());
            sta.setInt(45, fa.getCantidad_9());
            sta.setDouble(46, fa.getPrecio_unitario_9());
            sta.setDouble(47, fa.getDescuento_9());
            sta.setDouble(48, fa.getTotal_9());
            
            sta.setDouble(49, fa.getTotal_factura());

            sta.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR GUARDAR FACTURA DAO" + e);
        } finally {
            this.cerrar();
        }
    }
    
    
    
    
    
    public ArrayList<Cotizacion> listarProductos() throws Exception{
        ArrayList<Cotizacion> lstProInv = null;
        try {
            this.conectar();
            query="select * from productoinventario";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lstProInv = new ArrayList<>();
            
            while(res.next()){
                Cotizacion co = new Cotizacion();
                co.setId_producto_1(res.getInt("id_producto"));
                co.setNombre_producto(res.getString("nombre_producto"));
                lstProInv.add(co);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoInventarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        return lstProInv;
    } 
    
    
    
    
    public void modificar(ProductoInventario pro) throws Exception{
        
        try{
            this.conectar();
            query = "update productoinventario set cantidad_salida=? where id_producto=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, pro.getCantidad_salida());
            sta.setInt(2, pro.getId_producto());
            sta.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR " +e);
        }finally{
            this.cerrar();
        }
    }
    
    public void modificar2(ProductoInventario pro) throws Exception{
        
        try{
            this.conectar();
            query = "update productoinventario set cantidad_salida=? where id_producto=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, pro.getCantidad_salida());
            sta.setInt(2, pro.getId_producto());
            sta.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR " +e);
        }finally{
            this.cerrar();
        }
    }
    public void modificar3(ProductoInventario pro) throws Exception{
        
        try{
            this.conectar();
            query = "update productoinventario set cantidad_salida=? where id_producto=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, pro.getCantidad_salida());
            sta.setInt(2, pro.getId_producto());
            sta.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR " +e);
        }finally{
            this.cerrar();
        }
    }
    
    
    
    
    public void modificarTotalFinal(ProductoInventario pro) throws Exception{
        
        try{
            this.conectar();
            query = "update productoinventario set cantidad=? where id_producto=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, pro.getCantidad());
            sta.setInt(2, pro.getId_producto());
            sta.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR " +e);
        }finally{
            this.cerrar();
        }
    }
    
    
    
}
