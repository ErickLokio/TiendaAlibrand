package modelo;

/**
 *
 * @author erick osoy
 */
public class Factura {
    private int id_factura;
    private String nombre_cliente;
    private long nit;
    private String fecha;
    private int id_producto_1;
    private int cantidad_1;
    private double precio_unitario_1;
    private double descuento_1;
    private double total_1;
    private int id_producto_2;
    private int cantidad_2;
    private double precio_unitario_2;
    private double descuento_2;
    private double total_2;
    private int id_producto_3;
    private int cantidad_3;
    private double precio_unitario_3;
    private double descuento_3;
    private double total_3;
    private int id_producto_4;
    private int cantidad_4;
    private double precio_unitario_4;
    private double descuento_4;
    private double total_4;
    private int id_producto_5;
    private int cantidad_5;
    private double precio_unitario_5;
    private double descuento_5;
    private double total_5;
    private int id_producto_6;
    private int cantidad_6;
    private double precio_unitario_6;
    private double descuento_6;
    private double total_6;
    private int id_producto_7;
    private int cantidad_7;
    private double precio_unitario_7;
    private double descuento_7;
    private double total_7;
    private int id_producto_8;
    private int cantidad_8;
    private double precio_unitario_8;
    private double descuento_8;
    private double total_8;
    private int id_producto_9;
    private int cantidad_9;
    private double precio_unitario_9;
    private double descuento_9;
    private double total_9;
    private double total_factura;
    
    private int cantidad_producto;
    private int cantidad_salida_producto;
    
