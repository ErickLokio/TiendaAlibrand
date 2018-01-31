
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
    
    public void ingresar(){
        EmpleadoDao empDao;
        
        try {
            empDao = new EmpleadoDao();
            empDao.ingresar(emp);
        } catch (Exception e) {
            System.out.println("Error al ingresar en el bean");
        }
    }
    
    public void eliminar(){
        EmpleadoDao empDao;
        
        try {
            empDao = new EmpleadoDao();
            empDao.eliminar(emp);
        } catch (Exception e) {
            System.out.println("Error al eliminar empleado bean");
        }
    }
    
    public void modificar(){
        EmpleadoDao empDao;
        try {
            empDao = new EmpleadoDao();
            empDao.modificar(innEmpleado);
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
}
