package controlador;

import dao.TallaCamisolaDao;
import dao.TallaDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Talla;
import modelo.TallaCamisola;

/**
 * @author Walter Caal
 */
@ManagedBean
@ViewScoped
public class TallaCamisolaBean {
    private TallaCamisola talMod = new TallaCamisola();
    private ArrayList<TallaCamisola> lstTalla = new ArrayList<>();

    public TallaCamisola getTalMod() {
        return talMod;
    }

    public void setTalMod(TallaCamisola talMod) {
        this.talMod = talMod;
    }

    public ArrayList<TallaCamisola> getLstTalla() {
        return lstTalla;
    }

    public void setLstTalla(ArrayList<TallaCamisola> lstTalla) {
        this.lstTalla = lstTalla;
    }

    public void ingresar(){
        TallaCamisolaDao talDao = new TallaCamisolaDao();
        try {
            talDao.ingresar(talMod);
            this.limipiar();
        } catch (Exception ex) {
            Logger.getLogger(TallaCamisolaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(TallaCamisola tal){
        TallaCamisolaDao talDao = new TallaCamisolaDao();
        try {
            talDao.eliminar(tal);
        } catch (Exception ex) {
            Logger.getLogger(TallaCamisolaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificar(TallaCamisola tal){
        TallaCamisolaDao talDao = new TallaCamisolaDao();
        try {
            talDao.modificar(tal);
        } catch (Exception ex) {
            Logger.getLogger(TallaCamisolaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listar(){
        TallaCamisolaDao talDao = new TallaCamisolaDao();
        try {
            lstTalla = talDao.listar();
        } catch (Exception ex) {
            Logger.getLogger(TallaCamisolaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void limipiar(){
        talMod.setIdTallaCamisola(0);
        talMod.setTallaCamisola("");
    }
}
