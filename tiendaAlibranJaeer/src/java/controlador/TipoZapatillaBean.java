package controlador;

import dao.TipoZapatillaDao;
import dao.ZapatillaDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.TipoZapatilla;

/**
 *
 * @author erick osoy
 */
@ManagedBean
@ViewScoped
public class TipoZapatillaBean {

    private TipoZapatilla ingreso = new TipoZapatilla();
    private ArrayList<TipoZapatilla> lstTipoZapatilla = new ArrayList<>();

    public TipoZapatilla getIngreso() {
        return ingreso;
    }

    public void setIngreso(TipoZapatilla ingreso) {
        this.ingreso = ingreso;
    }

    public ArrayList<TipoZapatilla> getLstTipoZapatilla() {
        return lstTipoZapatilla;
    }

    public void setLstTipoZapatilla(ArrayList<TipoZapatilla> lstTipoZapatilla) {
        this.lstTipoZapatilla = lstTipoZapatilla;
    }

    public void Limpiar() {
        ingreso.setId_tipo_zapatilla(0);
        ingreso.setNombre_tipo_zapatilla("");
    }

    public void insertar() {
        TipoZapatillaDao dao;

        try {
            dao = new TipoZapatillaDao();
            dao.Guardar(ingreso);
            this.Limpiar();
            this.listarTipoZapatilla();
        } catch (Exception e) {
            System.out.println("ERROR INGRESO TipoZapatilla BEAN  --BEAN" + e);
        }
    }

    public void listarTipoZapatilla() {
        TipoZapatillaDao sucDao = new TipoZapatillaDao();
        try {
            lstTipoZapatilla = sucDao.listaTipoZapatilla();

        } catch (Exception e) {
            System.out.println("Error al listar TipoZapatilla bean");
        }
    }

    public void modificar(TipoZapatilla za) {
        TipoZapatillaDao dao;

        try {
            dao = new TipoZapatillaDao();
            dao.modificar(za);
            this.listarTipoZapatilla();
        } catch (Exception e) {
            System.out.println("ERROR MODIFICAR TipoZapatilla BEAN -- Bean" + e);
        }
    }

    public void Eliminar(TipoZapatilla za) {
        TipoZapatillaDao dao;

        try {
            dao = new TipoZapatillaDao();
            dao.eliminar(za);
            this.listarTipoZapatilla();
        } catch (Exception e) {
            System.out.println("ERROR ELIMINAR TipoZapatilla BEAN  -- BEAN" + e);
        }
    }

}
