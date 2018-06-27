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
		showMenu();
		System.out.println("Viso gero!");
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
		System.out.println("Meniu punktas pasirinktas neteisingai!");
		return 0;
	}

	void showClients()
	{
		System.out.println("+ Peržiureti klientų sąrašą.");
	}
	
	void addClient()
	{
		System.out.println("++ Užregistruoti naują klientą.");
		System.out.println("Įveskite kliento vardą: ");
		System.out.println("KLAIDA. Klientas su tokiu vardu jau yra.");
		System.out.println("Klientas užregistruotas:");
	}
	
	void checkInRoom ()
	{
		System.out.println("+++ Rezervuoti kambarį klientui.");
		System.out.println("Įveskite kliento vardą: ");
		System.out.println("KLAIDA. Klientas nerastas.");
		System.out.println("KLAIDA. Šis klientas jau apsigyvendintas");
		System.out.println("Įveskite kambario pavadinimą: ");
		System.out.println("KLAIDA. Kambaris nerastas.");
		System.out.println("KLAIDA. Šis kambaris neturi laisvų vietų.");
		System.out.println("Klientas apsigyvendintas.");
	}
	
	void checkOutRoom()
	{
		System.out.println("++++ Išleisti klientą iš kambario.");
		System.out.println("Įveskite kliento vardą: ");
		System.out.println("KLAIDA. Klientas nerastas.");
		System.out.println("Šis klientas jau išvykė");
		System.out.println("Klientas išleistas, vietą atlaisvintą.");
	}
}
