package modelo;

/**
 *
 * @author erick osoy
 */
public class Balon {
    private int id_producto;
    private String nombre_producto;
    private int id_talla_balon;
    private int id_sucursal;
    private double precio_costo;
    private double precio_venta;
    private double margen_ganancia;
    private String descripcion;
    private int cantidad;
    private String talla_balon;
    private String sucursal;
    
    public Balon(){
        this.id_producto=0;
        this.nombre_producto="";
        this.id_talla_balon=0;
        this.id_sucursal=0;
        this.precio_costo=0;
        this.precio_venta=0;
        this.margen_ganancia=0;
        this.descripcion="";
        this.talla_balon="";
        this.sucursal="";
        this.cantidad=0;
        
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
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

    public String getTalla_balon() {
        return talla_balon;
    }

    public void setTalla_balon(String talla_balon) {
        this.talla_balon = talla_balon;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
    
    
}
