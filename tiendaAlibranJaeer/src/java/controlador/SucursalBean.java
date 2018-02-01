package controlador;

import dao.SucursalDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Sucursal;
    
/**
 * @author Walter
 */
@ManagedBean
@ViewScoped
public class SucursalBean {
    private Sucursal suc = new Sucursal();
    private ArrayList<Sucursal> lstSucursal = new ArrayList<>();
    private ArrayList<Sucursal> lstSucursal2 = new ArrayList<>();

    public Sucursal getSuc() {
        return suc;
    }

    public void setSuc(Sucursal suc) {
        this.suc = suc;
    }

    public ArrayList<Sucursal> getLstSucursal() {
        return lstSucursal;
    }

    public void setLstSucursal(ArrayList<Sucursal> lstSucursal) {
        this.lstSucursal = lstSucursal;
    }

    public ArrayList<Sucursal> getLstSucursal2() {
        return lstSucursal2;
    }

    public void setLstSucursal2(ArrayList<Sucursal> lstSucursal2) {
        this.lstSucursal2 = lstSucursal2;
    }
    
    
    
    
    
    public void listar(){
        SucursalDao sucDao = new SucursalDao();
        try {
            lstSucursal = sucDao.listar();
            
        } catch (Exception e) {
            System.out.println("Error al listar en sucursal bean");
        }
    }
    
    
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    
    
    public void Limpiar(){
        suc.setIdSucursal(0);
        suc.setSucursal("");
        suc.setDireccion("");
        suc.setTelefono_claro(0);
        suc.setTelefono_movistar(0);
        suc.setId_empleado(0);
        suc.setEmail("");
    }
    
    public void insertar(){
        SucursalDao dao;
        
        try{
            dao = new SucursalDao();
            dao.Guardar(suc);
            this.listar33();
            this.Limpiar();
        }catch(Exception e){
            System.out.println("ERROR INGRESO SUCURSAL BEAN  --BEAN" +e);
        }
    }
    
    
    
    public void listar33(){
        SucursalDao sucDao = new SucursalDao();
        try {
           lstSucursal2 = sucDao.listaSucu();
            
        } catch (Exception e) {
            System.out.println("Error al listar en sucursal bean");
        }
    }
    
    
    
    public void modificar(){
        SucursalDao dao;
        
        try{
            dao = new SucursalDao();
            dao.modificar(suc);
            this.listar33();
        }catch(Exception e){
            System.out.println("ERROR MODIFICAR Sucursal BEAN -- Bean" +e);
        }
    }
    
    
    public void Eliminar(Sucursal su){
        SucursalDao dao;
        
        try{
            dao = new SucursalDao();
            dao.eliminar(su);
            this.listar33();
        }catch(Exception e){
            System.out.println("ERROR ELIMINAR SucursalDao BEAN  -- BEAN" +e);
        }
    }
    
    public void leerID(Sucursal su){
        SucursalDao dao;
        Sucursal temp;
        
        try{
            dao = new SucursalDao();
            temp = dao.leerID(su);
            
            if(temp != null){
                this.suc = temp;
            }
        }catch(Exception e){
            System.out.println("ERROR BUSCAR Sucursal BEAN --BEAN" +e);
        }
        
    }
    
    
    
    
    
}
