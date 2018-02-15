package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.TallaBalon;

/**
 *
 * @author erick osoy
 */
public class TallaBalonDao extends DAO{
    
    private ResultSet res;
    private PreparedStatement sta;
    private String query;
    
    
    public void Guardar(TallaBalon za) throws Exception {

        try {
            this.conectar();
            query = "INSERT INTO talla_balon(nombre_talla_balon) values(?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, za.getNombre_talla_balon());
            sta.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR INSERTAR Talla BALON DAO" + e);
        } finally {
            this.cerrar();
        }
    }
    
    public ArrayList<TallaBalon> listaTallaBalon() throws Exception {
        ArrayList<TallaBalon> lista = null;

        try {
            this.conectar();
            query = "select * from Talla_Balon";
            sta = this.getCn().prepareCall(query);
            res = sta.executeQuery();
            lista = new ArrayList();

            while (res.next()) {
                TallaBalon ba = new TallaBalon();
                ba.setId_talla_balon(res.getInt("id_talla_balon"));
                ba.setNombre_talla_balon(res.getString("nombre_talla_balon"));
                lista.add(ba);
            }
        } catch (Exception e) {
            System.out.println("ERROR LISTAR Talla_balon DAO " + e);
        } finally {
            this.cerrar();
        }
        return lista;
    }
    
    
    
    public void modificar(TallaBalon ba) throws Exception {
        try {
            this.conectar();
            query = "UPDATE talla_balon SET nombre_talla_balon=? WHERE id_talla_balon=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, ba.getNombre_talla_balon());
            sta.setInt(2, ba.getId_talla_balon());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error modificar Talla balon dao: " + e);
        } finally {
            this.cerrar();
        }
    }

    public void eliminar(TallaBalon ba) throws SQLException, Exception {
        try {
            this.conectar();
            query = "DELETE FROM talla_balon WHERE id_talla_balon = ?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, ba.getId_talla_balon());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error talla_balon dao: " + e);
        } finally {
            this.cerrar();
        }
    }
    
}
