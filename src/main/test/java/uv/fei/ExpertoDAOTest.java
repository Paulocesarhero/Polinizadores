package uv.fei;
import org.junit.Before;
import org.junit.Test;
import uv.fei.bussinesslogic.ExpertoDAO;
import uv.fei.bussinesslogic.UsuarioDAO;
import uv.fei.domain.Experto;
import uv.fei.domain.Usuario;

import java.sql.SQLException;
public class ExpertoDAOTest {
    private ExpertoDAO expertoDAO;
    private Experto experto;
    private Usuario usuario;
    @Before
    public void init(){
        usuario = new Usuario("Lolopol","H41LHyDra");
        experto = new Experto();
        experto.setAcreditacion("Ingeniero de sofware");
        experto.setNombre("Paulo Cesar Hernandez Rosado");
        experto.usuario = usuario;
        expertoDAO = new ExpertoDAO();
    }
    @Test
    public void agregarUsuario() throws SQLException {
        assert (expertoDAO.agregarExperto(experto));
    }
}
