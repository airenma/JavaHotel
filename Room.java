import java.sql.*;
/**
 * 
 * @author by Andrej Gladkov
 *
 */

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
		this(0, name, 0);
	}
	
	public static Room find (String name)
	{
		Room room = null;
		try{
			String query = "SELECT id, name, beds " +
							" FROM room " +
							" WHERE name = ? ";
			PreparedStatement ps = DB.get().getConnection().prepareStatement(query);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				int id = rs.getInt("id");
				name = rs.getString("name");
				int beds = rs.getInt("beds");
				room = new Room(id, name, beds);
				
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return room;	
	}
	
	public int getUsedBeds ()
	{
		try{
			String query = "SELECT count(room_id) " +
							" FROM client " +
							" WHERE id = ? ";
			PreparedStatement ps = DB.get().getConnection().prepareStatement(query, 1);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
				
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
	
}