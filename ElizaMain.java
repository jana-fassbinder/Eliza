package eliza2;
import java.util.Scanner; //Scanner importieren


public class ElizaMain 
{

	// Array für die Begriffe
	private static int AnzahlBegriffe = 8;
	private static Begriff [] Begriffe = new Begriff[AnzahlBegriffe]; 

	// Array für die Alternativen
	private static int AnzahlAlternativen = 3;
	private static String[] Alternative = new String[AnzahlAlternativen];

	// Array für die Oberbegriffe
	private static int nichts = -1;
	private static int familie = 0;
	private static int schule = 1;
	private static int bösebegriffe = 2;

	private static int AnzahlOberbegriffe = 3;
	private static String[] Oberbegriffe = new String[AnzahlOberbegriffe];

	//
	// Initialisiere Begriffe
	//
	public static void setBegriffe()
	{

		Begriffe[0] = new Begriff("vater", familie, 
				"Erzähl mir mehr von deinem Vater!",
				"Welche Probleme hast du mit deinem Vater?");
		Begriffe[1] = new Begriff("mutter", familie, 
				"Erzähl mir mehr von deiner Mutter!",
				"Welche Probleme hast du mit deiner Mutter?");
		Begriffe[2] = new Begriff("lehrer", schule, 
				"Erzähl mir mehr von deinem Lehrer!",
				"Welche Probleme hast du mit deinem Lehrer?");
		Begriffe[3] = new Begriff("freund", nichts,
				"Erzähl mir mehr von deinem Freund!",
				"Welche Problmee hast du mit deinem Freund?");
		Begriffe[4] = new Begriff("freundin", nichts,
				"Erzähl mir mehr von deinem Freundin!",
				"Welche Problme hast du mit deiner Freundin?");
		Begriffe[5] = new Begriff("arsch", bösebegriffe,
				"Erzähl mir mehr!",
				"Wieso benutzt du dieses Wort?");
		Begriffe[6] = new Begriff("probleme", nichts,
				"Erzähl mir mehr über deine Probleme!",
				"Welche Probleme hast du?");
		Begriffe[7] = new Begriff("angst", nichts,
				"Erzähl mir mehr über deine Angst!",
				"Wieso hast du Angst?");


		Alternative[0] = "Ich habe Dich nicht verstanden.";
		Alternative[1] = "Erzähl mir mehr.";
		Alternative[2] = "Ich denke, du hast ein Problem mit deinem Vater.";


		Oberbegriffe[0]= "Erzähl mir mehr von deiner Familie!";
		Oberbegriffe[1]= "Welche Probleme hast du in der Schule?";
		Oberbegriffe[2]= "Bitte beleidige mich nicht! Ich mag diese Wörter nicht!";


	}


	//
	// Main
	// 

	public static void main(String[] args) 
	{


		setBegriffe();
		Scanner myObj = new Scanner(System.in); 
		System.out.println("Hallo, ich bin Eliza. Was kann ich für dich tun?"); 


		String response = "";

		// Loop Input

		while (!response.toLowerCase().contains("ende"))
		{		

			//
			// Input des Fragestellers
			//
			response = myObj.nextLine();           // Read user input
			response = response.toLowerCase();


			//
			// Generieren der Antwort
			//
			String answer = "";
			int i = 0;
			int randomnum;

			//
			// 0. Generiere Antwort zum Schluss des Gesprächs     
			//

			if (response.toLowerCase().contains("ende"))
			{
				answer = "Bis zur nächsten Therapiestunde!";
			}


			//
			// 1. Generiere Antwort aus komplexeren Abfragen      
			//

			if (!answer.equals("")) 
			{
				if (response.contains("hilfe") && (response.contains("benötige")|| response.contains("brauche")))
				{
					answer = "Warum benötigst du Hilfe? Kannst du mir mehr von deinen Problemen erzählen?";
				}
				else if (response.contains("Probleme") && (response.contains("habe")))
				{
					answer = "Warum hast du Probleme? Erzähl mir mehr davon!";
				}
			}

			//
			// 2. Generiere Antwort aus der Klasse Begriff
			//
			while (answer.equals("") && i < AnzahlBegriffe)
			{
				if (response.contains(Begriffe[i].getName()))
				{
					randomnum = random.myrandom(1);

					//
					// Benutze Oberbegiffe
					//
					if (Begriffe[i].getOberbegriff() != nichts && randomnum == 0)
					{    		   
						answer = Oberbegriffe[Begriffe[i].getOberbegriff()];
					}
					//
					// Benutze Begiffe
					//
					else
					{			
						randomnum = random.myrandom(1);
						answer = Begriffe[i].getAntwort(randomnum);
					}

				}

				i++;

			}

			//
			// 3. Alternative Antwort
			//

			if (answer.equals(""))
			{
				randomnum = random.myrandom(2);
				answer = Alternative[randomnum];


			}

			//
			// Antwort ausgeben
			//
			System.out.println(answer);

		}





	}

}






