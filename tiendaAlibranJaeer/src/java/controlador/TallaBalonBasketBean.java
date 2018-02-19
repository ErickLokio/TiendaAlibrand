package controlador;

import dao.TallaBasketDao;
import dao.TallaDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Talla;
import modelo.TallaBalonBasket;

/**
 * @author Walter Caal
 */
@ManagedBean
@ViewScoped
public class TallaBalonBasketBean {
    private TallaBalonBasket talMod = new TallaBalonBasket();
    private ArrayList<TallaBalonBasket> lstTalla = new ArrayList<>();

    public TallaBalonBasket getTalMod() {
        return talMod;
    }

    public void setTalMod(TallaBalonBasket talMod) {
        this.talMod = talMod;
    }

    public ArrayList<TallaBalonBasket> getLstTalla() {
        return lstTalla;
    }

    public void setLstTalla(ArrayList<TallaBalonBasket> lstTalla) {
        this.lstTalla = lstTalla;
    }

    public void ingresar(){
        TallaBasketDao talDao = new TallaBasketDao();
        try {
            talDao.ingresar(talMod);
            this.limipiar();
        } catch (Exception ex) {
            Logger.getLogger(TallaBalonBasketBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(TallaBalonBasket tal){
        TallaBasketDao talDao = new TallaBasketDao();
        try {
            talDao.eliminar(tal);
        } catch (Exception ex) {
            Logger.getLogger(TallaBalonBasketBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificar(TallaBalonBasket tal){
        TallaBasketDao talDao = new TallaBasketDao();
        try {
            talDao.modificar(tal);
        } catch (Exception ex) {
            Logger.getLogger(TallaBalonBasketBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listar(){
        TallaBasketDao talDao = new TallaBasketDao();
        try {
            lstTalla = talDao.listar();
        } catch (Exception ex) {
            Logger.getLogger(TallaBalonBasketBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void limipiar(){
        talMod.setIdTallaBalonBasket(0);
        talMod.setTallaBalonBasket("");
    }
}
