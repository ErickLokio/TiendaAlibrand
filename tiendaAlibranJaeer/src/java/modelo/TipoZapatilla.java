package modelo;

/**
 *
 * @author erick osoy
 */
public class TipoZapatilla {
    private int id_tipo_zapatilla;
    private String nombre_tipo_zapatilla;
    
    public TipoZapatilla(){
        this.id_tipo_zapatilla=0;
        this.nombre_tipo_zapatilla="";
    }

    public int getId_tipo_zapatilla() {
        return id_tipo_zapatilla;
    }

    public void setId_tipo_zapatilla(int id_tipo_zapatilla) {
        this.id_tipo_zapatilla = id_tipo_zapatilla;
    }

    public String getNombre_tipo_zapatilla() {
        return nombre_tipo_zapatilla;
    }

    public void setNombre_tipo_zapatilla(String nombre_tipo_zapatilla) {
        this.nombre_tipo_zapatilla = nombre_tipo_zapatilla;
    }
    
    
}
