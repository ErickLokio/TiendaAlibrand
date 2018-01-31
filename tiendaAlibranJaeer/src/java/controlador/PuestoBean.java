package controlador;

import dao.PuestoDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Puesto;

/**
 * @author Walter
 */
@ManagedBean
@ViewScoped
public class PuestoBean {
    private Puesto modPuesto = new Puesto();
    private ArrayList<Puesto> lstPuesto = new ArrayList();

    public Puesto getModPuesto() {
        return modPuesto;
    }

    public void setModPuesto(Puesto modPuesto) {
        this.modPuesto = modPuesto;
    }

    public ArrayList<Puesto> getLstPuesto() {
        return lstPuesto;
    }

    public void setLstPuesto(ArrayList<Puesto> lstPuesto) {
        this.lstPuesto = lstPuesto;
    }
    
    public void listar(){
        PuestoDao puesDao = new PuestoDao();
        try {
            lstPuesto = puesDao.listar();
        } catch (Exception e) {
            System.out.println("Error al listar en puesto bean");
        }
    }
    
}
