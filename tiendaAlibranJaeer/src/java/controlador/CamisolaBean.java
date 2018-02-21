package controlador;

import dao.CamisolaDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Camisola;

/**
 * @author Walter
 */
@ManagedBean
@ViewScoped
public class CamisolaBean {
    private Camisola cam = new Camisola();
    private ArrayList<Camisola> lstCamisola = new ArrayList();

    public Camisola getCam() {
        return cam;
    }

    public void setCam(Camisola cam) {
        this.cam = cam;
    }

    public ArrayList<Camisola> getLstCamisola() {
        return lstCamisola;
    }

    public void setLstCamisola(ArrayList<Camisola> lstCamisola) {
        this.lstCamisola = lstCamisola;
    }
    
    public void ingresar(){
        CamisolaDao camDao = new CamisolaDao();
        try {
            camDao.ingresar(cam);
            this.listar();
            this.limpiar();
        } catch (Exception e) {
            System.out.println("Error al ingresar: "+e);
        }
    }
    
    public void listar(){
        CamisolaDao camDao = new CamisolaDao();
        try {
            lstCamisola = camDao.listar();
                    
        } catch (Exception e) {
            System.out.println("Error al listar camisolaBean: "+e);
        }
    }
    
    public void eliminar(Camisola camModelo){
        CamisolaDao camDao = new CamisolaDao();
        System.out.println("id camisola: "+camModelo.getIdCamisola());
        try {
            camDao.eliminar(camModelo);
        } catch (Exception e) {
            System.out.println("Error al listar camisolaBean: "+e);
        }
    }
    
    public void modificar(Camisola camModelo){
        CamisolaDao camDao = new CamisolaDao();
        try {
            camDao.modificar(camModelo);
        } catch (Exception e) {
            System.out.println("Error al listar camisolaBean: "+e);
        }
    }
 
    public void calcularGanancia(){
        double total;
        double precioCosto = cam.getPrecioCosto();
        double ganancia = cam.getMargenGanancia();
        total = ((ganancia*precioCosto)/100)+precioCosto;
        cam.setPrecioVenta(total);
    }
    
    
    
    public void limpiar(){
        cam.setCantidad(0);
        cam.setDescripcion(null);
        cam.setIdCamisola(0);
        cam.setIdSucursal(0);
        cam.setIdTalla(0);
        cam.setMargenGanancia(0);
        cam.setNombreCamisola(null);
        cam.setPrecioCosto(0);
        cam.setPrecioVenta(0);
    }
}
