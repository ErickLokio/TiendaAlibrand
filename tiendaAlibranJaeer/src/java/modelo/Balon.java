package modelo;

/**
 *
 * @author erick osoy
 */
public class Balon {
    private int id_balon;
    private String nombre_balon;
    private int id_talla_balon;
    private int id_sucursal;
    private double precio_costo;
    private double precio_venta;
    private double margen_ganancia;
    private String descripcion;
    private int cantidad;
    
    public Balon(){
        this.id_balon=0;
        this.nombre_balon="";
        this.id_talla_balon=0;
        this.id_sucursal=0;
        this.precio_costo=0;
        this.precio_venta=0;
        this.margen_ganancia=0;
        this.descripcion="";
        this.cantidad=0;
        
    }

    public int getId_balon() {
        return id_balon;
    }

    public void setId_balon(int id_balon) {
        this.id_balon = id_balon;
    }

    public String getNombre_balon() {
        return nombre_balon;
    }

    public void setNombre_balon(String nombre_balon) {
        this.nombre_balon = nombre_balon;
    }

    public int getId_talla_balon() {
        return id_talla_balon;
    }

    public void setId_talla_balon(int id_talla_balon) {
        this.id_talla_balon = id_talla_balon;
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
