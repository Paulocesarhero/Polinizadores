package uv.fei.bussinesslogic;

import uv.fei.dataaccess.ConexionBD;
import uv.fei.domain.Publicacion;

import java.sql.*;

public class PublicacionDAO implements IPublicacionDAO{
    @Override
    public boolean registrarPublicacion(Publicacion publicacion) throws SQLException {
        boolean flag = false;
        ConexionBD conexionBD = new ConexionBD();
        String query = "INSERT INTO publicacion ( `titulo`, `fecha`, `descripcion`, `referencias`, `estado`, `idUsuario`)VALUES (?,?,?,?,?,?)";
        try (Connection connection =  conexionBD.openConnection()){
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, publicacion.getTitulo());
            statement.setString(2, publicacion.getFecha());
            statement.setString(3, publicacion.getDescripcion());
            statement.setString(4, publicacion.getReferencia());
            statement.setBoolean(5, publicacion.isEstado());
            statement.setInt(6, publicacion.getIdUsuario());
            int executeUpdate = statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(executeUpdate == 0){
                throw new SQLException("Error al agregar un usuario");
            }else {
                flag=true;
            }
        }finally {
            conexionBD.closeConnection();
        }
        return flag;
    }
}
