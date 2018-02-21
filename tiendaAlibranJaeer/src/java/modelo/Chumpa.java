package modelo;

/**
 *
 * @author erick osoy
 */
public class Chumpa {
    private int id_chumpa;
    private String nombre_chumpa;
    private int id_talla;
    private String talla;
    private int id_sucursal;
    private String sucursal;
    private double precio_costo;
    private double precio_venta;
    private double margen_ganancia;
    private String descripcion;
    private int cantidad_total;
    
    public Chumpa(){
        this.id_chumpa=0;
        this.nombre_chumpa="";
        this.id_talla=0;
        this.id_sucursal=0;
        this.precio_costo=0;
        this.precio_venta=0;
        this.margen_ganancia=0;
        this.descripcion="";
        this.cantidad_total=0;
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
    
    public int getId_chumpa() {
        return id_chumpa;
    }

    public void setId_chumpa(int id_chumpa) {
        this.id_chumpa = id_chumpa;
    }

    public String getNombre_chumpa() {
        return nombre_chumpa;
    }

    public void setNombre_chumpa(String nombre_chumpa) {
        this.nombre_chumpa = nombre_chumpa;
    }

    public int getId_talla() {
        return id_talla;
    }

    public void setId_talla(int id_talla) {
        this.id_talla = id_talla;
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

    public int getCantidad_total() {
        return cantidad_total;
    }

    public void setCantidad_total(int cantidad_total) {
        this.cantidad_total = cantidad_total;
    }
}
