package controlador;

import dao.TallaZapatillaDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.TallaZapatilla;

/**
 * @author Walter Caal
 */
@ManagedBean
@ViewScoped
public class TallaZapatillaBean {
    private TallaZapatilla talMod = new TallaZapatilla();
    private ArrayList<TallaZapatilla> lstTalla = new ArrayList<>();

    public TallaZapatilla getTalMod() {
        return talMod;
    }

    public void setTalMod(TallaZapatilla talMod) {
        this.talMod = talMod;
    }

    public ArrayList<TallaZapatilla> getLstTalla() {
        return lstTalla;
    }

    public void setLstTalla(ArrayList<TallaZapatilla> lstTalla) {
        this.lstTalla = lstTalla;
    }
    
    public void ingresar(){
        TallaZapatillaDao talDao = new TallaZapatillaDao();
        try {
            talDao.ingresar(talMod);
            this.limipiar();
        } catch (Exception ex) {
            Logger.getLogger(TallaZapatillaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(TallaZapatilla tal){
        TallaZapatillaDao talDao = new TallaZapatillaDao();
        try {
            talDao.eliminar(tal);
        } catch (Exception ex) {
            Logger.getLogger(TallaZapatillaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificar(TallaZapatilla tal){
        TallaZapatillaDao talDao = new TallaZapatillaDao();
        try {
            talDao.modificar(tal);
        } catch (Exception ex) {
            Logger.getLogger(TallaZapatillaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listar(){
        TallaZapatillaDao talDao = new TallaZapatillaDao();
        try {
            lstTalla = talDao.listar();
        } catch (Exception ex) {
            Logger.getLogger(TallaZapatillaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void limipiar(){
        talMod.setIdTallaZapatilla(0);
        talMod.setTallaZapatilla("");
    }
}
