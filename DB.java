import java.sql.*;

public class DB 
{
	public final String CONNECTS = "jdbc:mysql://localhost/HOTEL?useSSL=false";
	public final String USERNAME = "root";
	public final String PASSWORD = "123";
	
	private Connection connection;
	
	public Connection getConnection ()
	{
		return connection;
	}

	private DB ()
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.getConnection(CONNECTS, USERNAME, PASSWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static DB instance = null;
	
	public static DB get()
	{
		if(instance == null)
			{
			instance = new DB();
			}
		return instance;
		
	}
}
