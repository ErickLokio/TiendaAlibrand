package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.TipoZapatilla;

/**
 *
 * @author erick osoy
 */
public class TipoZapatillaDao extends DAO {

    private ResultSet res;
    private PreparedStatement sta;
    private String query;

    
    public void Guardar(TipoZapatilla za) throws Exception {

        try {
            this.conectar();
            query = "INSERT INTO tipo_zapatilla(nombre_tipo_zapatilla) values(?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, za.getNombre_tipo_zapatilla());
            sta.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR INSERTAR Tipo ZAPATILLA DAO" + e);
        } finally {
            this.cerrar();
        }
    }
    
    
    
    public ArrayList<TipoZapatilla> listaTipoZapatilla() throws Exception {
        ArrayList<TipoZapatilla> lista = null;

        try {
            this.conectar();
            query = "select * from Tipo_Zapatilla";
            sta = this.getCn().prepareCall(query);
            res = sta.executeQuery();
            lista = new ArrayList();

            while (res.next()) {
                modelo.TipoZapatilla za = new modelo.TipoZapatilla();
                za.setId_tipo_zapatilla(res.getInt("id_tipo_zapatilla"));
                za.setNombre_tipo_zapatilla(res.getString("nombre_tipo_zapatilla"));
                lista.add(za);
            }
        } catch (Exception e) {
            System.out.println("ERROR LISTAR Talla_Zapatilla DAO " + e);
        } finally {
            this.cerrar();
        }
        return lista;
    }
    
    public void modificar(TipoZapatilla za) throws Exception {
        try {
            this.conectar();
            query = "UPDATE tipo_zapatilla SET nombre_tipo_zapatilla=? WHERE id_tipo_zapatilla=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, za.getNombre_tipo_zapatilla());
            sta.setInt(2, za.getId_tipo_zapatilla());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error modificar TIPO ZAPATILLA dao: " + e);
        } finally {
            this.cerrar();
        }
    }

    public void eliminar(TipoZapatilla za) throws SQLException, Exception {
        try {
            this.conectar();
            query = "DELETE FROM tipo_zapatilla WHERE id_tipo_zapatilla = ?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, za.getId_tipo_zapatilla());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error TIPO_ZAPATILLA dao: " + e);
        } finally {
            this.cerrar();
        }
    }

}
