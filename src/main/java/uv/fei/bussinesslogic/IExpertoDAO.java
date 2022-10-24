package uv.fei.bussinesslogic;

import uv.fei.domain.Experto;

import java.sql.SQLException;

public interface IExpertoDAO {
    public boolean agregarExperto(Experto experto) throws SQLException;

}
