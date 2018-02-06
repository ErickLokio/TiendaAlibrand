package controlador;

import dao.PantalonetaDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Pantaloneta;

/**
 * @author Walter
 */
@ManagedBean
@ViewScoped
public class PantalonetaBean {
    private Pantaloneta pan = new Pantaloneta();
    private ArrayList<Pantaloneta> lstPantaloneta = new ArrayList<>();

    public Pantaloneta getPan() {
        return pan;
    }

    public void setPan(Pantaloneta pan) {
        this.pan = pan;
    }

    public ArrayList<Pantaloneta> getLstPantaloneta() {
        return lstPantaloneta;
    }

    public void setLstPantaloneta(ArrayList<Pantaloneta> lstPantaloneta) {
        this.lstPantaloneta = lstPantaloneta;
    }
    
    public void ingresar(){
        PantalonetaDao panDao;
        try {
            pan.getIdSucursal();
            panDao = new PantalonetaDao();
            panDao.ingresar(pan);
        } catch (Exception e) {
            System.out.println("Error al ingresar en el pantaloneta bean "+e);
        }
    }
    
    public void eliminar(Pantaloneta pan2){
        PantalonetaDao panDao;
        try {
            panDao = new PantalonetaDao();
            panDao.eliminar(pan2);
        } catch (Exception e) {
            System.out.println("Error al eliminar en el pantaloneta bean "+e);
        }
    }
    
    public void modificar(Pantaloneta pan2){
        PantalonetaDao panDao;
        try {
            panDao = new PantalonetaDao();
            panDao.modificar(pan2);
        } catch (Exception e) {
            System.out.println("Error al modificar en el pantaloneta bean "+e);
        }
    }
    
    public void listar(){
        PantalonetaDao panDao;
        try {
            panDao = new PantalonetaDao();
            lstPantaloneta=panDao.listar();
        } catch (Exception e) {
            System.out.println("Error al listar en el pantaloneta bean "+e);
        }
    }
    
    public void calcularGanancia(){
        double total;
        double precioCosto = pan.getPrecioCosto();
        double ganancia = pan.getMargenGanancia();
        total = ((ganancia*precioCosto)/100)+precioCosto;
        pan.setPrecioVenta(total);
    }
}
