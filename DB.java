import java.sql.*;

public class DB 
{
	public final String CONNECTS = "jdbc:mysql://localhost/HOTEL";
	public final String USERNAME = "root";
	public final String PASSWORD = "";
	
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
