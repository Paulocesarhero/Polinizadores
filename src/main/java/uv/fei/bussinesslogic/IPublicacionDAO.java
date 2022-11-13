package uv.fei.bussinesslogic;

import uv.fei.domain.Publicacion;

import java.sql.SQLException;

public interface IPublicacionDAO {
    public boolean registrarPublicacion(Publicacion publicacion)throws SQLException;
}
