import java.util.Scanner;


public class Program 
{
	static Scanner scanner;
	
	public static void main(String[] args) 
	{
		scanner = new Scanner (System.in);
		Program program = new Program ();
		program.start();	
	}
	
	void start ()
	{
		System.out.println(DB.get().getConnection());
		while(true)
		{
			showMenu();
			switch(getMenuItem())
			{
			case 1 : showClients(); break;
			case 2 : addClient(); break;
			case 3 : checkInRoom(); break;
			case 4 : checkOutRoom(); break;
			case 0 : 
				default : System.out.println("Viso gero!"); return;
			}
			
		}
	}

	void showMenu ()
	{
		System.out.println();
		System.out.println("--------== JAVA HOTEL ==--------");
		System.out.println("1. Peržiureti klientų sąrašą.");
		System.out.println("2. Užregistruoti naują klientą.");
		System.out.println("3. Rezervuoti kambarį klientui.");
		System.out.println("4. Išleisti klientą iš kambario.");
		System.out.println("0. Išeiti");
	}
	
	int getMenuItem ()
	{
		System.out.println("Pasirinkite meniu punktą (0-4): ");
		int num = scanner.nextInt(); scanner.nextLine();
		if(num >= 0 && num < 5)
		{
			return num;
		}
		System.out.println("Meniu punktas pasirinktas neteisingai!");
		return getMenuItem();
	}

	void showClients()
	{
		System.out.println("+ Peržiureti klientų sąrašą.");
		for (Client client : Client.getList())
			System.out.println(client);
	}
	
	void addClient()
	{
		System.out.println("++ Užregistruoti naują klientą.");
		System.out.println("Įveskite kliento vardą: ");
		String clientName = scanner.nextLine();
		
		if(Client.find(clientName) != null)
		{
			System.out.println("KLAIDA. Klientas su tokiu vardu jau yra.");
			return;
		}
		Client client = new Client(clientName);
		client.add();
		System.out.println("Klientas užregistruotas:");
	}
	
	void checkInRoom ()
	{
		System.out.println("+++ Rezervuoti kambarį klientui.");
		System.out.println("Įveskite kliento vardą: ");
		String clientName = scanner.nextLine();
		Client client = Client.find(clientName);
		if(client == null)
		{
			System.out.println("KLAIDA. Klientas nerastas.");
			return;
		}
		if (client.room_id > 0)
		{
			System.out.println("KLAIDA. Šis klientas jau apsigyvendintas");
			return;
		}
		
		System.out.println("Įveskite kambario pavadinimą: ");
		String roomName = scanner.nextLine();
		Room room = Room.find(roomName);
		if(room == null)
		{
			System.out.println("KLAIDA. Kambaris nerastas.");
			return;
		}
		
		if(room.getUsedBeds() > room.beds)
		{
			System.out.println("KLAIDA. Šis kambaris neturi laisvų vietų.");
			return;
		}
		client.room_id = client.id;
		client.updateRoomId();
		System.out.println("Klientas apsigyvendintas.");
	}
	
	void checkOutRoom()
	{
		System.out.println("++++ Išleisti klientą iš kambario.");
		System.out.println("Įveskite kliento vardą: ");
		String clientName = scanner.nextLine();
		Client client = Client.find(clientName);
		if(client == null)
		{
			System.out.println("KLAIDA. Klientas nerastas.");
			return;
		}
		if(client.room_id == 0)
		{
			System.out.println("Šis klientas jau išvykė");
			return;
		}
		
		client.room_id = 0;
		client.updateRoomId();
		System.out.println("Klientas išleistas, vietą atlaisvintą.");
	}
}
