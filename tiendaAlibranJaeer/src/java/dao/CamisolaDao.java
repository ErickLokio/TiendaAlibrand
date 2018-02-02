package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Camisola;

/**
 *
 * @author Walter
 */
public class CamisolaDao extends DAO {

    private String query;
    private PreparedStatement sta;
    private ResultSet res;

    public void ingresar(Camisola cam) {
        
        try {
            this.conectar();
            query = "insert into camisola(nombre_camisola, id_talla, id_sucursal, precio_costo, precio_venta, margen_ganancia, descripcion, cantidad) values(?,?,?,?,?,?,?,?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, cam.getNombreCamisola());
            sta.setInt(2, cam.getIdTalla());
            sta.setInt(3, cam.getIdSucursal());
            sta.setDouble(4, cam.getPrecioCosto());
            sta.setDouble(5, cam.getPrecioVenta());
        } catch (Exception ex) {
            Logger.getLogger(CamisolaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
