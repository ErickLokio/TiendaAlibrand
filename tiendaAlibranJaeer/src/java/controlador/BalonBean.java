package controlador;

import dao.BalonDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Balon;

/**
 *
 * @author erick osoy
 */

@ManagedBean
@ViewScoped

public class BalonBean {

    private Balon ingreso = new Balon();
    private ArrayList<Balon> lstBalon = new ArrayList<>();

    public Balon getIngreso() {
        return ingreso;
    }

    public void setIngreso(Balon ingreso) {
        this.ingreso = ingreso;
    }

    public ArrayList<Balon> getLstBalon() {
        return lstBalon;
    }

    public void setLstBalon(ArrayList<Balon> lstBalon) {
        this.lstBalon = lstBalon;
    }

    public void Limpiar() {
        ingreso.setId_producto(0);
        ingreso.setNombre_producto("");
        ingreso.setId_talla_balon(0);
        ingreso.setId_sucursal(0);
        ingreso.setPrecio_costo(0);
        ingreso.setPrecio_venta(0);
        ingreso.setMargen_ganancia(0);
        ingreso.setDescripcion("");
        ingreso.setCantidad(0);
    }

    public void insertar() {
        BalonDao dao;

        try {
            dao = new BalonDao();
            dao.Guardar(ingreso);
            this.listar33();
            this.Limpiar();
        } catch (Exception e) {
            System.out.println("ERROR INGRESO Balon BEAN  --BEAN" + e);
        }
    }
    

    public void listar33() {
        BalonDao sucDao = new BalonDao();
        try {
            lstBalon = sucDao.listarBalon();

        } catch (Exception e) {
            System.out.println("Error al listar Balon bean");
        }
    }

    public void modificar(Balon ba) {
        BalonDao dao;

        try {
            dao = new BalonDao();
            dao.modificar(ba);
            this.listar33();
        } catch (Exception e) {
            System.out.println("ERROR MODIFICAR Balon BEAN -- Bean" + e);
        }
    }

    public void Eliminar(Balon ba) {
        BalonDao dao;

        try {
            dao = new BalonDao();
            dao.eliminar(ba);
            this.listar33();
        } catch (Exception e) {
            System.out.println("ERROR ELIMINAR Balon BEAN  -- BEAN" + e);
        }
    }
    
    public void calcularGanancia(){
        double total;
        double precioCosto = ingreso.getPrecio_costo();
        double ganancia = ingreso.getMargen_ganancia();
        total = ((ganancia*precioCosto)/100)+precioCosto;
        ingreso.setPrecio_venta(total);
    }
    

}
