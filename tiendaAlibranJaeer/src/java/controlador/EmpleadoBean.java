
package controlador;

import dao.EmpleadoDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Empleado;
import modelo.innerEmpleado;

/**
 * @author Walter
 */
@ManagedBean
@ViewScoped
public class EmpleadoBean {
    private Empleado emp = new Empleado();
    private innerEmpleado innEmpleado = new innerEmpleado();
    private ArrayList<innerEmpleado> lstInnEmpleado = new ArrayList();
    private ArrayList<Empleado> lstEmpleado = new ArrayList();
    
    private ArrayList<Empleado> lstTodoEmpleado = new ArrayList<>();
    
    
    

    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }

    public innerEmpleado getInnEmpleado() {
        return innEmpleado;
    }

    public void setInnEmpleado(innerEmpleado innEmpleado) {
        this.innEmpleado = innEmpleado;
    }

    public ArrayList<innerEmpleado> getLstInnEmpleado() {
        return lstInnEmpleado;
    }

    public void setLstInnEmpleado(ArrayList<innerEmpleado> lstInnEmpleado) {
        this.lstInnEmpleado = lstInnEmpleado;
    }

    public ArrayList<Empleado> getLstEmpleado() {
        return lstEmpleado;
    }

    public void setLstEmpleado(ArrayList<Empleado> lstEmpleado) {
        this.lstEmpleado = lstEmpleado;
    }

    public ArrayList<Empleado> getLstTodoEmpleado() {
        return lstTodoEmpleado;
    }

    public void setLstTodoEmpleado(ArrayList<Empleado> lstTodoEmpleado) {
        this.lstTodoEmpleado = lstTodoEmpleado;
    }
    
    
    
    
    
    public void Limpiar(){
        emp.setIdEmpleado(0);
        emp.setNombreEmplado("");
        emp.setTelefono(0);
        emp.setTelefono2(0);
        emp.setIdPuesto(0);
        emp.setIdSucursal(0);
        emp.setDireccion("");
        emp.setEmail("");
    }
            
    
    
    public void ingresar(){
        EmpleadoDao empDao;
        
        try {
            empDao = new EmpleadoDao();
            empDao.ingresar(emp);
            Limpiar();
        } catch (Exception e) {
            System.out.println("Error al ingresar en el bean");
        }
    }
    
    public void eliminar(Empleado emp2){
        EmpleadoDao empDao;
        
        try {
            empDao = new EmpleadoDao();
            empDao.eliminar(emp2);
        } catch (Exception e) {
            System.out.println("Error al eliminar empleado bean");
        }
    }
    
    public void modificar(innerEmpleado emp2){
        EmpleadoDao empDao;
        try {
            empDao = new EmpleadoDao();
            empDao.modificar(emp2);
        } catch (Exception e) {
        }
    }
    
    public void listar(){
        EmpleadoDao empDao;
        
        try {
            empDao = new EmpleadoDao();
            lstInnEmpleado = empDao.listar();
        } catch (Exception e) {
        }
    }
    
    public void listarPorId(int idEmpleado){
        EmpleadoDao empDao;
        
        try {
            empDao = new EmpleadoDao();
            lstInnEmpleado = empDao.listarPorId(idEmpleado);
        } catch (Exception e) {
            System.err.println("Error al Buscar por id en el bean");
        }
    }
    
    
    
    
        public void listar33(){
        EmpleadoDao sucDao2 = new EmpleadoDao();
        try {
           lstTodoEmpleado = sucDao2.listaEmpleado();
            
        } catch (Exception e) {
            System.out.println("Error al listar en sucursal bean");
        }
    }
        
        
    public void ModificarTodo(Empleado emp){
        EmpleadoDao dao;
        
        try{
            dao = new EmpleadoDao();
            dao.modificarTodo(emp);
        }catch(Exception e){
            
        }
        
    }
        

    
}
