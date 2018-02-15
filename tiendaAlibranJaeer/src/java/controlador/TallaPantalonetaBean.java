package controlador;

import dao.TallaPantalonetaDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.TallaPantaloneta;

/**
 *
 * @author erick osoy
 */
@ManagedBean
@ViewScoped

public class TallaPantalonetaBean {
    
    private TallaPantaloneta ingreso = new TallaPantaloneta();
    private ArrayList<TallaPantaloneta> lstTallaPantaloneta = new ArrayList<>();

    public TallaPantaloneta getIngreso() {
        return ingreso;
    }

    public void setIngreso(TallaPantaloneta ingreso) {
        this.ingreso = ingreso;
    }

    public ArrayList<TallaPantaloneta> getLstTallaPantaloneta() {
        return lstTallaPantaloneta;
    }

    public void setLstTallaPantaloneta(ArrayList<TallaPantaloneta> lstTallaPantaloneta) {
        this.lstTallaPantaloneta = lstTallaPantaloneta;
    }
    
    public void Limpiar(){
        ingreso.setId_talla_pantaloneta(0);
        ingreso.setNombre_talla_pantaloneta("");
    }
    
    
    public void insertar() {
        TallaPantalonetaDao dao;

        try {
            dao = new TallaPantalonetaDao();
            dao.Guardar(ingreso);
            this.Limpiar();
            this.listarTallaPantaloneta();
        } catch (Exception e) {
            System.out.println("ERROR INGRESO TallaPantaloneta BEAN  --BEAN" + e);
        }
    }

    public void listarTallaPantaloneta() {
        TallaPantalonetaDao sucDao = new TallaPantalonetaDao();
        try {
            lstTallaPantaloneta = sucDao.listaTallaPantaloneta();

        } catch (Exception e) {
            System.out.println("Error al listar TallaPantaloneta bean");
        }
    }

    public void modificar(TallaPantaloneta za) {
        TallaPantalonetaDao dao;

        try {
            dao = new TallaPantalonetaDao();
            dao.modificar(za);
            this.listarTallaPantaloneta();
        } catch (Exception e) {
            System.out.println("ERROR MODIFICAR TallaPantaloneta BEAN -- Bean" + e);
        }
    }

    public void Eliminar(TallaPantaloneta za) {
        TallaPantalonetaDao dao;

        try {
            dao = new TallaPantalonetaDao();
            dao.eliminar(za);
            this.listarTallaPantaloneta();
        } catch (Exception e) {
            System.out.println("ERROR ELIMINAR TallaPantaloneta BEAN  -- BEAN" + e);
        }
    }
    
}
