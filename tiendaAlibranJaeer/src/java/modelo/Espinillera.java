package modelo;

/**
 *
 * @author erick osoy
 */
public class Espinillera {
    private int id_espinillera;
    private String nombre_espnillera;
    private int id_talla_espinillera;
    private int id_sucursal;
    private double precio_venta;
    private double precio_costo;
    private double margen_ganancia;
    private String descripcion;
    private int cantidad;
    private String talla;
    private String sucursal;
    
    public Espinillera(){
        this.id_espinillera=0;
        this.nombre_espnillera="";
        this.id_talla_espinillera=0;
        this.id_sucursal=0;
        this.precio_venta=0;
        this.precio_costo=0;
        this.margen_ganancia=0;
        this.descripcion="";
        this.cantidad=0;
        this.talla="";
        this.sucursal="";
    }

    public int getId_espinillera() {
        return id_espinillera;
    }

    public void setId_espinillera(int id_espinillera) {
        this.id_espinillera = id_espinillera;
    }

    public String getNombre_espnillera() {
        return nombre_espnillera;
    }

    public void setNombre_espnillera(String nombre_espnillera) {
        this.nombre_espnillera = nombre_espnillera;
    }

    public int getId_talla_espinillera() {
        return id_talla_espinillera;
    }

    public void setId_talla_espinillera(int id_talla_espinillera) {
        this.id_talla_espinillera = id_talla_espinillera;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public double getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(double precio_costo) {
        this.precio_costo = precio_costo;
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
