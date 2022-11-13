package uv.fei.domain;

public class Usuario {
    private int id;
    private String nombre;
    private String contrasenia;
    
    private String email;
    private String rol;
    private String acreditacion;

    public String getRol() {
        return rol;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getAcreditacion() {
        return acreditacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAcreditacion(String acreditacion) {
        this.acreditacion = acreditacion;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario() {
        this.id = 0;
        this.nombre = "";
        this.contrasenia = "";
        this.acreditacion="";
        this.email="";
        this.rol="";
    }
}
