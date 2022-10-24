package uv.fei;

import org.junit.Before;
import org.junit.Test;
import uv.fei.bussinesslogic.UsuarioDAO;
import uv.fei.domain.Usuario;

import java.sql.SQLException;

public class UsuarioDAOTest {
    private UsuarioDAO usuarioDAO;
    private Usuario usuario;

    @Before
    public void init(){
        usuario = new Usuario("Lolopol", "1223as121wq");
        usuarioDAO = new UsuarioDAO();
    }
    @Test
    public void agregarUsuario() throws SQLException {
        usuarioDAO.agregarUsuario(usuario);
    }
}
