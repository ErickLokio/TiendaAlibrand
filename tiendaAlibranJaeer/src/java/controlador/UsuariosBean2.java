package controlador;

import dao.UsuarioDAO2;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Usuarios;

/**
 *
 * @author erick osoy
 */

@ManagedBean
@ViewScoped
public class UsuariosBean2 {
    private Usuarios usu = new Usuarios();
    private List<Usuarios> lstUsuarios = new ArrayList();

    public Usuarios getUsu() {
        return usu;
    }

    public void setUsu(Usuarios usu) {
        this.usu = usu;
    }

    public List<Usuarios> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(List<Usuarios> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }
    
    
    public void Limpiar(){
        usu.setId_usuario(0);
        usu.setIdEmpleado(0);
        usu.setNombre("");
        usu.setContraseña("");
    }
    
    
    public void insertar(){
        UsuarioDAO2 dao;
        
        try{
            dao = new UsuarioDAO2();
            dao.GuardarUsuario(usu);
            this.ListarUsuario();
            this.Limpiar();
        }catch(Exception e){
            System.out.println("ERROR INGRESO USUARIOS BEAN 2 --BEAN" +e);
        }
    }
    
    
    public void ListarUsuario(){
        UsuarioDAO2 dao;
        
        try{
            dao = new UsuarioDAO2();
            lstUsuarios = dao.lista();
        }catch(Exception e){
            System.out.println("ERROR LISTAR USUARIOS DAO 2 --BEAN"+e);
        }
    }
    
    public void modificar(){
        UsuarioDAO2 dao;
        
        try{
            dao = new UsuarioDAO2();
            dao.modificar(usu);
            this.ListarUsuario();
        }catch(Exception e){
            System.out.println("ERROR MODIFICAR USUARIO BEAN 2-- Bean" +e);
        }
    }
    
    
    public void Eliminar(Usuarios usu){
        UsuarioDAO2 dao;
        
        try{
            dao = new UsuarioDAO2();
            dao.eliminar(usu);
            this.ListarUsuario();
        }catch(Exception e){
            System.out.println("ERROR ELIMINAR USUARIOS BEAN 2 -- BEAN" +e);
        }
    }
    
    public void leerID(Usuarios usu){
        UsuarioDAO2 dao;
        Usuarios temp;
        
        try{
            dao = new UsuarioDAO2();
            temp = dao.leerID(usu);
            
            if(temp != null){
                this.usu = temp;
            }
        }catch(Exception e){
            System.out.println("ERROR BUSCAR USUARIO BEAN 2 --BEAN" +e);
        }
        
    }
}
