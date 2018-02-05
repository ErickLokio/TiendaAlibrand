package controlador;

import dao.MediaDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Media;

/**
 *
 * @author erick osoy
 */
@ManagedBean
@ViewScoped

public class MediaBean {
    private Media ingreso = new Media();
    private ArrayList<Media> lstMedia = new ArrayList<>();

    public Media getIngreso() {
        return ingreso;
    }

    public void setIngreso(Media ingreso) {
        this.ingreso = ingreso;
    }

    public ArrayList<Media> getLstMedia() {
        return lstMedia;
    }

    public void setLstMedia(ArrayList<Media> lstMedia) {
        this.lstMedia = lstMedia;
    }
    
    
        public void Limpiar(){
        ingreso.setId_media(0);
        ingreso.setNombre_media("");
        ingreso.setId_sucursal(0);
        ingreso.setPrecio_costo(0);
        ingreso.setPrecio_venta(0);
        ingreso.setMargen_ganancia(0);
        ingreso.setDescripcion("");
        ingreso.setCantidad(0);
    }
    
   
        public void insertar(){
        MediaDao dao;
        
        try{
            dao = new MediaDao();
            dao.Guardar(ingreso);
            this.listar33();
            this.Limpiar();
        }catch(Exception e){
            System.out.println("ERROR INGRESO Media BEAN  --BEAN" +e);
        }
    }
    
    
    
    public void listar33(){
        MediaDao sucDao = new MediaDao();
        try {
           lstMedia = sucDao.listaMedia();
            
        } catch (Exception e) {
            System.out.println("Error al listar en Media bean");
        }
    }
    
    
    
    public void modificar(Media me){
        MediaDao dao;
        
        try{
            dao = new MediaDao();
            dao.modificar(me);
            this.listar33();
        }catch(Exception e){
            System.out.println("ERROR MODIFICAR MEDIA BEAN -- Bean" +e);
        }
    }
    
    
    public void Eliminar(Media me){
       MediaDao dao;
        
        try{
            dao = new MediaDao();
            dao.eliminar(me);
            this.listar33();
        }catch(Exception e){
            System.out.println("ERROR ELIMINAR Media BEAN  -- BEAN" +e);
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
