package uv.fei.bussinesslogic;

import uv.fei.dataaccess.ConexionBD;
import uv.fei.domain.Publicacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublicacionDAO implements IPublicacionDAO{
    @Override
    public List<Publicacion> obtenerPublicaciones() throws SQLException {
        ConexionBD conexionBD = new ConexionBD();
        List<Publicacion> publicaciones = new ArrayList<>();
        try (Connection connection = conexionBD.openConnection()){
            String query = "SELECT * FROM Publicacion";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("Error al obtener las publicaciones");
            }else {
                do {
                    publicaciones.add(getPublicacion(resultSet));
                }while (resultSet.next());
            }
        }catch (SQLException sqlException){
            throw sqlException;
        }
        return publicaciones;
    }

    @Override
    public void actualizarPublicacion(Publicacion publicacion) throws SQLException {
        int idObj = publicacion.getId();
        boolean estadoObj = publicacion.isEstado();
        ConexionBD conexionBD = new ConexionBD();
        try (Connection connection = conexionBD.openConnection()){
            String query = "UPDATE Publicacion set Estado=? WHERE Id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setBoolean(1,estadoObj);
            statement.setInt(2,idObj);
            int resultado = statement.executeUpdate();
            if (resultado < 1){
                throw new SQLException("Error al actualizar la publicacion");
            }
        }catch (SQLException sqlException){
            throw sqlException;
        }
    }

    private Publicacion getPublicacion(ResultSet resultSet) throws SQLException {
        Publicacion publicacion = new Publicacion();
        int id;
        String titulo;
        String fecha;
        String descripcion;
        String referencia;
        boolean estado;
        try {
            id = resultSet.getInt("id");
            titulo = resultSet.getString("titulo");
            fecha = resultSet.getString("fecha");
            descripcion = resultSet.getString("descripcion");
            referencia = resultSet.getString("referencias");
            estado = resultSet.getBoolean("estado");

            publicacion.setId(id);
            publicacion.setTitulo(titulo);
            publicacion.setFecha(fecha);
            publicacion.setDescripcion(descripcion);
            publicacion.setReferencia(referencia);
            publicacion.setEstado(estado);

        } catch (SQLException e) {
            throw e;
        }
        return publicacion;
    }
}
