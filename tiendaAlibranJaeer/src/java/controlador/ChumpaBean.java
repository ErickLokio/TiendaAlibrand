package controlador;

import dao.ChumpaDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Chumpa;

/**
 *
 * @author erick osoy
 */
@ManagedBean
@ViewScoped

public class ChumpaBean {
    private Chumpa ingreso = new Chumpa();
    private ArrayList<Chumpa> lstChumpa = new ArrayList<>();

    public Chumpa getIngreso() {
        return ingreso;
    }

    public void setIngreso(Chumpa ingreso) {
        this.ingreso = ingreso;
    }

    public ArrayList<Chumpa> getLstChumpa() {
        return lstChumpa;
    }

    public void setLstChumpa(ArrayList<Chumpa> lstChumpa) {
        this.lstChumpa = lstChumpa;
    }
    
    
    
    public void Limpiar() {
        ingreso.setId_chumpa(0);
        ingreso.setNombre_chumpa("");
        ingreso.setId_talla(0);
        ingreso.setId_sucursal(0);
        ingreso.setPrecio_costo(0);
        ingreso.setPrecio_venta(0);
        ingreso.setMargen_ganancia(0);
        ingreso.setDescripcion("");
        ingreso.setCantidad_total(0);
    }

    public void insertar() {
        ChumpaDao dao;

        try {
            dao = new ChumpaDao();
            dao.Guardar(ingreso);
            this.listar33();
            this.Limpiar();
        } catch (Exception e) {
            System.out.println("ERROR INGRESO Chumpa BEAN  --BEAN" + e);
        }
    }
    

    public void listar33() {
        ChumpaDao sucDao = new ChumpaDao();
        try {
            lstChumpa= sucDao.listaChumpa();

        } catch (Exception e) {
            System.out.println("Error al listar Chumpa bean");
        }
    }

    public void modificar(Chumpa chu) {
        ChumpaDao dao;

        try {
            dao = new ChumpaDao();
            dao.modificar(chu);
            this.listar33();
        } catch (Exception e) {
            System.out.println("ERROR MODIFICAR Chumpa BEAN -- Bean" + e);
        }
    }

    public void Eliminar(Chumpa chu) {
        ChumpaDao dao;

        try {
            dao = new ChumpaDao();
            dao.eliminar(chu);
            this.listar33();
        } catch (Exception e) {
            System.out.println("ERROR ELIMINAR Chumpa BEAN  -- BEAN" + e);
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
