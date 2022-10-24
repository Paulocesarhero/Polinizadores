package uv.fei.bussinesslogic;

import uv.fei.dataaccess.ConexionBD;
import uv.fei.domain.Experto;

import java.sql.*;

public class ExpertoDAO implements IExpertoDAO{
    @Override
    public boolean agregarExperto(Experto experto) throws SQLException {
        return true;

    }
}
