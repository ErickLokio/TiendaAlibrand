package modelo;

/**
 *
 * @author Walter
 */
public class Pescador {
    private int idPescador;
    private String nombrePescador;
    private int id_talla_pescador;
    private int idSucursal;
    private double precioVenta;
    private double precioCosto;
    private String descripcion;
    private int catidad;
    private double margenGanancia;
    private String talla;
    private String sucursal;
    
    
    public Pescador(){
        this.idPescador=0;
        this.nombrePescador="";
        this.id_talla_pescador=0;
        this.idSucursal=0;
        this.precioVenta=0;
        this.precioCosto=0;
        this.descripcion="";
        this.catidad=0;
        this.margenGanancia=0;
        this.talla="";
        this.sucursal="";
    }
            
    public double getMargenGanancia() {
        return margenGanancia;
    }

    public void setMargenGanancia(double margenGanancia) {
        this.margenGanancia = margenGanancia;
    }

    public int getIdPescador() {
        return idPescador;
    }

    public void setIdPescador(int idPescador) {
        this.idPescador = idPescador;
    }

    public String getNombrePescador() {
        return nombrePescador;
    }

    public void setNombrePescador(String nombrePescador) {
        this.nombrePescador = nombrePescador;
    }

    public int getId_talla_pescador() {
        return id_talla_pescador;
    }

    public void setId_talla_pescador(int id_talla_pescador) {
        this.id_talla_pescador = id_talla_pescador;
    }

    

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCatidad() {
        return catidad;
    }

    public void setCatidad(int catidad) {
        this.catidad = catidad;
    }    

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
}
