import java.util.ArrayList;
import java.sql.*;

public class Room 
{
	public int id;
	public String name;
	public int beds;

	public Room (int id, String name, int beds)
	{
		this.id = id;
		this.name = name;
		this.beds = beds;
	}
	
	public Room (String name, int beds)
	{
		this(0, name, beds);
	}
	
	public static Room find (String name)
	{
		//
		return null;
	}
	
	public int getUsedBeds ()
	{
		//
		return 0;
	}
	
}
