package db;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDataBase {
    ResultSet requestExecute(String sqlRequest) throws SQLException, IOException;
    ResultSet requestExecuteWithReturned(String sqlRequest) throws SQLException, IOException;
    void close() throws SQLException;
    void executeUpdate(String query) throws SQLException, IOException;
}
