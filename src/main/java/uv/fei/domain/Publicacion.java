package uv.fei.domain;

public class Publicacion {
    private String name;
    private String email;
    private String password;
    private String rol;
    private String acreditation;
    private String id;

    public String getAcreditation() {
        return acreditation;
    }

    public String getRol() {
        return rol;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setAcreditation(String acreditation) {
        this.acreditation = acreditation;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
