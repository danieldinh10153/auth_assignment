package model.dataccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection implements DataBaseConnection {

	@Override
	public Connection getDataBaseConnection() throws SQLException {
		String URL = "jdbc:postgresql://localhost:5432/authentication"; //removed final for these strings for constructor class
		String USER = "postgres";
		String PWD = "123";
		
        Connection connection = DriverManager.getConnection(URL, USER, PWD);
         		
        return connection;
	}

}
