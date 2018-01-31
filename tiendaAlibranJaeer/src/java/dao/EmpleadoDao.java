
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Empleado;
import modelo.innerEmpleado;

/**
 * @author Walter
 */
public class EmpleadoDao extends DAO{
    private PreparedStatement sta;
    private ResultSet res;
    private String query;
    
    public void ingresar(Empleado emp) throws Exception{
        try {
            this.conectar();
            query = "insert into empleado (nombre_empleado, telefono_claro, telefono_movistar, id_puesto, id_sucursal, direccion, email) values(?,?,?,?,?,?,?)";
            sta = this.getCn().prepareStatement(query);
            sta.setString(1, emp.getNombreEmplado());
            sta.setInt(2, emp.getTelefono());
            sta.setInt(3, emp.getTelefono2());
            sta.setInt(4, emp.getIdPuesto());
            sta.setInt(5, emp.getIdSucursal());
            sta.setString(6, emp.getDireccion());
            sta.setString(7, emp.getEmail());
            sta.executeUpdate();
            
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
    }
    //este metodo esta utilizando una vista y la vista contiene un innerjoin
    public ArrayList<innerEmpleado> listar() throws Exception{
        ArrayList<innerEmpleado> lstEmpleado=null;
        try {
            this.conectar();
            query="select * from dato_empleado";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lstEmpleado = new ArrayList();
            
            while(res.next()){
                innerEmpleado innEmp = new innerEmpleado();
                
                innEmp.setDireccion(res.getString("direccion"));
                innEmp.setDireccionSucursal("direccion_sucursal");
                innEmp.setEmail(res.getString("email"));
                innEmp.setIdEmpleado(res.getInt("id_empleado"));
                innEmp.setIdSucursal(res.getInt("id_sucursal"));
                innEmp.setNombreEmpleado(res.getString("nombre_empleado"));
                innEmp.setPuesto(res.getString("nombre_puesto"));
                innEmp.setSucursal(res.getString("nombre_sucursal"));
                innEmp.setTelefonoClaro(res.getInt("telefono_claro"));
                innEmp.setTelefonoMovistar(res.getInt("telefono_movistar"));
                lstEmpleado.add(innEmp);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
        return lstEmpleado;
    }
    
   public ArrayList<innerEmpleado> listarPorId(int idEmpleado) throws Exception{
        ArrayList<innerEmpleado> lstEmpleado=null;
        try {
            this.conectar();
            query="select * from dato_empleado where id_empleado=?";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, idEmpleado);
            res = sta.executeQuery();
            lstEmpleado = new ArrayList();
            
            while(res.next()){
                innerEmpleado innEmp = new innerEmpleado();
                
                innEmp.setDireccion(res.getString("direccion"));
                innEmp.setDireccionSucursal("direccion_sucursal");
                innEmp.setEmail(res.getString("email"));
                innEmp.setIdEmpleado(res.getInt("id_empleado"));
                innEmp.setIdSucursal(res.getInt("id_sucursal"));
                innEmp.setNombreEmpleado(res.getString("nombre_empleado"));
                innEmp.setPuesto(res.getString("nombre_puesto"));
                innEmp.setSucursal(res.getString("nombre_sucursal"));
                innEmp.setTelefonoClaro(res.getInt("telefono_claro"));
                innEmp.setTelefonoMovistar(res.getInt("telefono_movistar"));
                lstEmpleado.add(innEmp);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
        
        return lstEmpleado;
    }
    
    public void eliminar(Empleado emp) throws Exception{
        try {
            this.conectar();
            query="delete from empleado where id_empleado=? limit 1";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, emp.getIdEmpleado());
            sta.executeUpdate();
            
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
    
    public void modificar(innerEmpleado emp) throws Exception{
        try {
            this.conectar();
            query = "update empleado set telefono_claro=?, telefono_movistar=?, direccion =?, email=? where id_empleado limit 1";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, emp.getTelefonoClaro());
            sta.setInt(2, emp.getTelefonoMovistar());
            sta.setString(3, emp.getDireccion());
            sta.setString(4, emp.getEmail());
            sta.setInt(5, emp.getIdEmpleado());
            sta.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }
    }
}
