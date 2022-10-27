package uv.fei.domain;

public class Singleton {
    private static Singleton login;
    private Usuario user;

    private Singleton(Usuario user) {
        this.user = user;
    }

    public static void setLogin(Usuario user) {
        if (login == null) {
            login  = new Singleton(user);
        }
    }

    public static String getUserName(){
        return login.user.getNombre();
    }

    public static String getId(){
        return login.user.getId();
    }

}
