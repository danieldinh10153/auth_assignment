package model.dataccess;

public class ConnectionFactory {
	public DataBaseConnection getConnection(String dataBase) {
		if(dataBase == null) {
			return null;
		}
		//write two if statements for the database to "generate database
		//connections objects for different databases" -from instructions
		//so somehow check which one it wants from?
		//
		if(dataBase.equalsIgnoreCase("MYSQL")){ //example in factory design lect 11b
			return new MySqlConnection();
		}
		
		if(dataBase.equalsIgnoreCase("POSTGRES")) {
			return new PostgresConnection();
		}
		
		return null;
	}
}
