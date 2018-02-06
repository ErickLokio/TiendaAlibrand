package controlador;

import dao.PescadorDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Pescador;

/**
 * @author Walter
 */
@ManagedBean
@ViewScoped
public class PescadorBean {
    private Pescador modPes = new Pescador();
    private ArrayList<Pescador> lstPescador = new ArrayList<>();

    public Pescador getModPes() {
        return modPes;
    }

    public void setModPes(Pescador modPes) {
        this.modPes = modPes;
    }

    public ArrayList<Pescador> getLstPescador() {
        return lstPescador;
    }

    public void setLstPescador(ArrayList<Pescador> lstPescador) {
        this.lstPescador = lstPescador;
    }
    
    public void ingresar(){
        PescadorDao pesDao;
        try {
            pesDao = new PescadorDao();
            pesDao.ingresar(modPes);
        } catch (Exception e) {
            System.out.println("Error al ingresar pescador en el bean "+e);
        }
    }
    
    public void eliminar(Pescador modPes2){
        PescadorDao pesDao;
        try {
            pesDao = new PescadorDao();
            pesDao.eliminar(modPes2);
        } catch (Exception e) {
            System.out.println("Error al eliminar pescador en el bean "+e);
        }
    }
    
    public void modificar(Pescador modPes2){
        PescadorDao pesDao;
        try {
            pesDao = new PescadorDao();
            pesDao.modificar(modPes2);
        } catch (Exception e) {
            System.out.println("Error al ingresar pescador en el bean "+e);
        }
    }
    public void listar(){
        PescadorDao pesDao;
        try {
            pesDao = new PescadorDao();
            lstPescador = pesDao.listar();
        } catch (Exception e) {
            System.out.println("Error al ingresar pescador en el bean "+e);
        }
    }
    
    public void calcularGanancia(){
        double total;
        double precioCosto = modPes.getPrecioCosto();
        double ganancia = modPes.getMargenGanancia();
        total = ((ganancia*precioCosto)/100)+precioCosto;
        modPes.setPrecioVenta(total);
    }
}
