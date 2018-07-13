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
		while(true)
		{
			System.out.println(DB.get().getConnection());
			showMenu();
			switch(getMenuItem())
			{
			case 1 : showClients(); break;
			case 2 : addClient(); break;
			case 3 : checkInRoom(); break;
			case 4 : checkOutRoom(); break;
			case 0 :
				default : System.out.println("Всего доброго!"); return;
			}
			
		}
	}

	void showMenu ()
	{
		System.out.println();
		System.out.println("-----== JAVA HOTEL ==-----");
		System.out.println("1. Показать список клиентов.");
		System.out.println("2. Зарегистрировать нового клиента.");
		System.out.println("3. Прописать клиента в комнату.");
		System.out.println("4. Выписать клиента из отеля.");
		System.out.println("0. Закончить");
	}
	
	int getMenuItem ()
	{
		while(true)
		{
			System.out.println("Выберите пункт меню (0-4): ");
			int num = scanner.nextInt(); scanner.nextLine();
			if(num >= 0 && num < 5)
			{
				return num;
			}
			System.out.println("Пункт меню выбран неверно!");
			
		}
		
		
	}

	void showClients()
	{
		System.out.println("+ Показать список клиентов.");
		for(Client client : Client.getList())
			System.out.println(client);
	}
	
	void addClient()
	{
		System.out.println("++ Зарегистрировать нового клиента.");
		System.out.println("Введите имя клиента: ");
		System.out.println("ОШИБКА. Клиент с таким именем уже зарегистрирован.");
		System.out.println("Клиент зарегистрирован: ");
	}
	
	void checkInRoom ()
	{
		System.out.println("+++ Прописать клиента в комнату.");
		System.out.println("Введите имя клиента: ");
		System.out.println("ОШИБКА. Клиент не найден.");
		System.out.println("ОШИБКА. Этот клиент уже прописан.");
		System.out.println("Введите название комнаты: ");
		System.out.println("ОШИБКА. Комната не найдена.");
		System.out.println("ОШИБКА. В этой комнате нет свободных мест.");
		System.out.println("Клиент прописан.");
	}
	
	void checkOutRoom()
	{
		System.out.println("++++ Выписать клиента из отеля.");
		System.out.println("Введите имя клиента: ");
		System.out.println("ОШИБКА. Клиент не найден.");
		System.out.println("ОШИБКА. Этот клиент не прописан.");
		System.out.println("Клиент выписан, место в комнате освобождено.");
	}
}
