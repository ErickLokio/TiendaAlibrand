package controlador;

import dao.CotizacionDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Cotizacion;

/**
 *
 * @author erick osoy
 */
@ManagedBean
@ViewScoped
public class CotizacionBean {
    private Cotizacion ingreso = new Cotizacion();
    private ArrayList<Cotizacion> lstCotizacion = new ArrayList<>();
    

    public Cotizacion getIngreso() {
        return ingreso;
    }

    public void setIngreso(Cotizacion ingreso) {
        this.ingreso = ingreso;
    }

    public ArrayList<Cotizacion> getLstCotizacion() {
        return lstCotizacion;
    }

    public void setLstCotizacion(ArrayList<Cotizacion> lstCotizacion) {
        this.lstCotizacion = lstCotizacion;
    }
    
    public void Limpiar(){
        ingreso.setId_cotizacion(0);
        ingreso.setNo_rut(0);
        ingreso.setId_empleado(0);
        ingreso.setDireccion("");
        ingreso.setNombre_cliente("");
        ingreso.setFecha("");
        ingreso.setId_producto_1(0);
        ingreso.setCantidad_1(0);
        ingreso.setPrecio_unitario_1(0);
        ingreso.setTotal_1(0);
        
        ingreso.setId_producto_2(0);
        ingreso.setCantidad_2(0);
        ingreso.setPrecio_unitario_2(0);
        ingreso.setTotal_2(0);
        
        ingreso.setId_producto_3(0);
        ingreso.setCantidad_3(0);
        ingreso.setPrecio_unitario_3(0);
        ingreso.setTotal_3(0);
        
        ingreso.setId_producto_4(0);
        ingreso.setCantidad_4(0);
        ingreso.setPrecio_unitario_4(0);
        ingreso.setTotal_4(0);
        
        ingreso.setId_producto_5(0);
        ingreso.setCantidad_5(0);
        ingreso.setPrecio_unitario_5(0);
        ingreso.setTotal_5(0);
    }
    
    
    
    
    
    public void insertar(){
            CotizacionDao dao;

            try{
                ingreso.getId_producto_1();
                System.out.println("prueba :" +ingreso.getId_producto_1());
                
                dao = new CotizacionDao();
                dao.guardarCotizacion(ingreso);
                
                
                this.listar33();
                this.Limpiar();
            }catch(Exception e){
                System.out.println("ERROR INGRESO SUCURSAL BEAN  --BEAN" +e);
            }
        }
    
    
    public void listar33() {
        CotizacionDao sucDao = new CotizacionDao();
        try {
            lstCotizacion= (ArrayList<Cotizacion>) sucDao.lista();
            lstCotizacion.get(1).getId_producto_1();
            lstCotizacion.get(1).getId_producto_2();
            lstCotizacion.get(1).getId_producto_3();
            lstCotizacion.get(1).getId_producto_4();
            lstCotizacion.get(1).getId_producto_5();
            
            System.out.println(lstCotizacion.get(1).getId_producto_1());
            System.out.println(lstCotizacion.get(1).getId_producto_2());
            System.out.println(lstCotizacion.get(1).getId_producto_3());
            System.out.println(lstCotizacion.get(1).getId_producto_4());
            System.out.println(lstCotizacion.get(1).getId_producto_5());

        } catch (Exception e) {
            System.out.println("Error al listar Chumpa bean");
        }
        
    }
    
    
    public void leerID(Cotizacion co){
        CotizacionDao dao;
        Cotizacion temp;
        
        try{
            dao = new CotizacionDao();
            temp = dao.leerID(co);
            
            if(temp != null){
                this.ingreso = temp;
            }
        }catch(Exception e){
            System.out.println("ERROR BUSCAR Cotizacion BEAN --BEAN" +e);
        }
        
    }
    
    
    
    
    public void listaProducto(){
        CotizacionDao dao;
        
        
        try{
            dao = new CotizacionDao();
            lstCotizacion = dao.listarProductos();
        
        }catch(Exception e){
            System.out.println("ERROR BUSCAR Cotizacion BEAN --BEAN" +e);
        }
        
        
    }
}
    