package modelo;

/**
 *
 * @author erick osoy
 */

public class TallaPantaloneta {
    private int id_talla_pantaloneta;
    private String nombre_talla_pantaloneta;
    
    public TallaPantaloneta(){
        this.id_talla_pantaloneta=0;
        this.nombre_talla_pantaloneta="";
    }

    public int getId_talla_pantaloneta() {
        return id_talla_pantaloneta;
    }

    public void setId_talla_pantaloneta(int id_talla_pantaloneta) {
        this.id_talla_pantaloneta = id_talla_pantaloneta;
    }

    public String getNombre_talla_pantaloneta() {
        return nombre_talla_pantaloneta;
    }

    public void setNombre_talla_pantaloneta(String nombre_talla_pantaloneta) {
        this.nombre_talla_pantaloneta = nombre_talla_pantaloneta;
    }
    
}
