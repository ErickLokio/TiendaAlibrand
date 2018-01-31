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
    private List<Cotizacion> lstCotizacion = new ArrayList();

    public Cotizacion getIngreso() {
        return ingreso;
    }

    public void setIngreso(Cotizacion ingreso) {
        this.ingreso = ingreso;
    }

    public List<Cotizacion> getLstCotizacion() {
        return lstCotizacion;
    }

    public void setLstCotizacion(List<Cotizacion> lstCotizacion) {
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
                dao = new CotizacionDao();
                dao.guardarCotizacion(ingreso);
                this.Listar();
                this.Limpiar();
            }catch(Exception e){
                System.out.println("ERROR INGRESO SUCURSAL BEAN  --BEAN" +e);
            }
        }
    
    
    public void Listar(){
        CotizacionDao dao;
        
        try{
            dao = new CotizacionDao();
            lstCotizacion = dao.lista();
        }catch(Exception e){
            System.out.println("ERROR LISTAR Cotizacion --BEAN"+e);
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
}
    