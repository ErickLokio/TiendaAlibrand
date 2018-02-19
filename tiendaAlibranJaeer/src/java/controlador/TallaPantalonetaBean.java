package controlador;

import dao.TallaDao;
import dao.TallaPantalonetaDao;
import dao.TallaPescadorDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Talla;
import modelo.TallaPantaloneta;

/**
 * @author Walter Caal
 */
@ManagedBean
@ViewScoped
public class TallaPantalonetaBean {
    private TallaPantaloneta talPaMod = new TallaPantaloneta();
    private ArrayList<TallaPantaloneta> lstPanTalla = new ArrayList<>();

    public TallaPantaloneta getTalPaMod() {
        return talPaMod;
    }

    public void setTalPaMod(TallaPantaloneta talPaMod) {
        this.talPaMod = talPaMod;
    }

    public ArrayList<TallaPantaloneta> getLstPanTalla() {
        return lstPanTalla;
    }

    public void setLstPanTalla(ArrayList<TallaPantaloneta> lstPanTalla) {
        this.lstPanTalla = lstPanTalla;
    }
    
    public void ingresar(){
        TallaPantalonetaDao talDao = new TallaPantalonetaDao();
        try {
            talDao.ingresar(talPaMod);
            this.limipiar();
        } catch (Exception ex) {
            Logger.getLogger(TallaPantalonetaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(TallaPantaloneta tal){
        TallaPantalonetaDao talDao = new TallaPantalonetaDao();
        try {
            talDao.eliminar(tal);
        } catch (Exception ex) {
            Logger.getLogger(TallaPantalonetaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificar(TallaPantaloneta tal){
        TallaPantalonetaDao talDao = new TallaPantalonetaDao();
        try {
            talDao.modificar(tal);
        } catch (Exception ex) {
            Logger.getLogger(TallaPantalonetaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listar(){
        TallaPantalonetaDao talDao = new TallaPantalonetaDao();
        try {
            lstPanTalla = talDao.listar();
        } catch (Exception ex) {
            Logger.getLogger(TallaPantalonetaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void limipiar(){
        talPaMod.setIdTallaPantaloneta(0);
        talPaMod.setTallaPantaloneta("");
    }
}
