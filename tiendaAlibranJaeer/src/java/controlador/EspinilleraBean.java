package controlador;

import dao.EspinilleraDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Espinillera;

/**
 *
 * @author erick osoy
 */

@ManagedBean
@ViewScoped

public class EspinilleraBean {
    private Espinillera ingreso = new Espinillera();
    private ArrayList<Espinillera> lstEspinillera = new ArrayList<>();

    public Espinillera getIngreso() {
        return ingreso;
    }

    public void setIngreso(Espinillera ingreso) {
        this.ingreso = ingreso;
    }

    public ArrayList<Espinillera> getLstEspinillera() {
        return lstEspinillera;
    }

    public void setLstEspinillera(ArrayList<Espinillera> lstEspinillera) {
        this.lstEspinillera = lstEspinillera;
    }
    
    
    
    
    
    
        public void Limpiar(){
        ingreso.setId_espinillera(0);
        ingreso.setNombre_espnillera("");
        ingreso.setId_talla_espinillera(0);
        ingreso.setId_sucursal(0);
        ingreso.setPrecio_costo(0);
        ingreso.setPrecio_venta(0);
        ingreso.setMargen_ganancia(0);
        ingreso.setDescripcion("");
        ingreso.setCantidad(0);
    }
    
    public void insertar(){
        EspinilleraDao dao;
        
        try{
            dao = new EspinilleraDao();
            dao.Guardar(ingreso);
            this.listar33();
            this.Limpiar();
        }catch(Exception e){
            System.out.println("ERROR INGRESO Espinillera BEAN  --BEAN" +e);
        }
    }
    
    
    
    public void listar33(){
        EspinilleraDao sucDao = new EspinilleraDao();
        try {
           lstEspinillera = sucDao.listaEspinillera();
            
        } catch (Exception e) {
            System.out.println("Error al listar en Espinillera bean");
        }
    }
    
    
    
    public void modificar(Espinillera esp){
        EspinilleraDao dao;
        
        try{
            dao = new EspinilleraDao();
            dao.modificar(esp);
            this.listar33();
        }catch(Exception e){
            System.out.println("ERROR MODIFICAR Espinillera BEAN -- Bean" +e);
        }
    }
    
    
    public void Eliminar(Espinillera esp){
        EspinilleraDao dao;
        
        try{
            dao = new EspinilleraDao();
            dao.eliminar(esp);
            this.listar33();
        }catch(Exception e){
            System.out.println("ERROR ELIMINAR espinillera BEAN  -- BEAN" +e);
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
