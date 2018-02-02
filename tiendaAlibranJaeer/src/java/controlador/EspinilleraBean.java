package controlador;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Espinillera;

/**
 *
 * @author erick osoy
 */

@ManagedBean
@ViewScoped

public class EspinilleraBean {
    private Espinillera ingreso = new Espinillera();
    private ArrayList<Espinillera> lstEspinillera = new ArrayList<>();

    public Espinillera getIngreso() {
        return ingreso;
    }

    public void setIngreso(Espinillera ingreso) {
        this.ingreso = ingreso;
    }

    public ArrayList<Espinillera> getLstEspinillera() {
        return lstEspinillera;
    }

    public void setLstEspinillera(ArrayList<Espinillera> lstEspinillera) {
        this.lstEspinillera = lstEspinillera;
    }
    
    
    
    
    
    
}
