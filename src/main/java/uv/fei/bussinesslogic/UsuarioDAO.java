package uv.fei.bussinesslogic;

import uv.fei.dataaccess.ConexionBD;
import uv.fei.domain.Usuario;

import java.sql.*;

public class UsuarioDAO implements IUsuarioDAO{
    @Override
    public int agregarUsuario(Usuario usuario) throws SQLException {
        //agregar usuario
        ConexionBD conexionBD = new ConexionBD();
        int idUsuario;
        String query = "INSERT INTO usuario(nombre, contrasenia) VALUES (?, MD5(?))";
        try (Connection connection =  conexionBD.openConnection()){
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getContrasenia());
            int executeUpdate = statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(executeUpdate == 0){
                throw new SQLException("Error al agregar un usuario");
            }else {
                resultSet.next();
                idUsuario = resultSet.getInt(1);
            }
        }finally {
            conexionBD.closeConnection();
        }
        return idUsuario;
    }
}
