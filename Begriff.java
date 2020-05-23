package eliza2;

public class Begriff 
{
	//Attribute
	private String name;
	private int oberbegriff; 
	private String [] antwort = new String[2];
	
	
	//
	// Konstruktoren
	//
	
	public Begriff(String begriffname, int oberbegriff)
	{
		name = begriffname;
		this.oberbegriff = oberbegriff;
		
	}
	public Begriff(String begriffname, int  oberbegriff, String antwort1, String antwort2)
	{
		name = begriffname;
		this.oberbegriff = oberbegriff;
		
		// todo Fehler, leere Antworten ersetzen
		antwort[0] = antwort1;
		if (antwort2 != null && (!antwort2.equals(""))) antwort[1] = antwort2; 
		else antwort[1] = antwort1;
						
	}
	
	
	//
	// getter und setter bei privaten Bezeichnern
	//
	public String getName() {
		return name;
	}
	
	public int getOberbegriff() {
		return oberbegriff;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setOberbegriff(int oberbegriff) {
		this.oberbegriff = oberbegriff;
	}
	
	public String getAntwort(int i) {
		return antwort[i];
	}
	
	public void setAntwort(int Position, String newantwort) { 
		antwort[Position] = newantwort;
	}
	
	//Methode Antwort finden
	public String findeAntwort (int i)  
	{
		return antwort [i]; 
	}
	


	
	
	
	
}
