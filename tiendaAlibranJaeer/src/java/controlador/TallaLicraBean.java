package controlador;

import dao.TallaDao;
import dao.TallaLicraDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Talla;
import modelo.TallaLicra;

/**
 * @author Walter Caal
 */
@ManagedBean
@ViewScoped
public class TallaLicraBean {
    private TallaLicra talLiMod = new TallaLicra();
    private ArrayList<TallaLicra> lstLiTalla = new ArrayList<>();

    public TallaLicra getTalLiMod() {
        return talLiMod;
    }

    public void setTalLiMod(TallaLicra talLiMod) {
        this.talLiMod = talLiMod;
    }

    public ArrayList<TallaLicra> getLstLiTalla() {
        return lstLiTalla;
    }

    public void setLstLiTalla(ArrayList<TallaLicra> lstLiTalla) {
        this.lstLiTalla = lstLiTalla;
    }
    
    public void ingresar(){
        TallaLicraDao talDao = new TallaLicraDao();
        try {
            talDao.ingresar(talLiMod);
            this.limipiar();
        } catch (Exception ex) {
            Logger.getLogger(TallaLicraBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(TallaLicra tal){
        TallaLicraDao talDao = new TallaLicraDao();
        try {
            talDao.eliminar(tal);
        } catch (Exception ex) {
            Logger.getLogger(TallaLicraBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificar(TallaLicra tal){
        TallaLicraDao talDao = new TallaLicraDao();
        try {
            talDao.modificar(tal);
        } catch (Exception ex) {
            Logger.getLogger(TallaLicraBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listar(){
        TallaLicraDao talDao = new TallaLicraDao();
        try {
            lstLiTalla = talDao.listar();
        } catch (Exception ex) {
            Logger.getLogger(TallaLicraBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void limipiar(){
        talLiMod.setIdTallaLicra(0);
        talLiMod.setTallaLicra("");
    }
}
