package model.business;

public class LoginBusiness {
	private static LoginBusiness instance;
	private String userName;
	private String password;
	
	private LoginBusiness(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public static LoginBusiness getInstance(String userName, String password)
	{
		if (instance == null) {
			instance = new LoginBusiness(userName, password);
		}
		return instance;
	}
	
	//need getters and setters for these classes?
	public boolean verifyCredentials()
	{
		
	}
	public void setUserName(String username)
	{
		username = userName;
	}
	public void setPassword(String pass)
	{
		pass = password;
	}
	
	public class DemoLoginBusiness{
		public static void main(String[] args) {
			LoginBusiness bus = LoginBusiness.getInstance("dan", "123");
			System.out.println(bus.verifyCredentials());
		}
	}
}
