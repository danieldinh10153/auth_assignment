package model.business;
import model.dataccess.LoginDataAccess;
import model.entities.User;
import model.entities.MessageException;
import java.sql.SQLException;

public class LoginBusiness {
	private static LoginBusiness instance;
	private String userName;
	private String password;
	
	private LoginBusiness() {
	}
	
	public static LoginBusiness getInstance()
	{
		if (instance == null) {
			instance = new LoginBusiness();
		}
		return instance;
	}
	
	//need getters and setters for these classes?
	public boolean verifyCredentials() throws ClassNotFoundException, SQLException
	{
		
		if(userName.equals("")) {
			throw new MessageException("Username empty");
		}
		else if(password.equals("")) {
			throw new MessageException("Password empty");
		}
		User.getInstance().setUserName(this.userName);
		User.getInstance().setPassword(this.password);
		
		LoginDataAccess lda = LoginDataAccess.getInstance("jdbc:postgresql://localhost:5432/authentication", "postgres", "123");
		
		if(lda.verifyCredentials()) {
			return true;
		}
		else {
			throw new MessageException("Invalid Info");
		}
	
	}
	public void setUserName(String username)
	{
		username = userName;
	}
	public void setPassword(String pass)
	{
		pass = password;
	}
	
}
