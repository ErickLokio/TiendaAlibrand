package controlador;

import dao.TallaChumpaDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.TallaChumpa;

/**
 * @author Walter Caal
 */
@ManagedBean
@ViewScoped
public class TallaChumpaBean {
    private TallaChumpa talMod = new TallaChumpa();
    private ArrayList<TallaChumpa> lstTalla = new ArrayList<>();

    public TallaChumpa getTalMod() {
        return talMod;
    }

    public void setTalMod(TallaChumpa talMod) {
        this.talMod = talMod;
    }

    public ArrayList<TallaChumpa> getLstTalla() {
        return lstTalla;
    }

    public void setLstTalla(ArrayList<TallaChumpa> lstTalla) {
        this.lstTalla = lstTalla;
    }

    public void ingresar(){
        TallaChumpaDao talDao = new TallaChumpaDao();
        try {
            talDao.ingresar(talMod);
            this.limipiar();
        } catch (Exception ex) {
            Logger.getLogger(TallaChumpaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(TallaChumpa tal){
        TallaChumpaDao talDao = new TallaChumpaDao();
        try {
            talDao.eliminar(tal);
        } catch (Exception ex) {
            Logger.getLogger(TallaChumpaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificar(TallaChumpa tal){
        TallaChumpaDao talDao = new TallaChumpaDao();
        try {
            talDao.modificar(tal);
        } catch (Exception ex) {
            Logger.getLogger(TallaChumpaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listar(){
        TallaChumpaDao talDao = new TallaChumpaDao();
        try {
            lstTalla = talDao.listar();
        } catch (Exception ex) {
            Logger.getLogger(TallaChumpaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void limipiar(){
        talMod.setIdTallaChumpa(0);
        talMod.setTallaChumpa("");
    }
}
