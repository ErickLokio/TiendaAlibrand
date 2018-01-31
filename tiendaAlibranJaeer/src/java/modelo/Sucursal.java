package modelo;

/**
 * @author Walter
 */
public class Sucursal {
    private int idSucursal=0;
    private String sucursal=null;
    private String direccion=null;
    private int telefono=0;
    private int idCompania =0;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(int idCompania) {
        this.idCompania = idCompania;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
