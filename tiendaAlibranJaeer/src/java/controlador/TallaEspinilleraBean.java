package controlador;

import dao.TallaDao;
import dao.TallaEspinilleraDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Talla;
import modelo.TallaEspinillera;

/**
 * @author Walter Caal
 */
@ManagedBean
@ViewScoped
public class TallaEspinilleraBean {
    private TallaEspinillera talMod = new TallaEspinillera();
    private ArrayList<TallaEspinillera> lstTalla = new ArrayList<>();

    public TallaEspinillera getTalMod() {
        return talMod;
    }

    public void setTalMod(TallaEspinillera talMod) {
        this.talMod = talMod;
    }

    public ArrayList<TallaEspinillera> getLstTalla() {
        return lstTalla;
    }

    public void setLstTalla(ArrayList<TallaEspinillera> lstTalla) {
        this.lstTalla = lstTalla;
    }
    
    public void ingresar(){
        TallaEspinilleraDao talDao = new TallaEspinilleraDao();
        try {
            talDao.ingresar(talMod);
            this.limipiar();
        } catch (Exception ex) {
            Logger.getLogger(TallaEspinilleraBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(TallaEspinillera tal){
        TallaEspinilleraDao talDao = new TallaEspinilleraDao();
        try {
            talDao.eliminar(tal);
        } catch (Exception ex) {
            Logger.getLogger(TallaEspinilleraBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificar(TallaEspinillera tal){
        TallaEspinilleraDao talDao = new TallaEspinilleraDao();
        try {
            talDao.modificar(tal);
        } catch (Exception ex) {
            Logger.getLogger(TallaEspinilleraBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listar(){
        TallaEspinilleraDao talDao = new TallaEspinilleraDao();
        try {
            lstTalla = talDao.listar();
        } catch (Exception ex) {
            Logger.getLogger(TallaEspinilleraBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void limipiar(){
        talMod.setIdTallaEspinillera(0);
        talMod.setTallaEspinillera("");
    }
}
