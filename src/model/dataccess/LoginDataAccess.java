package model.dataccess;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.entities.User;
//what does the asks mean and how to import the connectionFactory into it?

public class LoginDataAccess {

	//singleton code
	private static LoginDataAccess instance;
	String URL = "jdbc:postgresql://localhost:5432/authentication"; //removed final for these strings for constructor class
	String USER = "postgres";
	String PWD = "123";
	
	private LoginDataAccess()
	{
	}
	
	public static LoginDataAccess getInstance()
	{
		if(instance == null) {
			instance = new LoginDataAccess();
		}
		return instance;
	}
	
	//end singleton
	
	public Boolean verifyCredentials() throws ClassNotFoundException, SQLException {
	
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		DataBaseConnection conection = connectionFactory.getConnection("postgres");
		
		final PreparedStatement stmt = conection.getDataBaseConnection().prepareStatement("SELECT * FROM users WHERE username=? and password?");
		
		stmt.setString(1, User.getInstance().getUserName());
		stmt.setString(2, User.getInstance().getPassword());

		ResultSet rs = stmt.executeQuery();

		return rs.next();
		
	}

}



