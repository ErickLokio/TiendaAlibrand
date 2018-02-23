package controlador;

import dao.LicraDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Licra;

/**
 *
 * @author erick osoy
 */
@ManagedBean
@ViewScoped

public class LicraBean {
    private Licra ingreso = new Licra();
    private ArrayList<Licra> lstLicra = new ArrayList<>();

    public Licra getIngreso() {
        return ingreso;
    }

    public void setIngreso(Licra ingreso) {
        this.ingreso = ingreso;
    }

    public ArrayList<Licra> getLstLicra() {
        return lstLicra;
    }

    public void setLstLicra(ArrayList<Licra> lstLicra) {
        this.lstLicra = lstLicra;
    }
    
    
    
    public void Limpiar(){
        ingreso.setId_licra(0);
        ingreso.setNombre_licra("");
        ingreso.setId_sucursal(0);
        ingreso.setPrecio_costo(0);
        ingreso.setPrecio_venta(0);
        ingreso.setMargen_ganancia(0);
        ingreso.setDescripcion("");
        ingreso.setCantidad(0);
    }
    
   
        public void insertar(){
        LicraDao dao;
        
        try{
            dao = new LicraDao();
            dao.Guardar(ingreso);
            this.Limpiar();
            this.listar33();
            
        }catch(Exception e){
            System.out.println("ERROR INGRESO Licra BEAN  --BEAN" +e);
        }
    }
    
    
    
    public void listar33(){
        LicraDao sucDao = new LicraDao();
        try {
           lstLicra = sucDao.listarLicra();
            
        } catch (Exception e) {
            System.out.println("Error al listar en Licra bean");
        }
    }
    
    
    
    public void modificar(Licra li){
        LicraDao dao;
        
        try{
            dao = new LicraDao();
            dao.modificar(li);
            this.listar33();
        }catch(Exception e){
            System.out.println("ERROR MODIFICAR Licra BEAN -- Bean" +e);
        }
    }
    
    
    public void Eliminar(Licra li){
        LicraDao dao;
        
        try{
            dao = new LicraDao();
            dao.eliminar(li);
            this.listar33();
        }catch(Exception e){
            System.out.println("ERROR ELIMINAR LicraDao BEAN  -- BEAN" +e);
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
