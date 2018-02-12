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
                dao = new CotizacionDao();
                dao.guardarCotizacion(ingreso);
                this.Limpiar();
                this.listar33();
            }catch(Exception e){
                System.out.println("ERROR INGRESO SUCURSAL BEAN  --BEAN" +e);
            }
        }
    
    
    public void listar33() {
        CotizacionDao sucDao = new CotizacionDao();
        try {
            lstCotizacion= (ArrayList<Cotizacion>) sucDao.lista();
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
    
    
    
    public void calcularGanancia(){
        double total;
        double precioCosto = ingreso.getPrecio_unitario_1();
        double ganancia = ingreso.getCantidad_1();
        total = ((ganancia*precioCosto));
        ingreso.setTotal_1(total);
        
        System.out.println("total:  " + total);
    }
    
    public void calcularGanancia2(){
        double total;
        double precioCosto = ingreso.getPrecio_unitario_2();
        double ganancia = ingreso.getCantidad_2();
        total = ((ganancia*precioCosto));
        ingreso.setTotal_2(total);
        
        System.out.println("total:  " + total);
    }
    
    
    public void calcularGanancia3(){
        double total;
        double precioCosto = ingreso.getPrecio_unitario_3();
        double ganancia = ingreso.getCantidad_3();
        total = ((ganancia*precioCosto));
        ingreso.setTotal_3(total);
        
        System.out.println("total:  " + total);
    }
    
    public void calcularGanancia4(){
        double total;
        double precioCosto = ingreso.getPrecio_unitario_4();
        double ganancia = ingreso.getCantidad_4();
        total = ((ganancia*precioCosto));
        ingreso.setTotal_4(total);
        
        System.out.println("total:  " + total);
    }
    
    public void calcularGanancia5(){
        double total;
        double precioCosto = ingreso.getPrecio_unitario_5();
        double ganancia = ingreso.getCantidad_5();
        total = ((ganancia*precioCosto));
        ingreso.setTotal_5(total);
        
        System.out.println("total:  " + total);
    }
    
    public void calcularGanancia7(){
        double total;
        double tota1 = ingreso.getTotal_1();
        double tota2 = ingreso.getTotal_2();
        double tota3 = ingreso.getTotal_3();
        double tota4 = ingreso.getTotal_4();
        double tota5 = ingreso.getTotal_5();
        total = ((tota1+tota2+tota3+tota4+tota5));
        ingreso.setGran_total(total);
        System.out.println("Gran total:  " + total);   
    }
    
    public void calcularGanancia6(){
        calcularGanancia();
        calcularGanancia2();
        calcularGanancia3();
        calcularGanancia4();
        calcularGanancia5();
        calcularGanancia7();
    }
    
    
}
    