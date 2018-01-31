package modelo;

/**
 * @author Walter
 */

public class Cliente {
    private String nombreCliente=null;
    private int idCliente=0;
    private int noRut=0;
    private String direccion=null;
    private int telefonoMovistar = 0;
    private String email=null;
    private int telefonoClaro=0;

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getNoRut() {
        return noRut;
    }

    public void setNoRut(int noRut) {
        this.noRut = noRut;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefonoMovistar() {
        return telefonoMovistar;
    }

    public void setTelefonoMovistar(int telefonoMovistar) {
        this.telefonoMovistar = telefonoMovistar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefonoClaro() {
        return telefonoClaro;
    }

    public void setTelefonoClaro(int telefonoClaro) {
        this.telefonoClaro = telefonoClaro;
    }
    
    
}
