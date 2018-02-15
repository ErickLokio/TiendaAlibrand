package controlador;

import dao.TallaZapatillaDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Talla_Zapatilla;

/**
 *
 * @author erick osoy
 */
@ManagedBean
@ViewScoped
public class TallaZapatillaBean {

    private Talla_Zapatilla ingreso = new Talla_Zapatilla();
    private ArrayList<Talla_Zapatilla> lstTalla_Zapatilla = new ArrayList<>();

    public Talla_Zapatilla getIngreso() {
        return ingreso;
    }

    public void setIngreso(Talla_Zapatilla ingreso) {
        this.ingreso = ingreso;
    }

    public ArrayList<Talla_Zapatilla> getLstTalla_Zapatilla() {
        return lstTalla_Zapatilla;
    }

    public void setLstTalla_Zapatilla(ArrayList<Talla_Zapatilla> lstTalla_Zapatilla) {
        this.lstTalla_Zapatilla = lstTalla_Zapatilla;
    }

    public void Limpiar() {
        ingreso.setId_talla_zapatilla(0);
        ingreso.setNombre_zapatilla("");
    }

    public void insertar() {
        TallaZapatillaDao dao;

        try {
            dao = new TallaZapatillaDao();
            dao.Guardar(ingreso);
            this.listarTalla_Zapatilla();
            this.Limpiar();

        } catch (Exception e) {
            System.out.println("ERROR INGRESO TallaZapatilla BEAN  --BEAN" + e);
        }
    }

    public void listarTalla_Zapatilla() {
        TallaZapatillaDao sucDao = new TallaZapatillaDao();
        try {
            lstTalla_Zapatilla = sucDao.listaTalla_Zapatilla();

        } catch (Exception e) {
            System.out.println("Error al listar TallaZapatilla bean");
        }
    }

    public void modificar(Talla_Zapatilla za) {
        TallaZapatillaDao dao;

        try {
            dao = new TallaZapatillaDao();
            dao.modificar(za);
            this.listarTalla_Zapatilla();
        } catch (Exception e) {
            System.out.println("ERROR MODIFICAR TallaZapatilla BEAN -- Bean" + e);
        }
    }

    public void Eliminar(Talla_Zapatilla za) {
        TallaZapatillaDao dao;

        try {
            dao = new TallaZapatillaDao();
            dao.eliminar(za);
            this.listarTalla_Zapatilla();
        } catch (Exception e) {
            System.out.println("ERROR ELIMINAR TallaZapatilla BEAN  -- BEAN" + e);
        }
    }

}
