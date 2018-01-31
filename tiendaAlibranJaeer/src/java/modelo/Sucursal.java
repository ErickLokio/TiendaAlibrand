package modelo;

/**
 * @author Walter
 */
public class Sucursal {
    private int idSucursal=0;
    private String sucursal=null;
    private String direccion=null;
    private int telefono_claro=0;
    private int telefono_movistar=0;
    private int id_empleado =0;
    private String email=null;

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono_claro() {
        return telefono_claro;
    }

    public void setTelefono_claro(int telefono_claro) {
        this.telefono_claro = telefono_claro;
    }

    public int getTelefono_movistar() {
        return telefono_movistar;
    }

    public void setTelefono_movistar(int telefono_movistar) {
        this.telefono_movistar = telefono_movistar;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }
    
    
    
    
}
