import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class GestioneDisponibilita{
	
	private static LinkedList<Unita> disponibili = new LinkedList<Unita>();

	public GestioneDisponibilita() throws IOException {
		
		Unita u = new Appartamento();		
		this.disponibili.add(u);
		
		u = new Campeggio();		
		this.disponibili.add(u);

	}
	
	public void stampaDisponibilita() {
				
		Unita app=null;
		
		for (int i = 0; i < disponibili.size(); i++) {				//polimorfismo
			
			if (disponibili.get(i) instanceof Appartamento)
				app = (Appartamento) disponibili.get(i);
			if (disponibili.get(i) instanceof Campeggio)
				app = (Campeggio) disponibili.get(i);
			if (disponibili.get(i) instanceof Casa)
				app = (Casa) disponibili.get(i);
			
			System.out.println();
			System.out.print("Tipo: " + app.getTipo());
			System.out.print(" - Riferimento: " + app.getRif());
			if (!(disponibili.get(i) instanceof Campeggio) && !(disponibili.get(i) instanceof Casa))
				System.out.print(" - Locali: " + app.getNumLocali());
			System.out.print(" - Prezzo: " + app.getPrezzo());
			
			if (app.isPrenotato() == true)
				System.out.print(" - NON DISPONIBILE");
			else
				System.out.print(" - DISPONIBILE");
		}
		
	}


	public static LinkedList<Unita> getDisponibili() {
		return disponibili;
	}

	public static void setDisponibili(LinkedList<Unita> disponibili) {
		GestioneDisponibilita.disponibili = disponibili;
	}
	
	
	
	public static void aggiungiCasa() {			///da fareeeeeeeeeee

	}
	
	public static void aggiungiAppartamento() throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Numero di locali: ");
		int locali = Integer.parseInt(in.readLine());
		System.out.print("Prezzo appartamento: ");
		float prezzo = Integer.parseInt(in.readLine());
		
		Unita u = new Appartamento(locali, prezzo);
		disponibili.add(u);
	}
	
	public static void aggiungiCampeggio() throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Prezzo campeggio: ");
		float prezzo = Integer.parseInt(in.readLine());
		
		Unita u = new Campeggio(prezzo);
		disponibili.add(u);
	}


}
