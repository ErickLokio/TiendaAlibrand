package modelo;

/**
 * @author Walter
 */
public class ProductoPantaloneta {
    private int id_producto;
    private String nombreProducto;
    private int idTallaPantaloneta;
    private String tallaPantaloneta;
    private int idSucursal;
    private String sucursal;
    private double precioCosto;
    private double precioVenta;
    private double margenGanancia;
    private String descripcion;
    private int cantidad;

    public String getTallaPantaloneta() {
        return tallaPantaloneta;
    }

    public void setTallaPantaloneta(String tallaPantaloneta) {
        this.tallaPantaloneta = tallaPantaloneta;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
    public int getIdTallaPantaloneta() {
        return idTallaPantaloneta;
    }

    public void setIdTallaPantaloneta(int idTallaPantaloneta) {
        this.idTallaPantaloneta = idTallaPantaloneta;
    }
    
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getMargenGanancia() {
        return margenGanancia;
    }

    public void setMargenGanancia(double margenGanancia) {
        this.margenGanancia = margenGanancia;
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
