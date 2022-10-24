package uv.fei.domain;

public class Experto{
    private int id;
    private String nombre;
    private String acreditacion;
    public Usuario usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAcreditacion() {
        return acreditacion;
    }

    public void setAcreditacion(String acreditacion) {
        this.acreditacion = acreditacion;
    }



    public Experto() {
        this.id = 0;
        this.nombre = "";
        this.acreditacion = "";
        this.usuario = new Usuario();
    }
}
