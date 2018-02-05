package modelo;

/**
 *
 * @author erick osoy
 */
public class Licra {
    private int id_licra;
    private String nombre_licra;
    private int id_sucursal;
    private double precio_costo;
    private double precio_venta;
    private double margen_ganancia;
    private String descripcion;
    private int cantidad;
    
    public Licra(){
        this.id_licra=0;
        this.nombre_licra="";
        this.id_sucursal=0;
        this.precio_costo=0;
        this.precio_venta=0;
        this.margen_ganancia=0;
        this.descripcion="";
        this.cantidad=0;
    }

    public int getId_licra() {
        return id_licra;
    }

    public void setId_licra(int id_licra) {
        this.id_licra = id_licra;
    }

    public String getNombre_licra() {
        return nombre_licra;
    }

    public void setNombre_licra(String nombre_licra) {
        this.nombre_licra = nombre_licra;
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
