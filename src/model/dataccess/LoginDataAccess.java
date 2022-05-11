package model.dataccess;
import java.sql.Connection;
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
	
	private LoginDataAccess(String URL, String USER, String PWD)
	{
		this.URL = URL;
		this.USER = USER;
		this.PWD = PWD;
	}
	
	public static LoginDataAccess getInstance(String URL, String USER, String PWD)
	{
		if(instance == null) {
			instance = new LoginDataAccess(URL, USER, PWD);
		}
		return instance;
	}
	
	public class DemoLoginDataAccess{ //in example, it said to put this outside??
		public static void main(String[] args) throws ClassNotFoundException, SQLException
		{
//			LoginDataAccess lda = LoginDataAccess.getInstance("jdbc:postgresql://localhost:5432/authentication", "postgres", "123");
//			System.out.println(lda.verifyCredentials());
			ConnectionFactory cf = new ConnectionFactory();
			
			DataBaseConnection my_sql = cf.getConnection("MYSQL");
			my_sql.getDataBaseConnection();
			
			DataBaseConnection post_gres = cf.getConnection("POSTGRES");
			post_gres.getDataBaseConnection();
			
		}	
	}
	//end singleton
	
	public Boolean verifyCredentials() throws ClassNotFoundException, SQLException {

//		final String URL = "jdbc:postgresql://localhost:5432/authentication";
//
//		final String USER = "postgres";
//
//		final String PWD = "123";
//
//		Class.forName("org.postgresql.Driver");
//		Connection conection = DriverManager.getConnection(URL, USER, PWD);
//
//		final PreparedStatement stmt = conection.prepareStatement("SELECT * FROM users WHERE username=? and password=?");
		
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		DataBaseConnection conection = connectionFactory.getConnection("postgres");
		
		final PreparedStatement stmt = conection.getDataBaseConnection().prepareStatement("SELECT * FROM users WHERE username=? and password?");
		
		stmt.setString(1, User.getInstance().getUserName());
		stmt.setString(2, User.getInstance().getPassword());

		ResultSet rs = stmt.executeQuery();

		return rs.next();
		
	}

}



