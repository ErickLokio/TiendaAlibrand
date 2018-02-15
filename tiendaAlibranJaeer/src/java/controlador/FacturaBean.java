package controlador;

import dao.FacturaDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import modelo.Factura;
import modelo.ProductoInventario;

/**
 *
 * @author erick osoy
 */
@ManagedBean(name="facturaBean")
@ViewScoped
public class FacturaBean {

    private Factura ingreso = new Factura();
    private ProductoInventario nuevo = new ProductoInventario();

    /* ------ METODOS DE MODIFICAR ------ */
    private ProductoInventario pro = new ProductoInventario();
    private ProductoInventario pro2 = new ProductoInventario();
    private ProductoInventario pro3 = new ProductoInventario();
    private ProductoInventario pro4 = new ProductoInventario();
    private ProductoInventario pro5 = new ProductoInventario();
    private ProductoInventario pro6 = new ProductoInventario();
    private ProductoInventario pro7 = new ProductoInventario();
    private ProductoInventario pro8 = new ProductoInventario();
    private ProductoInventario pro9 = new ProductoInventario();
    /* ------ METODOS DE MODIFICAR ------ */

    private ArrayList<Factura> lstFactura = new ArrayList<>();
    
    @ManagedProperty("#{productoInventarioBean}")
    private ProductoInventarioBean proIn ;

    public ProductoInventarioBean getProIn() {
        return proIn;
    }

    public void setProIn(ProductoInventarioBean proIn) {
        this.proIn = proIn;
    }
    
    public Factura getIngreso() {
        return ingreso;
    }

    public void setIngreso(Factura ingreso) {
        this.ingreso = ingreso;
    }

    public ArrayList<Factura> getLstFactura() {
        return lstFactura;
    }

    public void setLstFactura(ArrayList<Factura> lstFactura) {
        this.lstFactura = lstFactura;
    }

    public void Limpiar() {

        ingreso.setId_factura(0);
        ingreso.setNit(0);
        ingreso.setNombre_cliente("");

        ingreso.setId_producto_1(0);
        ingreso.setCantidad_1(0);
        ingreso.setDescuento_1(0);
        ingreso.setPrecio_unitario_1(0);
        ingreso.setTotal_1(0);

        ingreso.setId_producto_2(0);
        ingreso.setCantidad_2(0);
        ingreso.setPrecio_unitario_2(0);
        ingreso.setDescuento_2(0);
        ingreso.setTotal_2(0);

        ingreso.setId_producto_3(0);
        ingreso.setCantidad_3(0);
        ingreso.setPrecio_unitario_3(0);
        ingreso.setDescuento_3(0);
        ingreso.setTotal_3(0);

        ingreso.setId_producto_4(0);
        ingreso.setCantidad_4(0);
        ingreso.setPrecio_unitario_4(0);
        ingreso.setDescuento_4(0);
        ingreso.setTotal_4(0);

        ingreso.setId_producto_5(0);
        ingreso.setCantidad_5(0);
        ingreso.setPrecio_unitario_5(0);
        ingreso.setDescuento_5(0);
        ingreso.setTotal_5(0);
    }

    public void insertar() {
        FacturaDao dao;

        try {
            dao = new FacturaDao();
            dao.guardarFactura(ingreso);
            this.Limpiar();
        } catch (Exception e) {
            System.out.println("ERROR INGRESO FACTURA BEAN  --BEAN" + e);
        }
    }

