package modelo;

/**
 *
 * @author erick osoy
 */
public class Media {
    private int id_media;
    private String nombre_media;
    private int id_sucursal;
    private double precio_costo;
    private double precio_venta;
    private double margen_ganancia;
    private String descripcion;
    private int cantidad;
    
    public Media(){
        this.id_media=0;
        this.nombre_media="";
        this.id_sucursal=0;
        this.precio_costo=0;
        this.precio_venta=0;
        this.margen_ganancia=0;
        this.descripcion="";
        this.cantidad=0;
    }

    public int getId_media() {
        return id_media;
    }

    public void setId_media(int id_media) {
        this.id_media = id_media;
    }

    public String getNombre_media() {
        return nombre_media;
    }

    public void setNombre_media(String nombre_media) {
        this.nombre_media = nombre_media;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public double getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(double precio_costo) {
        this.precio_costo = precio_costo;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public double getMargen_ganancia() {
        return margen_ganancia;
    }

    public void setMargen_ganancia(double margen_ganancia) {
        this.margen_ganancia = margen_ganancia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
     
}
