package modelo;

/**
 * @author Walter
 */
public class ProductoInventario {
    private int id_producto;
    private String nombreProducto;
    private int idTallaBalon;
    private int idTalla;
    private int idTallaEspinillera;
    private int idTallaZapatilla;
    private int idTallaPantaloneta;
    private int idSucursal;
    private double precioCosto;
    private double precioVenta;
    private double margenGanancia;
    private String descripcion;
    private int cantidad;
    private int idTipoZapatilla;
    private int cantidad_salida;

    public int getIdTipoZapatilla() {
        return idTipoZapatilla;
    }

    public void setIdTipoZapatilla(int idTipoZapatilla) {
        this.idTipoZapatilla = idTipoZapatilla;
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

    public int getIdTallaBalon() {
        return idTallaBalon;
    }

    public void setIdTallaBalon(int idTallaBalon) {
        this.idTallaBalon = idTallaBalon;
    }

    public int getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(int idTalla) {
        this.idTalla = idTalla;
    }

    public int getIdTallaEspinillera() {
        return idTallaEspinillera;
    }

    public void setIdTallaEspinillera(int idTallaEspinillera) {
        this.idTallaEspinillera = idTallaEspinillera;
    }

    public int getIdTallaZapatilla() {
        return idTallaZapatilla;
    }

    public void setIdTallaZapatilla(int idTallaZapatilla) {
        this.idTallaZapatilla = idTallaZapatilla;
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

    public int getCantidad_salida() {
        return cantidad_salida;
    }

    public void setCantidad_salida(int cantidad_salida) {
        this.cantidad_salida = cantidad_salida;
    }
    
}
