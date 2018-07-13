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
		// kodas
	}

	// singleton laukas

	// singleton metodas
}
