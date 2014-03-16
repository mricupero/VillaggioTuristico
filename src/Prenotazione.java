import java.util.LinkedList;
import java.util.Random;


public class Prenotazione {

	private String nome;
	private String cognome;
	private String cf;														//codice fiscale
	private int codice;
	private int rifUnita;

	private int numPersone;
	private boolean cucina;
	private boolean biancheria;

	private float prezzoTotale;

	public Prenotazione(String nome, String cognome, String cf, int rifUnita, int numPersone, boolean cucina, boolean biancheria) {
		super();	
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
		this.codice= new Random().nextInt((100 - 1) + 1) + 1;
		this.rifUnita = rifUnita;
		this.numPersone=numPersone;
		this.cucina=cucina;
		this.biancheria=biancheria;

		float prezzoTotale=this.calcolaPrezzo(rifUnita);

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public int getRifUnita() {
		return rifUnita;
	}

	public void setRifUnita(int rifUnita) {
		this.rifUnita = rifUnita;
	}

	public void stampa() {
		System.out.println();
		System.out.println("Codice prenotazione: " + this.codice);
		System.out.println("Nome: " + this.nome);
		System.out.println("Cognome: " + this.cognome);
		System.out.println("Codice fiscale: " + this.cf);
		System.out.println("Riferimento unita: " + this.rifUnita);
		System.out.println("Numero persone: " + this.numPersone);
		if (this.cucina == true)
			System.out.println("- supplemento cucina");
		if (this.biancheria == true)
			System.out.println("- supplemento biancheria");

		System.out.println("Prezzo totale: " + this.prezzoTotale);

	}

	public boolean controlloDisponibilita (int rif) {

		Unita u = null;

		for (int i = 0; i < GestioneDisponibilita.getDisponibili().size(); i++) {
			u = GestioneDisponibilita.getDisponibili().get(i);
			if (u.getRif() == rif) {
				if (u.isPrenotato() == false) {
					u.setPrenotato(true);
					return true;
				} else
					return false;
			}
		}

		System.out.println("Unita non presente.");
		return false;
	}

	public void eliminaPrenotazione (LinkedList<Prenotazione> lista, int codice) throws ErrorePrenotazione {

		Unita u = null;
		boolean found = false;

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getCodice() == codice) {

				//Risetto a disponibile l'unità
				for (int j = 0; j < GestioneDisponibilita.getDisponibili().size(); j++) { 
					u = GestioneDisponibilita.getDisponibili().get(j);
					if (u.getRif() == lista.get(i).getRifUnita()) {
						u.setPrenotato(false);
					}
				}
				//fine reset

				lista.remove(i);
				found = true;

			}
		}

		try {
			if (found == false)
				throw new ErrorePrenotazione();
			else
				System.out.println("Prenotazione cancellata.");
		} catch (ErrorePrenotazione e) {}

	}


	public float calcolaPrezzo(int rife) {

		Unita u = null;

		for (int i = 0; i < GestioneDisponibilita.getDisponibili().size(); i++) {
			u = GestioneDisponibilita.getDisponibili().get(i);
			if (u.getRif() == rife) {
				this.prezzoTotale=u.getPrezzo();
				return prezzoTotale;
			}
		}
		return 0;
		
	}
	
	
}
