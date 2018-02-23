package modelo;

/**
 * @author Walter
 */
public class Pantaloneta {
   private int idPantaloneta;
   private String nombrePantaloneta;
   private int idTallaPantaloneta;
   private int idSucursal;
   private double precioCosto;
   private double precioVenta;
   private double margenGanancia;
   private String descripcion;
   private int cantidad;
   private String talla;
   private String sucursal;

    public int getIdPantaloneta() {
        return idPantaloneta;
    }

    public void setIdPantaloneta(int idPantaloneta) {
        this.idPantaloneta = idPantaloneta;
    }

    public String getNombrePantaloneta() {
        return nombrePantaloneta;
    }

    public void setNombrePantaloneta(String nombrePantaloneta) {
        this.nombrePantaloneta = nombrePantaloneta;
    }

    public int getIdTallaPantaloneta() {
        return idTallaPantaloneta;
    }

    public void setIdTallaPantaloneta(int idTallaPantaloneta) {
        this.idTallaPantaloneta = idTallaPantaloneta;
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
