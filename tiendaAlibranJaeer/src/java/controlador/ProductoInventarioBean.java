package controlador;

import dao.ProductoInventarioDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.ProductoEspinillera;
import modelo.ProductoInventario;
import modelo.Talla;
import modelo.TallaEspinillera;
/**
 * @author Walter
 */
@ManagedBean
@ViewScoped
public class ProductoInventarioBean {

    private ProductoInventario modProdInv = new ProductoInventario();
    private ArrayList<ProductoInventario> lstProductoInventario = new ArrayList();
    private ArrayList<Talla> lstTalla = new ArrayList();
    private ArrayList<TallaEspinillera> lstTallaEspinillera = new ArrayList();
    private ArrayList<ProductoEspinillera> lstProEsp = new ArrayList();

    public ArrayList<ProductoEspinillera> getLstProEsp() {
        return lstProEsp;
    }

    public void setLstProEsp(ArrayList<ProductoEspinillera> lstProEsp) {
        this.lstProEsp = lstProEsp;
    }
    
    public ArrayList<Talla> getLstTalla() {
        return lstTalla;
    }

    public void setLstTalla(ArrayList<Talla> lstTalla) {
        this.lstTalla = lstTalla;
    }

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

    public ArrayList<TallaEspinillera> getLstTallaEspinillera() {
        return lstTallaEspinillera;
    }

    public void setLstTallaEspinillera(ArrayList<TallaEspinillera> lstTallaEspinillera) {
        this.lstTallaEspinillera = lstTallaEspinillera;
    }
    
    public void ingresarPescador() {
        ProductoInventarioDao proInvDao = new ProductoInventarioDao();
        try {
            proInvDao.ingresarPescador(modProdInv);
        } catch (Exception e) {
            System.out.println("Error al ingresar en el bean: " + e);
        }
    }

    public void ingresarEspinillera() {
        ProductoInventarioDao proInvDao = new ProductoInventarioDao();
        try {
            proInvDao.ingresarEspinillera(modProdInv);
        } catch (Exception e) {
            System.out.println("Error al ingresar en el bean: " + e);
        }
    }

    public void eliminar(int idProducto) {
        ProductoInventarioDao proInvDao = new ProductoInventarioDao();
        try {
            proInvDao.eliminar(idProducto);
        } catch (Exception e) {
            System.out.println("Error al eliminar en el bean: " + e);
        }
    }

    public void modificar(ProductoInventario modProdInv2) {
        ProductoInventarioDao proInvDao = new ProductoInventarioDao();
        try {
            proInvDao.modificar(modProdInv2);
        } catch (Exception e) {
            System.out.println("Error al modifcar en el bean: " + e);
        }
    }
    
    public void modificarEsp(ProductoEspinillera proEsp) {
        ProductoInventarioDao proInvDao = new ProductoInventarioDao();
        try {
            proInvDao.modificarEspinillera(proEsp);
        } catch (Exception e) {
            System.out.println("Error al modifcar en el bean: " + e);
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

    public void listarTalla() {
        ProductoInventarioDao proInvDao = new ProductoInventarioDao();
        try {
            lstTalla = proInvDao.listarTalla();
        } catch (Exception e) {
            System.out.println("Error al listar en el bean: " + e);
        }
    }

    public void listarTallaEspinillera() {
        ProductoInventarioDao proInvDao = new ProductoInventarioDao();
        try {
            lstTallaEspinillera = proInvDao.listarTallaEspinillera();
        } catch (Exception e) {
            System.out.println("Error al listar en el bean: " + e);
        }
    }
    public void listarProEspi(){
        ProductoInventarioDao proInvDao = new ProductoInventarioDao();
        try {
            lstProEsp = proInvDao.listarProductoEspinillera();
        } catch (Exception e) {
            System.out.println("Error al Listar porducto espinillera: "+e);
        }
    }
    public void calcularGanancia() {
        double total;
        double precioCosto = modProdInv.getPrecioCosto();
        double ganancia = modProdInv.getMargenGanancia();
        total = ((ganancia * precioCosto) / 100) + precioCosto;
        modProdInv.setPrecioVenta(total);
    }
}