    /*
        -------------------------------METODOS DE MODIFICAR -------------------------------
     */
    public void modificar() {
        FacturaDao dao;
        try {
            dao = new FacturaDao();
            pro.setId_producto(ingreso.getId_producto_1());
            pro.setCantidad_salida(ingreso.getCantidad_1());
            dao.modificar(pro);
        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
    }

    public void modificar2() {
        FacturaDao dao;
        try {
            dao = new FacturaDao();
            pro2.setId_producto(ingreso.getId_producto_2());
            pro2.setCantidad_salida(ingreso.getCantidad_2());
            dao.modificar(pro2);
        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
    }

    public void modificar3() {
        FacturaDao dao;
        try {
            dao = new FacturaDao();
            pro3.setId_producto(ingreso.getId_producto_3());
            pro3.setCantidad_salida(ingreso.getCantidad_3());
            dao.modificar(pro3);
        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
    }

    public void modificar4() {
        FacturaDao dao;
        try {
            dao = new FacturaDao();
            pro4.setId_producto(ingreso.getId_producto_4());
            pro4.setCantidad_salida(ingreso.getCantidad_4());
            dao.modificar(pro4);
        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
    }

    public void modificar5() {
        FacturaDao dao;
        try {
            dao = new FacturaDao();
            pro5.setId_producto(ingreso.getId_producto_5());
            pro5.setCantidad_salida(ingreso.getCantidad_5());
            dao.modificar(pro5);
        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
    }

    public void modificar6() {
        FacturaDao dao;
        try {
            dao = new FacturaDao();
            pro6.setId_producto(ingreso.getId_producto_6());
            pro6.setCantidad_salida(ingreso.getCantidad_6());
            dao.modificar(pro6);
        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
    }

    public void modificar7() {
        FacturaDao dao;
        try {
            dao = new FacturaDao();
            pro7.setId_producto(ingreso.getId_producto_7());
            pro7.setCantidad_salida(ingreso.getCantidad_7());
            dao.modificar(pro7);
        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
    }

    public void modificar8() {
        FacturaDao dao;
        try {
            dao = new FacturaDao();
            pro8.setId_producto(ingreso.getId_producto_8());
            pro8.setCantidad_salida(ingreso.getCantidad_8());
            dao.modificar(pro8);
        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
    }

    public void modificar9() {
        FacturaDao dao;
        try {
            dao = new FacturaDao();
            pro9.setId_producto(ingreso.getId_producto_9());
            pro9.setCantidad_salida(ingreso.getCantidad_9());
            dao.modificar(pro9);
        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
    }
    
    
    public void modificar10() {
        int total=0;
        int cantidad = 0;
        int cantidad_salida= ingreso.getCantidad_1();
        int id = ingreso.getId_producto_1();
        
        System.out.println("id " + id);
        
        for(int i=0; i<proIn.getLstProductoInventario().size(); i++){
            System.out.println("cantidad_Factura: -------" + proIn.getLstProductoInventario().get(i).getCantidad());
            
            if(ingreso.getId_producto_1() == proIn.getLstProductoInventario().get(i).getId_producto()){
                cantidad = proIn.getLstProductoInventario().get(i).getCantidad();
                
                total = ((cantidad - cantidad_salida));
            }
        }
        
        
        System.out.println("cantiudad OTRA ------" +cantidad);
        System.out.println("cantidad salida ----------" +cantidad_salida);
        System.out.println("total ----------- " +total);
        
        FacturaDao dao;
        try {
            dao = new FacturaDao();
            
            pro.setCantidad_salida(total);
            dao.modificarTotalFinal(pro);
        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
    }
    
    
    public void modificarMaster() {
        this.modificar();
        this.modificar2();
        this.modificar3();
        this.modificar4();
        this.modificar5();
        this.modificar6();
        this.modificar7();
        this.modificar8();
        this.modificar9();
    }

    /*
        -------------------------------METODOS DE MODIFICAR -------------------------------
     */

    /*
        INICIO FORMULAS 
     */
    public void calcularGanancia() {
        double total;
        double precio = ingreso.getPrecio_unitario_1();
        double cantidad = ingreso.getCantidad_1();
        double descuento = ingreso.getDescuento_1();

        total = ((precio * cantidad) - descuento);
        ingreso.setTotal_1(total);

    }

    public void calcularGanancia2() {
        double total;
        double precio = ingreso.getPrecio_unitario_2();
        double cantidad = ingreso.getCantidad_2();
        double descuento = ingreso.getDescuento_2();

        total = ((precio * cantidad) - descuento);
        ingreso.setTotal_2(total);
    }

    public void calcularGanancia3() {
        double total;
        double precio = ingreso.getPrecio_unitario_3();
        double cantidad = ingreso.getCantidad_3();
        double descuento = ingreso.getDescuento_3();

        total = ((precio * cantidad) - descuento);
        ingreso.setTotal_3(total);
    }

    public void calcularGanancia4() {
        double total;
        double precio = ingreso.getPrecio_unitario_4();
        double cantidad = ingreso.getCantidad_4();
        double descuento = ingreso.getDescuento_4();

        total = ((precio * cantidad) - descuento);
        ingreso.setTotal_4(total);
    }

    public void calcularGanancia5() {
        double total;
        double precio = ingreso.getPrecio_unitario_5();
        double cantidad = ingreso.getCantidad_5();
        double descuento = ingreso.getDescuento_5();

        total = ((precio * cantidad) - descuento);
        ingreso.setTotal_5(total);
    }

    public void calcularGanancia66() {
        double total;
        double precio = ingreso.getPrecio_unitario_6();
        double cantidad = ingreso.getCantidad_6();
        double descuento = ingreso.getDescuento_6();

        total = ((precio * cantidad) - descuento);
        ingreso.setTotal_6(total);
    }

    public void calcularGanancia7() {
        double total;
        double precio = ingreso.getPrecio_unitario_7();
        double cantidad = ingreso.getCantidad_7();
        double descuento = ingreso.getDescuento_7();

        total = ((precio * cantidad) - descuento);
        ingreso.setTotal_7(total);
    }

    public void calcularGanancia8() {
        double total;
        double precio = ingreso.getPrecio_unitario_8();
        double cantidad = ingreso.getCantidad_8();
        double descuento = ingreso.getDescuento_8();

        total = ((precio * cantidad) - descuento);
        ingreso.setTotal_8(total);
    }

    public void calcularGanancia9() {
        double total;
        double precio = ingreso.getPrecio_unitario_9();
        double cantidad = ingreso.getCantidad_9();
        double descuento = ingreso.getDescuento_9();

        total = ((precio * cantidad) - descuento);
        ingreso.setTotal_9(total);
    }

    public void calcularTodo() {
        double total;
        double total1 = ingreso.getTotal_1();
        double total2 = ingreso.getTotal_2();
        double total3 = ingreso.getTotal_3();
        double total4 = ingreso.getTotal_4();
        double total5 = ingreso.getTotal_5();
        double total6 = ingreso.getTotal_6();
        double total7 = ingreso.getTotal_7();
        double total8 = ingreso.getTotal_8();
        double total9 = ingreso.getTotal_9();

        total = ((total1 + total2 + total3 + total4 + total5 + total6 + total7 + total8 + total9));
        ingreso.setTotal_factura(total);
    }

    /*
        FIN FORMULAS 
     */

    public void calcularGanancia6() {
        calcularGanancia();
        calcularGanancia2();
        calcularGanancia3();
        calcularGanancia4();
        calcularGanancia5();
        calcularGanancia66();
        calcularGanancia7();
        calcularGanancia8();
        calcularGanancia9();
        calcularTodo();

    }    
}
