package controlador;

import dao.ProductoInventarioDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.ProductoInventario;

/**
    * @author Walter
 */
@ManagedBean
@ViewScoped
public class ProductoInventarioBean {
    private ProductoInventario modProdInv = new ProductoInventario();
    private ArrayList<ProductoInventario> lstProductoInventario = new ArrayList<>();

    public ProductoInventario getModProdInv() {
        return modProdInv;
    }

    public void setModProdInv(ProductoInventario modProdInv) {
        this.modProdInv = modProdInv;
    }

    public ArrayList<ProductoInventario> getLstProductoInventario() {
        return lstProductoInventario;
    }

    public void setLstProductoInventario(ArrayList<ProductoInventario> lstProductoInventario) {
        this.lstProductoInventario = lstProductoInventario;
    }
    
    public void ingresar(){
        ProductoInventarioDao proInvDao = new ProductoInventarioDao();
        try {
            proInvDao.ingresar(modProdInv);
        } catch (Exception e) {
            System.out.println("Error al ingresar en el bean: "+e);
        }
    }
    
    public void eliminar(ProductoInventario modProdInv2){
        ProductoInventarioDao proInvDao = new ProductoInventarioDao();
        try {
            proInvDao.ingresar(modProdInv2);
        } catch (Exception e) {
            System.out.println("Error al eliminar en el bean: "+e);
        }
    }
    
    public void modificar(ProductoInventario modProdInv2){
        ProductoInventarioDao proInvDao = new ProductoInventarioDao();
        try {
            proInvDao.modificar(modProdInv2);
        } catch (Exception e) {
            System.out.println("Error al modifcar en el bean: "+e);
        }
    }
    
    public void listar(){
        ProductoInventarioDao proInvDao = new ProductoInventarioDao();
        try {
            lstProductoInventario=proInvDao.listar();
        } catch (Exception e) {
            System.out.println("Error al listar en el bean: "+e);
        }
    }
}
