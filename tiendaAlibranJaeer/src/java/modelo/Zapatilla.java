package modelo;

/**
 *
 * @author erick osoy
 */
public class Zapatilla {
    private int id_producto;
    private String nombre_producto;
    private int id_talla_zapatilla;
    private int id_tipo_zapatilla;
    private int id_sucursal;
    private double precio_costo;
    private double precio_venta;
    private double margen_ganancia;
    private String descripcion;
    private int cantidad;
    private String tipo;
    private String talla;
    private String sucursal;
    
    public Zapatilla(){
        this.id_producto=0;
        this.nombre_producto="";
        this.id_talla_zapatilla=0;
        this.id_tipo_zapatilla=0;
        this.id_sucursal=0;
        this.precio_costo=0;
        this.precio_venta=0;
        this.margen_ganancia=0;
        this.descripcion="";
        this.cantidad=0;
        this.tipo="";
        this.talla="";
        this.sucursal="";
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

    public int getId_tipo_zapatilla() {
        return id_tipo_zapatilla;
    }

    public void setId_tipo_zapatilla(int id_tipo_zapatilla) {
        this.id_tipo_zapatilla = id_tipo_zapatilla;
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

    public int getId_talla_zapatilla() {
        return id_talla_zapatilla;
    }

    public void setId_talla_zapatilla(int id_talla_zapatilla) {
        this.id_talla_zapatilla = id_talla_zapatilla;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
