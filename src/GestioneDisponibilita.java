import java.util.LinkedList;


public class GestioneDisponibilita{
	
	private static LinkedList<Unita> disponibili = new LinkedList<Unita>();

	public GestioneDisponibilita() {
		
		Unita u = new Appartamento();
		disponibili.add(u);
		u = new Appartamento();
		disponibili.add(u);
		u = new Campeggio();
		disponibili.add(u);

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
	
	
	
	//public void aggiungiCasa();
	
	//public void aggiungiAppartamento();
	
	//public void aggiungiCampeggio();


}
