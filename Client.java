import java.util.ArrayList;
import java.sql.*;

public class Client 
{
	public int id;
	public String name;
	public int room_id;
	
	public Client (int id, String name, int room_id)
	{
		this.id = id;
		this.name = name;
		this.room_id = room_id;
	}
	
	public Client (String name)
	{
		this(0, name, 0);
	}
	
	@Override
	public String toString()
	{
		//
		if (room_id == 0)
		{
			return "Klientas Nr. "  
					+ id 
					+ ":\t\t" 
						+ name ;
						
						
		}
		else
		return "Klientas Nr. "  
				+ id 
				+ ":\t\t" 
					+ name 
					+ "\t\tKambarys #"
					+ room_id;
	}
	
	public static ArrayList<Client> getList() 
	{
		ArrayList<Client> list = new ArrayList<>();
		
		
		try {
			String query = "SELECT id, name, room_id " +
					" FROM client " +
					" ORDER BY room_id, name";
			PreparedStatement ps = DB.get().getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int room_id = rs.getInt("room_id");
				list.add(new Client(id, name, room_id));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public static Client find (String name)
	{
		Client client = null;
		try {
			String query = "select id, name, room_id "
					+ " from client "
					+ " where name = ?";
			PreparedStatement ps = DB.get().getConnection().prepareStatement(query);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				int id = rs.getInt("id");
				name = rs.getString("name");
				int room_id = rs.getInt("room_id");
				client = new Client(id, name, room_id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return client;		
	}

	public void add ()
	{
		
		try {
			String query = "INSERT INTO client(name)" +
					"VALUES (?) ";
			PreparedStatement ps = DB.get().getConnection().prepareStatement(query, 1);
			ps.setString(1,  name);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next())
				{
				id = rs.getInt(1);
				}
			else id = 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateRoomId ()
	{
		//
	}	
}
