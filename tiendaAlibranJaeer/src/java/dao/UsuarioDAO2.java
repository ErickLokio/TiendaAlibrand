package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuarios;

/**
 *
 * @author erick osoy
 */
public class UsuarioDAO2 extends DAO{

private PreparedStatement st;
private String sql;
private ResultSet rs;

public void GuardarUsuario(Usuarios usu) throws Exception{
    
    try{
        this.conectar();
        sql = "INSERT INTO usuario values(?,?,?,?)";
        st = this.getCn().prepareStatement(sql);
        st.setInt(1, usu.getId_usuario());
        st.setInt(2, usu.getIdEmpleado());
        st.setString(3, usu.getNombre());
        st.setString(4, usu.getContraseña());
        st.executeUpdate();
    }catch(Exception e){
        System.out.println("ERROR INSERTAR USUARIOS2 DAO" +e);
    }finally{
        this.cerrar();
    }
}



public List<Usuarios> lista() throws Exception{
    List<Usuarios> lista = null;
    
    try{
        this.conectar();
        sql = "select * from usuario";
        st = this.getCn().prepareCall(sql);
        rs = st.executeQuery();
        lista = new ArrayList();
        
        while(rs.next()){
            Usuarios usu = new Usuarios();
            usu.setId_usuario(rs.getInt("id_usuario"));
            usu.setIdEmpleado(rs.getInt("id_empleado"));
            usu.setNombre(rs.getString("nombre_usuario"));
            lista.add(usu);
        }
    }catch(Exception e){
        System.out.println("ERROR LISTAR USUARIOS2 DAO "+e);
    }finally{
        this.cerrar();
    }
    return lista;
} 


public Usuarios leerID(Usuarios usu) throws Exception{
    Usuarios usuu = null;
    
    try{
        this.conectar();
        sql = "select * from usuario where id_usuario=?";
        st = this.getCn().prepareStatement(sql);
        st.setInt(1, usu.getId_usuario());
        rs = st.executeQuery();
        
        while(rs.next()){
            usuu = new Usuarios();
            usuu.setId_usuario(rs.getInt("id_usuario"));
            usuu.setIdEmpleado(rs.getInt("id_empleado"));
            usuu.setNombre(rs.getString("nombre_usuario"));
            }
    }catch(Exception e){
        System.out.println("ERROR BUSCAR USUARIO2 DAO" +e);
    }finally{
        this.cerrar();
    }
        return usuu;
    }


    public void modificar(Usuarios usu) throws Exception{
        try {
            this.conectar();
            sql = "UPDATE usuario SET nombre_usuario=? WHERE id_usuario=?";
            st = this.getCn().prepareStatement(sql);
            st.setString(1, usu.getNombre());
            st.setInt(2, usu.getId_usuario());
            st.executeUpdate(); 
        } catch (SQLException e) {
            System.out.println("Error usuario2 modificar: "+e);
        } finally {
            this.cerrar();
        }
    }
    
    
    
    public void eliminar (Usuarios usu) throws SQLException, Exception{
        try {
            this.conectar();
            sql = "DELETE FROM usuario WHERE id_usuario = ?";
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, usu.getId_usuario());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error ExamenDao eliminar: "+e);
        } finally {
            this.cerrar();
        }
    }
    
}
