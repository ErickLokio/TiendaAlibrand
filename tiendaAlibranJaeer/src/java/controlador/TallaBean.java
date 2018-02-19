package controlador;

import dao.TallaDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Talla;

/**
 * @author Walter Caal
 */
@ManagedBean
@ViewScoped
public class TallaBean {
    private Talla talMod = new Talla();
    private ArrayList<Talla> lstTalla = new ArrayList<>();

    public Talla getTalMod() {
        return talMod;
    }

    public void setTalMod(Talla talMod) {
        this.talMod = talMod;
    }

    public ArrayList<Talla> getLstTalla() {
        return lstTalla;
    }

    public void setLstTalla(ArrayList<Talla> lstTalla) {
        this.lstTalla = lstTalla;
    }
    
    public void ingresar(){
        TallaDao talDao = new TallaDao();
        try {
            talDao.ingresar(talMod);
            this.limipiar();
        } catch (Exception ex) {
            Logger.getLogger(TallaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(Talla tal){
        TallaDao talDao = new TallaDao();
        try {
            talDao.eliminar(tal);
        } catch (Exception ex) {
            Logger.getLogger(TallaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificar(Talla tal){
        TallaDao talDao = new TallaDao();
        try {
            talDao.modificar(tal);
        } catch (Exception ex) {
            Logger.getLogger(TallaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listar(){
        TallaDao talDao = new TallaDao();
        try {
            lstTalla = talDao.listar();
        } catch (Exception ex) {
            Logger.getLogger(TallaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void limipiar(){
        talMod.setIdTalla(0);
        talMod.setTalla("");
    }
}
