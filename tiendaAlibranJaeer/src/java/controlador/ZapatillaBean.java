package controlador;

import dao.ZapatillaDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Talla_Zapatilla;
import modelo.TipoZapatilla;
import modelo.Zapatilla;

/**
 *
 * @author erick osoy
 */
@ManagedBean
@ViewScoped

public class ZapatillaBean {
    
    private Zapatilla ingreso = new Zapatilla();
    private ArrayList<Zapatilla> lstZapatilla = new ArrayList<>();
    private ArrayList<Talla_Zapatilla> lstTalla_Zapatilla = new ArrayList<>();
    private ArrayList<TipoZapatilla> lstTipoZapatilla = new ArrayList<>();

    public Zapatilla getIngreso() {
        return ingreso;
    }

    public void setIngreso(Zapatilla ingreso) {
        this.ingreso = ingreso;
    }

    public ArrayList<Zapatilla> getLstZapatilla() {
        return lstZapatilla;
    }

    public void setLstZapatilla(ArrayList<Zapatilla> lstZapatilla) {
        this.lstZapatilla = lstZapatilla;
    }

    public ArrayList<Talla_Zapatilla> getLstTalla_Zapatilla() {
        return lstTalla_Zapatilla;
    }

    public void setLstTalla_Zapatilla(ArrayList<Talla_Zapatilla> lstTalla_Zapatilla) {
        this.lstTalla_Zapatilla = lstTalla_Zapatilla;
    }

    public ArrayList<TipoZapatilla> getLstTipoZapatilla() {
        return lstTipoZapatilla;
    }

    public void setLstTipoZapatilla(ArrayList<TipoZapatilla> lstTipoZapatilla) {
        this.lstTipoZapatilla = lstTipoZapatilla;
    }
    
    
    
    public void Limpiar(){
        ingreso.setId_producto(0);
        ingreso.setNombre_producto("");
        ingreso.setId_talla_zapatilla(0);
        ingreso.setId_tipo_zapatilla(0);
        ingreso.setId_sucursal(0);
        ingreso.setPrecio_costo(0);
        ingreso.setPrecio_venta(0);
        ingreso.setMargen_ganancia(0);
        ingreso.setDescripcion("");
        ingreso.setCantidad(0);
    }
    
     public void insertar() {
        ZapatillaDao dao;

        try {
            dao = new ZapatillaDao();
            dao.Guardar(ingreso);
            this.Limpiar();
            this.listar33();
        } catch (Exception e) {
            System.out.println("ERROR INGRESO Zapatilla BEAN  --BEAN" + e);
        }
    }
     
     public void listar33() {
        ZapatillaDao sucDao = new ZapatillaDao();
        try {
            lstZapatilla = sucDao.listaZapatilla();

        } catch (Exception e) {
            System.out.println("Error al listar Zapatilla bean");
        }
    }

    public void modificar(Zapatilla za) {
        ZapatillaDao dao;

        try {
            dao = new ZapatillaDao();
            dao.modificar(za);
            this.listar33();
        } catch (Exception e) {
            System.out.println("ERROR MODIFICAR Zapatilla BEAN -- Bean" + e);
        }
    }

    public void Eliminar(Zapatilla za) {
        ZapatillaDao dao;

        try {
            dao = new ZapatillaDao();
            dao.eliminar(za);
            this.listar33();
        } catch (Exception e) {
            System.out.println("ERROR ELIMINAR Zapatilla BEAN  -- BEAN" + e);
        }
    }
    
    public void calcularGanancia(){
        double total;
        double precioCosto = ingreso.getPrecio_costo();
        double ganancia = ingreso.getMargen_ganancia();
        total = ((ganancia*precioCosto)/100)+precioCosto;
        ingreso.setPrecio_venta(total);
    }
    
    
    
    /*
        METODOS DE LISTAR
    */
    
    public void listarTalla_Zapatilla() {
        ZapatillaDao sucDao = new ZapatillaDao();
        try {
            lstTalla_Zapatilla = sucDao.listaTalla_Zapatilla();

        } catch (Exception e) {
            System.out.println("Error al listar Talla_Zapatilla bean");
        }
    }
    
    public void listarTipoZapatilla() {
        ZapatillaDao sucDao = new ZapatillaDao();
        try {
            lstTipoZapatilla = sucDao.listaTipoZapatilla();

        } catch (Exception e) {
            System.out.println("Error al listar TipoZapatilla bean");
        }
    }
}
