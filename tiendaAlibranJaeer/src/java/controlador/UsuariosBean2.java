package controlador;

import dao.UsuarioDAO2;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Usuarios;
import java.util.ArrayList;

/**
 *
 * @author erick osoy
 */
@ManagedBean
@ViewScoped

public class UsuariosBean2 {
    private Usuarios Ingreso = new Usuarios();
    private ArrayList<Usuarios> lstUsuarios = new ArrayList<>();

    public Usuarios getIngreso() {
        return Ingreso;
    }

    public void setIngreso(Usuarios Ingreso) {
        this.Ingreso = Ingreso;
    }

    public ArrayList<Usuarios> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(ArrayList<Usuarios> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }
    
    
    
    public void Limpiar(){
        Ingreso.setId_usuario(0);
        Ingreso.setId_puesto(0);
        Ingreso.setNombre("");
        Ingreso.setContraseña("");
    }
    
    
    public void insertar(){
        UsuarioDAO2 dao;
        
        try{
            dao = new UsuarioDAO2();
            dao.GuardarUsuario(Ingreso);
            this.listar33();
            this.Limpiar();
        }catch(Exception e){
            System.out.println("ERROR INGRESO Usuario BEAN  --BEAN" +e);
        }
    }
    
    
    
    public void listar33(){
        UsuarioDAO2 sucDao = new UsuarioDAO2();
        try {
           lstUsuarios = sucDao.listaUsuario();
            
        } catch (Exception e) {
            System.out.println("Error al listar en Usuario bean");
        }
    }
    
    
    
    public void modificar(Usuarios usu){
        UsuarioDAO2 dao;
        
        try{
            dao = new UsuarioDAO2();
            dao.modificar(usu);
            this.listar33();
        }catch(Exception e){
            System.out.println("ERROR MODIFICAR Usuario BEAN -- Bean" +e);
        }
    }
    
    
    public void Eliminar(Usuarios usu){
        UsuarioDAO2 dao;
        
        try{
            dao = new UsuarioDAO2();
            dao.eliminar(usu);
            this.listar33();
        }catch(Exception e){
            System.out.println("ERROR ELIMINAR Usuario BEAN  -- BEAN" +e);
        }
    }
    
    public void leerID(Usuarios usu){
        UsuarioDAO2 dao;
        Usuarios temp;
        
        try{
            dao = new UsuarioDAO2();
            temp = dao.leerID(usu);
            
            if(temp != null){
                this.Ingreso = temp;
            }
        }catch(Exception e){
            System.out.println("ERROR BUSCAR Usuario BEAN --BEAN" +e);
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
}
