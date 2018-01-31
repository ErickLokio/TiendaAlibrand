package controlador;

import dao.ProductoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Producto;

/**
 *
 * @author erick osoy
 */

@ManagedBean
@ViewScoped
public class ProductoBean {
    private Producto ingreso = new Producto();
    private List<Producto> lstProducto = new ArrayList();

    public Producto getIngreso() {
        return ingreso;
    }

    public void setIngreso(Producto ingreso) {
        this.ingreso = ingreso;
    }

    public List<Producto> getLstProducto() {
        return lstProducto;
    }

    public void setLstProducto(List<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }
    
    
    
    public void Limpiar(){
        ingreso.setId_producto(0);
        ingreso.setId_sucursal(0);
        ingreso.setPrecio_costo(0);
        ingreso.setPrecio_venta(0);
        ingreso.setMargen_ganancia(0);
        ingreso.setDescripcion("");
        ingreso.setCantidad_total(0);
    }
    
    
    
     public void insertar(){
        ProductoDAO dao;
        
        try{
            dao = new ProductoDAO();
            dao.Guardar(ingreso);
            this.Listar();
            this.Limpiar();
        }catch(Exception e){
            System.out.println("ERROR INGRESO PRODUCTO BEAN  --BEAN" +e);
        }
    }
     
     
     
     public void Listar(){
        ProductoDAO dao;
        
        try{
            dao = new ProductoDAO();
            lstProducto = dao.lista();
        }catch(Exception e){
            System.out.println("ERROR LISTAR PRODUCTO DAO --BEAN"+e);
        }
    }
    
    public void modificar(){
        ProductoDAO dao;
        
        try{
            dao = new ProductoDAO();
            dao.modificar(ingreso);
            this.Listar();
        }catch(Exception e){
            System.out.println("ERROR MODIFICAR PRODUCTO BEAN 2-- Bean" +e);
        }
    }
    
    
    public void Eliminar(Producto pro){
        ProductoDAO dao;
        
        try{
            dao = new ProductoDAO();
            dao.eliminar(pro);
            this.Listar();
        }catch(Exception e){
            System.out.println("ERROR ELIMINAR PRODUCTO BEAN 2 -- BEAN" +e);
        }
    }
    
    public void leerID(Producto pro){
        ProductoDAO dao;
        Producto temp;
        
        try{
            dao = new ProductoDAO();
            temp = dao.leerID(pro);
            
            if(temp != null){
                this.ingreso = temp;
            }
        }catch(Exception e){
            System.out.println("ERROR BUSCAR PRODUCTO BEAN 2 --BEAN" +e);
        }
        
    }
}
