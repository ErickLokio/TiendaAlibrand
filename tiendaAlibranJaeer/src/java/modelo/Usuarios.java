package modelo;


public class Usuarios{

  private int id_usuario = 0;
  private int id_puesto = 0;
  private String nombre = null;
  private String contraseña = null;
  
  public Usuarios() {
    id_usuario = 0;
    nombre = null;
    contraseña = null;
    this.id_puesto = 0;

  }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    
  public int getId_usuario() {
    return id_usuario;
  }

  public void setId_usuario(int id_usuario) {
    this.id_usuario = id_usuario;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getContraseña() {
    return contraseña;
  }

  public void setContraseña(String contraseña) {
    this.contraseña = contraseña;
  }

 
}
