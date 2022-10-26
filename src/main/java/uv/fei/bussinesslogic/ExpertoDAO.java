package uv.fei.bussinesslogic;

import uv.fei.dataaccess.ConexionBD;
import uv.fei.domain.Experto;

import java.sql.*;

public class ExpertoDAO implements IExpertoDAO{
    @Override
    public boolean agregarExperto(Experto experto) throws SQLException {
        boolean bandera;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        int idUsuario;
        idUsuario = usuarioDAO.agregarUsuario(experto.usuario);
        experto.usuario.setId(idUsuario);
        ConexionBD conexionBD = new ConexionBD();
        String query = "INSERT INTO experto(acreditacion, nombre, idUsuario) VALUES (?, ?, ?)";
        try (Connection connection =  conexionBD.openConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, experto.getAcreditacion());
            statement.setString(2, experto.getNombre());
            statement.setInt(3, experto.usuario.getId());
            int executeUpdate = statement.executeUpdate();
            if(executeUpdate == 0){
                throw new SQLException("Error al agregar experto");
            }else {
                bandera = true;
            }
        }finally {
            conexionBD.closeConnection();
        }
        return bandera;
    }
}
