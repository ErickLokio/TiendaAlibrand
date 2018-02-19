package controlador;

import dao.TallaBalonDao;
import dao.TallaPantalonetaDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.TallaBalon;

/**
 *
 * @author erick osoy
 */

@ManagedBean
@ViewScoped

public class TallaBalonBean {
  
    private TallaBalon ingreso = new TallaBalon();
    private ArrayList<TallaBalon> lstTallaBalon = new ArrayList<>();

    public TallaBalon getIngreso() {
        return ingreso;
    }

    public void setIngreso(TallaBalon ingreso) {
        this.ingreso = ingreso;
    }

    public ArrayList<TallaBalon> getLstTallaBalon() {
        return lstTallaBalon;
    }

    public void setLstTallaBalon(ArrayList<TallaBalon> lstTallaBalon) {
        this.lstTallaBalon = lstTallaBalon;
    }
    
    
    public void Limpiar(){
        ingreso.setIdTallaBalon(0);
        ingreso.setTallaBalon("");
    }
    
    
        public void insertar() {
        TallaBalonDao dao;

        try {
            dao = new TallaBalonDao();
            dao.ingresar(ingreso);
            this.Limpiar();
            this.listarTallaBalon();
        } catch (Exception e) {
            System.out.println("ERROR INGRESO TallaBalon BEAN  --BEAN" + e);
        }
    }

    public void listarTallaBalon() {
        TallaBalonDao sucDao = new TallaBalonDao();
        try {
            lstTallaBalon = sucDao.listar();

        } catch (Exception e) {
            System.out.println("Error al listar TallaBalon bean");
        }
    }

    public void modificar(TallaBalon za) {
        TallaBalonDao dao;

        try {
            dao = new TallaBalonDao();
            dao.modificar(za);
            this.listarTallaBalon();
        } catch (Exception e) {
            System.out.println("ERROR MODIFICAR TallaBalon BEAN -- Bean" + e);
        }
    }

    public void Eliminar(TallaBalon za) {
        TallaBalonDao dao;

        try {
            dao = new TallaBalonDao();
            dao.eliminar(za);
            this.listarTallaBalon();
        } catch (Exception e) {
            System.out.println("ERROR ELIMINAR TallaBalon BEAN  -- BEAN" + e);
        }
    }
    
}
