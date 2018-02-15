package modelo;

/**
 *
 * @author erick osoy
 */
public class TallaBalon {
    private int id_talla_balon;
    private String nombre_talla_balon;
    
    public TallaBalon(){
        this.id_talla_balon=0;
        this.nombre_talla_balon="";
    }

    public int getId_talla_balon() {
        return id_talla_balon;
    }

    public void setId_talla_balon(int id_talla_balon) {
        this.id_talla_balon = id_talla_balon;
    }

    public String getNombre_talla_balon() {
        return nombre_talla_balon;
    }

    public void setNombre_talla_balon(String nombre_talla_balon) {
        this.nombre_talla_balon = nombre_talla_balon;
    }
    
}
