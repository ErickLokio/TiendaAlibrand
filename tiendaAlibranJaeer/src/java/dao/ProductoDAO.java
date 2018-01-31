package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;

/**
 *
 * @author erick osoy
 */
public class ProductoDAO extends DAO {

    private PreparedStatement st;
    private String sql;
    private ResultSet rs;
    
    
    public void Guardar(Producto pro) throws Exception{
    
        try{
            this.conectar();
            sql = "INSERT INTO producto(id_sucursal, precio_costo, precio_venta,margen_ganancia, descripcion, cantidad_total) values(?,?,?,?,?,?)";
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, pro.getId_sucursal());
            st.setDouble(2, pro.getPrecio_costo());
            st.setDouble(3, pro.getPrecio_venta());
            st.setInt(4, pro.getMargen_ganancia());
            st.setString(5, pro.getDescripcion());
            st.setInt(6, pro.getCantidad_total());
            st.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR INSERTAR PRODUCTO DAO" +e);
        }finally{
            this.cerrar();
        }
    }
    
    
    public List<Producto> lista() throws Exception{
    List<Producto> lista = null;
    
    try{
        this.conectar();
        sql = "select * from producto";
        st = this.getCn().prepareCall(sql);
        rs = st.executeQuery();
        lista = new ArrayList();
        
        while(rs.next()){
            Producto pro = new Producto();
            pro.setId_producto(rs.getInt("id_producto"));
            pro.setId_sucursal(rs.getInt("id_sucursal"));
            pro.setPrecio_costo(rs.getDouble("precio_costo"));
            pro.setPrecio_venta(rs.getDouble("precio_venta"));
            pro.setMargen_ganancia(rs.getInt("margen_ganancia"));
            pro.setDescripcion(rs.getString("descripcion"));
            pro.setCantidad_total(rs.getInt("cantidad_total"));
            lista.add(pro);
        }
    }catch(Exception e){
        System.out.println("ERROR LISTAR Producto DAO "+e);
    }finally{
        this.cerrar();
    }
    return lista;
}
    
    
    public Producto leerID(Producto pro) throws Exception{
        Producto po = null;

        try{
            this.conectar();
            sql = "select * from producto where id_producto=?";
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, pro.getId_producto());
            rs = st.executeQuery();

            while(rs.next()){
                po = new Producto();
                po.setId_producto(rs.getInt("id_producto"));
                po.setId_sucursal(rs.getInt("id_sucursal"));
                po.setPrecio_costo(rs.getDouble("precio_costo"));
                po.setPrecio_venta(rs.getDouble("precio_venta"));
                po.setMargen_ganancia(rs.getInt("margen_ganancia"));
                po.setDescripcion(rs.getString("descripcion"));
                po.setCantidad_total(rs.getInt("cantidad_total"));
                }
        }catch(Exception e){
            System.out.println("ERROR BUSCAR USUARIO2 DAO" +e);
        }finally{
            this.cerrar();
        }
            return po;
   }


    public void modificar(Producto pro) throws Exception{
        try {
            this.conectar();
            sql = "UPDATE producto SET id_sucursal=?,precio_costo=?,precio_venta=?, margen_ganancia=?, descripcion=?, cantidad_total=? WHERE id_producto=?";
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, pro.getId_sucursal());
            st.setDouble(2, pro.getPrecio_costo());
            st.setDouble(3, pro.getPrecio_venta());
            st.setInt(4, pro.getMargen_ganancia());
            st.setString(5, pro.getDescripcion());
            st.setInt(6, pro.getCantidad_total());
            st.setInt(7, pro.getId_producto());
            st.executeUpdate(); 
        } catch (SQLException e) {
            System.out.println("Error producto modificar dao: "+e);
        } finally {
            this.cerrar();
        }
    }
    
    
    
    public void eliminar (Producto pro) throws SQLException, Exception{
        try {
            this.conectar();
            sql = "DELETE FROM producto WHERE id_producto = ?";
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, pro.getId_producto());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error producto eliminar dao: "+e);
        } finally {
            this.cerrar();
        }
    }
    
}
