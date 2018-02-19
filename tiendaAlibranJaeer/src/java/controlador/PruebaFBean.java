package controlador;

import dao.ProductoInventarioDao;
import dao.PruebaF;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.ProductoInventario;

/**
 *
 * @author jeoloso
 */

@ManagedBean
@ViewScoped
public class PruebaFBean {
    private ProductoInventario ingreso = new ProductoInventario();
    private List<ProductoInventario> lstProducto ;
    private ArrayList<ProductoInventario> lstProductoInventario = new ArrayList();

    public ProductoInventario getIngreso() {
        return ingreso;
    }

    public void setIngreso(ProductoInventario ingreso) {
        this.ingreso = ingreso;
    }

    public List<ProductoInventario> getLstProducto() {
        return lstProducto;
    }

    public void setLstProducto(List<ProductoInventario> lstProducto) {
        this.lstProducto = lstProducto;
    }

    public ArrayList<ProductoInventario> getLstProductoInventario() {
        return lstProductoInventario;
    }

    public void setLstProductoInventario(ArrayList<ProductoInventario> lstProductoInventario) {
        this.lstProductoInventario = lstProductoInventario;
    }
    
    
    
    
    public void leerID() {
        System.out.println("llego");
        PruebaF dao;
        ProductoInventario temp;
        try {
            dao = new PruebaF();
            temp = dao.leerID(ingreso);
            if (temp != null) {
                this.ingreso = temp;
            }
        } catch (Exception e) {
            System.out.println("No se pudo leer ID en PersonaBean" + e);
        }
    }
    
    public void listar() {
        ProductoInventarioDao proInvDao = new ProductoInventarioDao();
        try {
            lstProductoInventario = proInvDao.listar();
        } catch (Exception e) {
            System.out.println("Error al listar en el bean: " + e);
        }
    }
    
    
    
    
}