    public Factura(){
        this.id_factura=0;
        this.nombre_cliente="";
        this.nit=0;
        this.fecha="";
        this.id_producto_1=0;
        this.cantidad_1=0;
        this.precio_unitario_1=0;
        this.descuento_1=0;
        this.total_1=0;
        
        this.id_producto_2=0;
        this.cantidad_2=0;
        this.precio_unitario_2=0;
        this.descuento_2=0;
        this.total_2=0;
        
        this.id_producto_3=0;
        this.cantidad_3=0;
        this.precio_unitario_3=0;
        this.descuento_3=0;
        this.total_3=0;
        this.id_producto_4=0;
        this.cantidad_4=0;
        this.precio_unitario_4=0;
        this.descuento_4=0;
        this.total_4=0;
        this.id_producto_5=0;
        this.cantidad_5=0;
        this.precio_unitario_5=0;
        this.descuento_5=0;
        this.total_5=0;        
        this.id_producto_6=0;
        this.cantidad_6=0;
        this.precio_unitario_6=0;
        this.descuento_6=0;
        this.total_6=0;   
        this.id_producto_7=0;
        this.cantidad_7=0;
        this.precio_unitario_7=0;
        this.descuento_7=0;
        this.total_7=0;
        this.id_producto_8=0;
        this.cantidad_8=0;
        this.precio_unitario_8=0;
        this.descuento_8=0;
        this.total_8=0;
        
        this.id_producto_9=0;
        this.cantidad_9=0;
        this.precio_unitario_9=0;
        this.descuento_9=0;
        this.total_9=0;
        this.total_factura=0;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public long getNit() {
        return nit;
    }

    public void setNit(long nit) {
        this.nit = nit;
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

    public double getDescuento_1() {
        return descuento_1;
    }

    public void setDescuento_1(double descuento_1) {
        this.descuento_1 = descuento_1;
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

    public double getDescuento_2() {
        return descuento_2;
    }

    public void setDescuento_2(double descuento_2) {
        this.descuento_2 = descuento_2;
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

    public double getDescuento_3() {
        return descuento_3;
    }

    public void setDescuento_3(double descuento_3) {
        this.descuento_3 = descuento_3;
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

    public double getDescuento_4() {
        return descuento_4;
    }

    public void setDescuento_4(double descuento_4) {
        this.descuento_4 = descuento_4;
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

    public double getDescuento_5() {
        return descuento_5;
    }

    public void setDescuento_5(double descuento_5) {
        this.descuento_5 = descuento_5;
    }

    public double getTotal_5() {
        return total_5;
    }

    public void setTotal_5(double total_5) {
        this.total_5 = total_5;
    }

    public int getId_producto_6() {
        return id_producto_6;
    }

    public void setId_producto_6(int id_producto_6) {
        this.id_producto_6 = id_producto_6;
    }

    public int getCantidad_6() {
        return cantidad_6;
    }

    public void setCantidad_6(int cantidad_6) {
        this.cantidad_6 = cantidad_6;
    }

    public double getPrecio_unitario_6() {
        return precio_unitario_6;
    }

    public void setPrecio_unitario_6(double precio_unitario_6) {
        this.precio_unitario_6 = precio_unitario_6;
    }

    public double getDescuento_6() {
        return descuento_6;
    }

    public void setDescuento_6(double descuento_6) {
        this.descuento_6 = descuento_6;
    }

    public double getTotal_6() {
        return total_6;
    }

    public void setTotal_6(double total_6) {
        this.total_6 = total_6;
    }

    public int getId_producto_7() {
        return id_producto_7;
    }

    public void setId_producto_7(int id_producto_7) {
        this.id_producto_7 = id_producto_7;
    }

    public int getCantidad_7() {
        return cantidad_7;
    }

    public void setCantidad_7(int cantidad_7) {
        this.cantidad_7 = cantidad_7;
    }

    public double getPrecio_unitario_7() {
        return precio_unitario_7;
    }

    public void setPrecio_unitario_7(double precio_unitario_7) {
        this.precio_unitario_7 = precio_unitario_7;
    }

    public double getDescuento_7() {
        return descuento_7;
    }

    public void setDescuento_7(double descuento_7) {
        this.descuento_7 = descuento_7;
    }

    public double getTotal_7() {
        return total_7;
    }

    public void setTotal_7(double total_7) {
        this.total_7 = total_7;
    }

    public int getId_producto_8() {
        return id_producto_8;
    }

    public void setId_producto_8(int id_producto_8) {
        this.id_producto_8 = id_producto_8;
    }

    public int getCantidad_8() {
        return cantidad_8;
    }

    public void setCantidad_8(int cantidad_8) {
        this.cantidad_8 = cantidad_8;
    }

    public double getPrecio_unitario_8() {
        return precio_unitario_8;
    }

    public void setPrecio_unitario_8(double precio_unitario_8) {
        this.precio_unitario_8 = precio_unitario_8;
    }

    public double getDescuento_8() {
        return descuento_8;
    }

    public void setDescuento_8(double descuento_8) {
        this.descuento_8 = descuento_8;
    }

    public double getTotal_8() {
        return total_8;
    }

    public void setTotal_8(double total_8) {
        this.total_8 = total_8;
    }

    public int getId_producto_9() {
        return id_producto_9;
    }

    public void setId_producto_9(int id_producto_9) {
        this.id_producto_9 = id_producto_9;
    }

    public int getCantidad_9() {
        return cantidad_9;
    }

    public void setCantidad_9(int cantidad_9) {
        this.cantidad_9 = cantidad_9;
    }

    public double getPrecio_unitario_9() {
        return precio_unitario_9;
    }

    public void setPrecio_unitario_9(double precio_unitario_9) {
        this.precio_unitario_9 = precio_unitario_9;
    }

    public double getDescuento_9() {
        return descuento_9;
    }

    public void setDescuento_9(double descuento_9) {
        this.descuento_9 = descuento_9;
    }

    public double getTotal_9() {
        return total_9;
    }

    public void setTotal_9(double total_9) {
        this.total_9 = total_9;
    }

    public double getTotal_factura() {
        return total_factura;
    }

    public void setTotal_factura(double total_factura) {
        this.total_factura = total_factura;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public int getCantidad_salida_producto() {
        return cantidad_salida_producto;
    }

    public void setCantidad_salida_producto(int cantidad_salida_producto) {
        this.cantidad_salida_producto = cantidad_salida_producto;
    }
    
    
    
    
}