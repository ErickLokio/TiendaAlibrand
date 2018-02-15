package modelo;

/**
 *
 * @author erick osoy
 */
public class Talla_Zapatilla {

    private int id_talla_zapatilla;
    private String nombre_zapatilla;

    public Talla_Zapatilla() {
        this.id_talla_zapatilla=0;
        this.nombre_zapatilla="";
    }

    public int getId_talla_zapatilla() {
        return id_talla_zapatilla;
    }

    public void setId_talla_zapatilla(int id_talla_zapatilla) {
        this.id_talla_zapatilla = id_talla_zapatilla;
    }

    public String getNombre_zapatilla() {
        return nombre_zapatilla;
    }

    public void setNombre_zapatilla(String nombre_zapatilla) {
        this.nombre_zapatilla = nombre_zapatilla;
    }
    
    
}
