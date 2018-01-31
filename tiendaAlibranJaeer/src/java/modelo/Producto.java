package modelo;

/**
 *
 * @author erick osoy
 */
public class Producto {
    private int id_producto;
    private int id_sucursal;
    private double precio_costo;
    private double precio_venta;
    private int margen_ganancia;
    private String descripcion;
    private int cantidad_total;
    
    public Producto(){
        this.id_producto=0;
        this.id_sucursal=0;
        this.precio_costo=0;
        this.precio_venta=0;
        this.margen_ganancia=0;
        this.descripcion="";
        this.cantidad_total=0;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
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

    public int getMargen_ganancia() {
        return margen_ganancia;
    }

    public void setMargen_ganancia(int margen_ganancia) {
        this.margen_ganancia = margen_ganancia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad_total() {
        return cantidad_total;
    }

    public void setCantidad_total(int cantidad_total) {
        this.cantidad_total = cantidad_total;
    }
    
}
