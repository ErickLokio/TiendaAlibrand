package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Talla_Zapatilla;

/**
 *
 * @author erick osoy
 */
public class TallaZapatillaDao extends DAO {

    private ResultSet res;
    private PreparedStatement sta;
    private String query;

    public void Guardar(Talla_Zapatilla za) throws Exception {

        try {
            this.conectar();
            query = "INSERT INTO talla_zapatilla(nombre_zapatilla) values(?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, za.getNombre_zapatilla());
            sta.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR INSERTAR Talla ZAPATILLA DAO" + e);
        } finally {
            this.cerrar();
        }
    }
    
    public ArrayList<Talla_Zapatilla> listaTalla_Zapatilla() throws Exception {
        ArrayList<Talla_Zapatilla> lista = null;

        try {
            this.conectar();
            query = "select * from Talla_Zapatilla";
            sta = this.getCn().prepareCall(query);
            res = sta.executeQuery();
            lista = new ArrayList();

            while (res.next()) {
                Talla_Zapatilla za = new Talla_Zapatilla();
                za.setId_talla_zapatilla(res.getInt("id_talla_zapatilla"));
                za.setNombre_zapatilla(res.getString("nombre_zapatilla"));
                lista.add(za);
            }
        } catch (Exception e) {
            System.out.println("ERROR LISTAR Talla_Zapatilla DAO " + e);
        } finally {
            this.cerrar();
        }
        return lista;
    }
    
    
    
    public void modificar(Talla_Zapatilla za) throws Exception {
        try {
            this.conectar();
            query = "UPDATE talla_zapatilla SET nombre_zapatilla=? WHERE id_talla_zapatilla=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, za.getNombre_zapatilla());
            sta.setInt(2, za.getId_talla_zapatilla());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error modificar Talla ZAPATILLA dao: " + e);
        } finally {
            this.cerrar();
        }
    }

    public void eliminar(Talla_Zapatilla za) throws SQLException, Exception {
        try {
            this.conectar();
            query = "DELETE FROM talla_zapatilla WHERE id_talla_zapatilla = ?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, za.getId_talla_zapatilla());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error talla_ZAPATILLA dao: " + e);
        } finally {
            this.cerrar();
        }
    }
    
}
