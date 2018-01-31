package modelo;

/**
 *
 * @author erick osoy
 */
public class Cotizacion {

    private int id_cotizacion;
    private long no_rut;
    private int id_empleado;
    private String direccion;
    private String nombre_cliente;
    private String fecha;
    private int id_producto_1;
    private int cantidad_1;
    private double precio_unitario_1;
    private double total_1;
    private int id_producto_2;
    private int cantidad_2;
    private double precio_unitario_2;
    private double total_2;
    private int id_producto_3;
    private int cantidad_3;
    private double precio_unitario_3;
    private double total_3;
    private int id_producto_4;
    private int cantidad_4;
    private double precio_unitario_4;
    private double total_4;
    private int id_producto_5;
    private int cantidad_5;
    private double precio_unitario_5;
    private double total_5;
    private double gran_total;

    public Cotizacion() {
        this.id_cotizacion = 0;
        this.no_rut = 0;
        this.id_empleado = 0;
        this.direccion = "";
        this.nombre_cliente = "";
        this.fecha = "";
        this.id_producto_1 = 0;
        this.cantidad_1 = 0;
        this.precio_unitario_1 = 0;
        this.total_1 = 0;
        this.id_producto_2 = 0;
        this.cantidad_2 = 0;
        this.precio_unitario_2 = 0;
        this.total_2 = 0;
        this.id_producto_3 = 0;
        this.cantidad_3 = 0;
        this.precio_unitario_3 = 0;
        this.total_3 = 0;
        this.id_producto_4=0;
        this.cantidad_4=0;
        this.precio_unitario_4=0;
        this.total_4=0;
        this.id_producto_5=0;
        this.cantidad_5=0;
        this.precio_unitario_5=0;
        this.total_5=0;
        this.gran_total=0;
    }

    public int getId_cotizacion() {
        return id_cotizacion;
    }

    public void setId_cotizacion(int id_cotizacion) {
        this.id_cotizacion = id_cotizacion;
    }

    public long getNo_rut() {
        return no_rut;
    }

    public void setNo_rut(long no_rut) {
        this.no_rut = no_rut;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_producto_1() {
        return id_producto_1;
    }

    public void setId_producto_1(int id_producto_1) {
        this.id_producto_1 = id_producto_1;
    }

    public int getCantidad_1() {
        return cantidad_1;
    }

    public void setCantidad_1(int cantidad_1) {
        this.cantidad_1 = cantidad_1;
    }

    public double getPrecio_unitario_1() {
        return precio_unitario_1;
    }

    public void setPrecio_unitario_1(double precio_unitario_1) {
        this.precio_unitario_1 = precio_unitario_1;
    }

    public double getTotal_1() {
        return total_1;
    }

    public void setTotal_1(double total_1) {
        this.total_1 = total_1;
    }

    public int getId_producto_2() {
        return id_producto_2;
    }

    public void setId_producto_2(int id_producto_2) {
        this.id_producto_2 = id_producto_2;
    }

    public int getCantidad_2() {
        return cantidad_2;
    }

    public void setCantidad_2(int cantidad_2) {
        this.cantidad_2 = cantidad_2;
    }

    public double getPrecio_unitario_2() {
        return precio_unitario_2;
    }

    public void setPrecio_unitario_2(double precio_unitario_2) {
        this.precio_unitario_2 = precio_unitario_2;
    }

    public double getTotal_2() {
        return total_2;
    }

    public void setTotal_2(double total_2) {
        this.total_2 = total_2;
    }

    public int getId_producto_3() {
        return id_producto_3;
    }

    public void setId_producto_3(int id_producto_3) {
        this.id_producto_3 = id_producto_3;
    }

    public int getCantidad_3() {
        return cantidad_3;
    }

    public void setCantidad_3(int cantidad_3) {
        this.cantidad_3 = cantidad_3;
    }

    public double getPrecio_unitario_3() {
        return precio_unitario_3;
    }

    public void setPrecio_unitario_3(double precio_unitario_3) {
        this.precio_unitario_3 = precio_unitario_3;
    }

    public double getTotal_3() {
        return total_3;
    }

    public void setTotal_3(double total_3) {
        this.total_3 = total_3;
    }

    public int getId_producto_4() {
        return id_producto_4;
    }

    public void setId_producto_4(int id_producto_4) {
        this.id_producto_4 = id_producto_4;
    }

    public int getCantidad_4() {
        return cantidad_4;
    }

    public void setCantidad_4(int cantidad_4) {
        this.cantidad_4 = cantidad_4;
    }

    public double getPrecio_unitario_4() {
        return precio_unitario_4;
    }

    public void setPrecio_unitario_4(double precio_unitario_4) {
        this.precio_unitario_4 = precio_unitario_4;
    }

    public double getTotal_4() {
        return total_4;
    }

    public void setTotal_4(double total_4) {
        this.total_4 = total_4;
    }

    public int getId_producto_5() {
        return id_producto_5;
    }

    public void setId_producto_5(int id_producto_5) {
        this.id_producto_5 = id_producto_5;
    }

    public int getCantidad_5() {
        return cantidad_5;
    }

    public void setCantidad_5(int cantidad_5) {
        this.cantidad_5 = cantidad_5;
    }

    public double getPrecio_unitario_5() {
        return precio_unitario_5;
    }

    public void setPrecio_unitario_5(double precio_unitario_5) {
        this.precio_unitario_5 = precio_unitario_5;
    }

    public double getTotal_5() {
        return total_5;
    }

    public void setTotal_5(double total_5) {
        this.total_5 = total_5;
    }

    public double getGran_total() {
        return gran_total;
    }

    public void setGran_total(double gran_total) {
        this.gran_total = gran_total;
    }
    
    
}
