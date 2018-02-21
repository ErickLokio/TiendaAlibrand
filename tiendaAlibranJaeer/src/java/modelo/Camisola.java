package modelo;

/**

 * @author Walter
 */
public class Camisola {
    private int idCamisola;
    private String nombreCamisola;
    private int idSucursal;
    private String sucursal;
    private int idTalla;
    private String talla;
    private double precioCosto;
    private double precioVenta;
    private double margenGanancia;
    private String descripcion;
    private int cantidad;
    private String direccion;
    private int cantidadSalida;
    private int idTallaCamisola;

    public int getCantidadSalida() {
        return cantidadSalida;
    }

    public void setCantidadSalida(int cantidadSalida) {
        this.cantidadSalida = cantidadSalida;
    }

    public int getIdTallaCamisola() {
        return idTallaCamisola;
    }

    public void setIdTallaCamisola(int idTallaCamisola) {
        this.idTallaCamisola = idTallaCamisola;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }
    
    
    public int getIdCamisola() {
        return idCamisola;
    }

    public void setIdCamisola(int idCamisola) {
        this.idCamisola = idCamisola;
    }

    public String getNombreCamisola() {
        return nombreCamisola;
    }

    public void setNombreCamisola(String nombreCamisola) {
        this.nombreCamisola = nombreCamisola;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(int idTalla) {
        this.idTalla = idTalla;
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
