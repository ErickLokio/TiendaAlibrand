package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cotizacion;

/**
 *
 * @author erick osoy
 */
public class CotizacionDao extends DAO {
    private ResultSet res;
    private PreparedStatement sta;
    private String query;
    
    
    public void guardarCotizacion(Cotizacion co) throws Exception{
        
        try{
            this.conectar();
            query = "INSERT INTO cotizacion(no_rut, id_empleado, direccion, nombre_cliente,fecha,id_producto_1,cantidad_1,precio_unitario_1,total_1,"
                    + " id_producto_2,cantidad_2,precio_unitario_2,total_2, id_producto_3,cantidad_3,precio_unitario_3,total_3,"
                    + " id_producto_4,cantidad_4,precio_unitario_4,total_4, id_producto_5,cantidad_5,precio_unitario_5,total_5, gran_total)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            sta = this.getCn().prepareStatement(query);
            //----DAOTS GENERALES
            sta.setLong(1, co.getNo_rut());
            sta.setInt(2, co.getId_empleado());
            sta.setString(3, co.getDireccion());
            sta.setString(4, co.getNombre_cliente());
            sta.setString(5, co.getFecha());
            //--- PRODUCTO 1
            sta.setInt(6, co.getId_producto_1());
            System.out.println("id: "+co.getId_producto_1());
            sta.setInt(7, co.getCantidad_1());
            sta.setDouble(8, co.getPrecio_unitario_1());
            sta.setDouble(9, co.getTotal_1());
            //--- PRODUCTO 2
            sta.setInt(10, co.getId_producto_2());
            sta.setInt(11, co.getCantidad_2());
            sta.setDouble(12, co.getPrecio_unitario_2());
            sta.setDouble(13, co.getTotal_2());
            //--- PRODUCTO 3
            sta.setInt(14, co.getId_producto_3());
            sta.setInt(15, co.getCantidad_3());
            sta.setDouble(16, co.getPrecio_unitario_3());
            sta.setDouble(17, co.getTotal_3());
            //--- PRODUCTO 4
            sta.setInt(18, co.getId_producto_4());
            sta.setInt(19, co.getCantidad_4());
            sta.setDouble(20, co.getPrecio_unitario_4());
            sta.setDouble(21, co.getTotal_4());
            //--- PRODUCTO 5
            sta.setInt(22, co.getId_producto_5());
            sta.setInt(23, co.getCantidad_5());
            sta.setDouble(24, co.getPrecio_unitario_5());
            sta.setDouble(25, co.getTotal_5());
            sta.setDouble(26, co.getGran_total());
            
            sta.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR GUARDAR COTIZACION DAO" +e);
        }finally{
            this.cerrar();
        }
    }
    
    
    public List<Cotizacion> lista() throws Exception{
        List<Cotizacion> lista = null;
        
        try{
            this.conectar();
            query = "SELECT * FROM cotizacion";
            sta = this.getCn().prepareCall(query);
            res = sta.executeQuery();
            lista = new ArrayList();
            
            while(res.next()){
                Cotizacion co = new Cotizacion();
                co.setId_cotizacion(res.getInt("id_cotizacion"));
                co.setNo_rut(res.getLong("no_rut"));
                co.setId_empleado(res.getInt("id_empleado"));
                co.setDireccion(res.getString("direccion"));
                co.setNombre_cliente(res.getString("nombre_cliente"));
                co.setFecha(res.getString("fecha"));
                
                //Producto 1
                co.setId_producto_1(res.getInt("id_producto_1"));
                co.setCantidad_1(res.getInt("cantidad_1"));
                co.setPrecio_unitario_1(res.getDouble("precio_unitario_1"));
                co.setTotal_1(res.getDouble("total_1"));
                //Producto 2
                co.setId_producto_2(res.getInt("id_producto_2"));
                co.setCantidad_2(res.getInt("cantidad_2"));
                co.setPrecio_unitario_2(res.getDouble("precio_unitario_2"));
                co.setTotal_2(res.getDouble("total_2"));
                //Producto 3
                co.setId_producto_3(res.getInt("id_producto_3"));
                co.setCantidad_3(res.getInt("cantidad_3"));
                co.setPrecio_unitario_3(res.getDouble("precio_unitario_3"));
                co.setTotal_3(res.getDouble("total_3"));
                //Producto 4
                co.setId_producto_4(res.getInt("id_producto_4"));
                co.setCantidad_4(res.getInt("cantidad_4"));
                co.setPrecio_unitario_4(res.getDouble("precio_unitario_4"));
                co.setTotal_4(res.getDouble("total_4"));
                //Producto 5
                co.setId_producto_5(res.getInt("id_producto_5"));
                co.setCantidad_5(res.getInt("cantidad_5"));
                co.setPrecio_unitario_5(res.getDouble("precio_unitario_5"));
                co.setTotal_5(res.getDouble("total_5"));
                co.setGran_total(res.getDouble("gran_total"));
                
                lista.add(co);
            }
        }catch(Exception e){
            System.out.println("ERROR LISTAR COTIZACION DAO" +e);
        }finally{
            this.cerrar();
        }
        
        return lista;
    }
    
    
    
    public Cotizacion leerID(Cotizacion co) throws Exception{
        Cotizacion cot = null;
        
        try{
            this.conectar();
            query = "SELECT FROM cotizacion WHERE id_cotizacion =?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, co.getId_cotizacion());
            res = sta.executeQuery();
            
            while(res.next()){
                cot = new Cotizacion();
                cot.setId_cotizacion(res.getInt("id_cotizacion"));
                cot.setNo_rut(res.getLong("no_rut"));
                cot.setId_empleado(res.getInt("id_empleado"));
                cot.setDireccion(res.getString("direccion"));
                cot.setNombre_cliente(res.getString("nombre_cliente"));
                cot.setFecha(res.getString("fecha"));
                
                //Producto 1
                cot.setId_producto_1(res.getInt("id_producto_1"));
                cot.setCantidad_1(res.getInt("cantidad_1"));
                cot.setPrecio_unitario_1(res.getDouble("precio_unitario_1"));
                cot.setTotal_1(res.getDouble("total_1"));
                //Producto 2
                cot.setId_producto_2(res.getInt("id_producto_2"));
                cot.setCantidad_2(res.getInt("cantidad_2"));
                cot.setPrecio_unitario_2(res.getDouble("precio_unitario_2"));
                cot.setTotal_2(res.getDouble("total_2"));
                //Producto 3
                cot.setId_producto_3(res.getInt("id_producto_3"));
                cot.setCantidad_3(res.getInt("cantidad_3"));
                cot.setPrecio_unitario_3(res.getDouble("precio_unitario_3"));
                cot.setTotal_3(res.getDouble("total_3"));
                //Producto 4
                cot.setId_producto_4(res.getInt("id_producto_4"));
                cot.setCantidad_4(res.getInt("cantidad_4"));
                cot.setPrecio_unitario_4(res.getDouble("precio_unitario_4"));
                cot.setTotal_4(res.getDouble("total_4"));
                //Producto 5
                cot.setId_producto_5(res.getInt("id_producto_5"));
                cot.setCantidad_5(res.getInt("cantidad_5"));
                cot.setPrecio_unitario_5(res.getDouble("precio_unitario_5"));
                cot.setTotal_5(res.getDouble("total_5"));
                cot.setGran_total(res.getDouble("gran_total"));
            }
            
        }catch(Exception e){
            System.out.println("ERROR BUSCAR COTIZACION DAO " +e);
        }finally{
            this.cerrar();
        }
        return cot;
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
}
