package controlador;

import dao.TallaDao;
import dao.TallaPescadorDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Talla;
import modelo.TallaPantaloneta;
import modelo.TallaPescador;

/**
 * @author Walter Caal
 */
@ManagedBean
@ViewScoped
public class TallaPescadorBean {
    private TallaPescador talPesMod = new TallaPescador();
    private ArrayList<TallaPescador> lstTallaPes = new ArrayList<>();

    public TallaPescador getTalPesMod() {
        return talPesMod;
    }

    public void setTalPesMod(TallaPescador talPesMod) {
        this.talPesMod = talPesMod;
    }

    public ArrayList<TallaPescador> getLstTallaPes() {
        return lstTallaPes;
    }

    public void setLstTallaPes(ArrayList<TallaPescador> lstTallaPes) {
        this.lstTallaPes = lstTallaPes;
    }
    
    
    public void ingresar(){
        TallaPescadorDao talDao = new TallaPescadorDao();
        try {
            talDao.ingresar(talPesMod);
            this.limipiar();
        } catch (Exception ex) {
            Logger.getLogger(TallaPescadorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(TallaPescador tal){
        TallaPescadorDao talDao = new TallaPescadorDao();
        try {
            talDao.eliminar(tal);
        } catch (Exception ex) {
            Logger.getLogger(TallaPescadorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificar(TallaPescador tal){
        TallaPescadorDao talDao = new TallaPescadorDao();
        try {
            talDao.modificar(tal);
        } catch (Exception ex) {
            Logger.getLogger(TallaPescadorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listar(){
        TallaPescadorDao talDao = new TallaPescadorDao();
        try {
            lstTallaPes = talDao.listar();
        } catch (Exception ex) {
            Logger.getLogger(TallaPescadorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void limipiar(){
        talPesMod.setIdTallaPescador(0);
        talPesMod.setTallaPescador("");
    }
}
