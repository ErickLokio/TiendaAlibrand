package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Empleado;
import modelo.Sucursal;

/**
 * @author Walter
 */
public class SucursalDao extends DAO{
    private ResultSet res;
    private PreparedStatement sta;
    private String query;
    
    public ArrayList<Sucursal> listar() throws Exception{
        ArrayList<Sucursal> lstSucursal =null;
        try {
            this.conectar();
            query="select * from sucursal";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lstSucursal = new ArrayList();
            
            while (res.next()) {
                Sucursal suc = new Sucursal();
                suc.setIdSucursal(res.getInt("id_sucursal"));
                suc.setSucursal(res.getString("nombre_sucursal"));
                lstSucursal.add(suc);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SucursalDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        return lstSucursal;
    }
    
    
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
    
    
    
    public void Guardar(Sucursal su) throws Exception{
    
        try{
            this.conectar();
            query = "INSERT INTO sucursal(nombre_sucursal, direccion, telefono_claro,telefono_movistar, id_empleado, email) values(?,?,?,?,?,?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, su.getSucursal());
            sta.setString(2, su.getDireccion());
            sta.setInt(3, su.getTelefono_claro());
            sta.setInt(4, su.getTelefono_movistar());
            sta.setInt(5, su.getId_empleado());
            sta.setString(6, su.getEmail());
            sta.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR INSERTAR SUCURSAL DAO" +e);
        }finally{
            this.cerrar();
        }
    }
    
    
    
    public ArrayList<Sucursal> listaSucu() throws Exception{
    ArrayList<Sucursal> lista = null;
    
    try{
        this.conectar();
        query = "select * from sucursal";
        sta = this.getCn().prepareCall(query);
        res = sta.executeQuery();
        lista = new ArrayList();
        
        while(res.next()){
            Sucursal su = new Sucursal();
            su.setIdSucursal(res.getInt("id_sucursal"));
            su.setSucursal(res.getString("nombre_sucursal"));
            su.setDireccion(res.getString("direccion"));
            su.setTelefono_claro(res.getInt("telefono_claro"));
            su.setTelefono_movistar(res.getInt("telefono_movistar"));
            su.setId_empleado(res.getInt("id_empleado"));
            su.setEmail(res.getString("email"));
            lista.add(su);
        }
    }catch(Exception e){
        System.out.println("ERROR LISTAR SUCURSAL DAO "+e);
    }finally{
        this.cerrar();
    }
    return lista;
}
    
    
    
    
    public Sucursal leerID(Sucursal su) throws Exception{
        Sucursal sucu = null;

        try{
            this.conectar();
            query = "select * from sucursal where id_sucursal=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, su.getIdSucursal());
            res = sta.executeQuery();

            while(res.next()){
                sucu = new Sucursal();
                sucu.setIdSucursal(res.getInt("id_sucursal"));
                sucu.setSucursal(res.getString("nombre_sucursal"));
                sucu.setDireccion(res.getString("direccion"));
                sucu.setTelefono_claro(res.getInt("telefono_claro"));
                sucu.setTelefono_movistar(res.getInt("telefono_movistar"));
                sucu.setId_empleado(res.getInt("id_empleado"));
                sucu.setEmail(res.getString("email"));
                }
        }catch(Exception e){
            System.out.println("ERROR BUSCAR sucursal DAO" +e);
        }finally{
            this.cerrar();
        }
            return sucu;
   }
    
    
    public void modificar(Sucursal su) throws Exception{
        try {
            this.conectar();
            query = "UPDATE sucursal SET nombre_sucursal=?,direccion=?,telefono_claro=?,telefono_movistar=?,id_empleado=?, email=? WHERE id_sucursal=?";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, su.getSucursal());
            sta.setString(2, su.getDireccion());
            sta.setInt(3, su.getTelefono_claro());
            sta.setInt(4, su.getTelefono_movistar());
            sta.setInt(5, su.getId_empleado());
            sta.setString(6, su.getEmail());
            sta.setInt(7, su.getIdSucursal());
            sta.executeUpdate(); 
        } catch (SQLException e) {
            System.out.println("Error modificar sucursal dao: "+e);
        } finally {
            this.cerrar();
        }
    }
    
    
    public void eliminar (Sucursal su) throws SQLException, Exception{
        try {
            this.conectar();
            query = "DELETE FROM sucursal WHERE id_sucursal = ?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, su.getIdSucursal());
            sta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error sucursal eliminar dao: "+e);
        } finally {
            this.cerrar();
        }
    }
        
}
