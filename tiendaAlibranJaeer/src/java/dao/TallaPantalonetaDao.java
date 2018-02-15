package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.TallaPantaloneta;

/**
 *
 * @author erick osoy
 */
public class TallaPantalonetaDao extends DAO {

    private ResultSet res;
    private PreparedStatement sta;
    private String query;

    
        public void Guardar(TallaPantaloneta za) throws Exception {

        try {
            this.conectar();
            query = "INSERT INTO talla_pantaloneta(nombre_talla_pantaloneta) values(?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, za.getNombre_talla_pantaloneta());
            sta.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR INSERTAR Talla PANTALONETA DAO" + e);
        } finally {
            this.cerrar();
        }
    }
    
    public ArrayList<TallaPantaloneta> listaTallaPantaloneta() throws Exception {
        ArrayList<TallaPantaloneta> lista = null;

        try {
            this.conectar();
            query = "select * from Talla_Pantaloneta";
            sta = this.getCn().prepareCall(query);
            res = sta.executeQuery();
            lista = new ArrayList();

            while (res.next()) {
                TallaPantaloneta za = new TallaPantaloneta();
                za.setId_talla_pantaloneta(res.getInt("id_talla_pantaloneta"));
                za.setNombre_talla_pantaloneta(res.getString("nombre_talla_pantaloneta"));
                lista.add(za);
            }
        } catch (Exception e) {
            System.out.println("ERROR LISTAR Talla_Zapatilla DAO " + e);
        } finally {
            this.cerrar();
        }
        return lista;
    }
    
    
    
    public void modificar(TallaPantaloneta za) throws Exception {
        try {
            this.conectar();
            query = "UPDATE talla_pantaloneta SET nombre_talla_pantaloneta=? WHERE id_talla_pantaloneta=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, za.getNombre_talla_pantaloneta());
            sta.setInt(2, za.getId_talla_pantaloneta());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error modificar Talla PANTALONETA dao: " + e);
        } finally {
            this.cerrar();
        }
    }

    public void eliminar(TallaPantaloneta za) throws SQLException, Exception {
        try {
            this.conectar();
            query = "DELETE FROM talla_pantaloneta WHERE id_talla_pantaloneta = ?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, za.getId_talla_pantaloneta());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Talla Pantaloneta dao: " + e);
        } finally {
            this.cerrar();
        }
    }
    
}
