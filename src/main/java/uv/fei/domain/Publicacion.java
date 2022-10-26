package uv.fei.domain;

public class Publicacion {
    private int id;
    private String titulo;
    private String fecha;
    private String descripcion;
    private String referencia;
    public Experto experto;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Publicacion() {
        this.id = 0;
        this.titulo = "";
        this.fecha = "";
        this.descripcion = "";
        this.referencia = "";
        this.experto = new Experto();
    }
}
