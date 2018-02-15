package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ProductoInventario;

/**
 *
 * @author jeoloso
 */
public class PruebaF extends DAO {

    private PreparedStatement sta;
    private String query;
    private ResultSet rs;

    public ProductoInventario leerID(ProductoInventario per) throws Exception {
        ProductoInventario pers = null;
        
        try {
            this.conectar();
            String sql = "SELECT * FROM productoinventario WHERE id_producto = ?";

            sta = this.getCn().prepareStatement(sql);
            sta.setInt(1, per.getId_producto());
            rs = sta.executeQuery();

            while (rs.next()) {
                pers = new ProductoInventario();
                pers.setPrecioVenta(rs.getDouble("precio_venta"));
                pers.setCantidad(rs.getInt("cantidad"));
                pers.setCantidad_salida(rs.getInt("cantidad_salida"));
            }
        } catch (Exception e) {
            System.out.println("Revisa personaDAO");
            System.out.println("No se pudo LeerID en PersonaDAO" + e);
        } finally {
            this.cerrar();
        }
        return pers;
    }

    public ArrayList<ProductoInventario> listar() throws Exception {
        ArrayList<ProductoInventario> lstProInv = null;
        try {
            this.conectar();
            query = "select * from productoinventario";
            sta = this.getCn().prepareStatement(query);
            rs = sta.executeQuery();
            lstProInv = new ArrayList<>();

            while (rs.next()) {
                ProductoInventario proInv = new ProductoInventario();
                proInv.setCantidad(rs.getInt("cantidad"));
                proInv.setCantidad_salida(rs.getInt("cantidad_salida"));
                proInv.setDescripcion(rs.getString("descripcion"));
                proInv.setIdSucursal(rs.getInt("id_sucursal"));
                proInv.setIdTalla(rs.getInt("id_talla"));
                proInv.setIdTallaBalon(rs.getInt("id_talla_balon"));
                proInv.setIdTallaEspinillera(rs.getInt("id_talla_espinillera"));
                proInv.setIdTallaPantaloneta(rs.getInt("id_talla_pantaloneta"));
                proInv.setIdTallaZapatilla(rs.getInt("id_talla_zapatilla"));
                proInv.setIdTipoZapatilla(rs.getInt("id_tipo_zapatilla"));
                proInv.setId_producto(rs.getInt("id_producto"));
                System.out.println(rs.getInt("id_producto"));
                proInv.setMargenGanancia(rs.getDouble("margen_ganancia"));
                proInv.setNombreProducto(rs.getString("nombre_producto"));
                proInv.setPrecioCosto(rs.getDouble("precio_costo"));
                proInv.setPrecioVenta(rs.getDouble("precio_venta"));
                lstProInv.add(proInv);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoInventarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrar();
        }
        return lstProInv;
    }
}
