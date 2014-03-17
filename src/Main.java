import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

import org.omg.CORBA.ExceptionList;


public class Main {

	public static void main(String[] args) throws IOException, ErrorePrenotazione {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int scelta=0, rifUnita=0;																//rifUnita è 0!!!
		LinkedList<Prenotazione> lista = new LinkedList<Prenotazione>();
		GestioneDisponibilita mng = new GestioneDisponibilita();
		Prenotazione pr= null;


		do {

			System.out.println();System.out.println();
			System.out.println("---MENU---");
			System.out.println("1: Aggiungi prenotazione.");
			System.out.println("2: Stampa prenotazione.");
			System.out.println("3: Lista disponibilita.");
			System.out.println("4: Elimina prenotazione.");
			System.out.println("5: *** Aggiungi appartamento.");
			System.out.println("6: *** Aggiungi campeggio.");
			System.out.println("0: Esci.");

			try {
				System.out.print("---> ");
				scelta=Integer.parseInt(in.readLine());
			} catch (NumberFormatException e) {

				System.out.println("Carattere non consentito.");
				scelta = 100;													//in questo modo richiedo il valore in input
			}

			switch (scelta) {
			case 0:

				break;

			case 1:
				boolean cucina=false, biancheria=false;

				System.out.println();
				System.out.print("Nome: ");
				String nome = in.readLine();
				System.out.print("Cognome: ");
				String cognome = in.readLine();
				System.out.print("Codice fiscale: ");
				String cf = in.readLine();
				try {
					System.out.print("Codice riferimento casa: ");
					rifUnita = Integer.parseInt(in.readLine());
				} catch (NumberFormatException e) {
					System.out.println("Carattere non consentito.");
				}


				System.out.print("Numero persone presenti: ");
				int numPersone = Integer.parseInt(in.readLine());
				System.out.print("Aggiunta cucina (0-no, 1-si): ");					//NON CHIEDERE SE ISTANZA DI NON APPARTAMENTO
				int temp = Integer.parseInt(in.readLine());
				if (temp == 1)
					cucina = true;
				System.out.print("Aggiunta biancheria (0-no, 1-si): ");
				temp = Integer.parseInt(in.readLine());
				if (temp == 1)
					biancheria = true;



				pr = new Prenotazione(nome, cognome, cf, rifUnita, numPersone, cucina, biancheria);
				boolean ok = pr.controlloDisponibilita(rifUnita);
				if (ok == true) {
					lista.add(pr);
					System.out.println("Prenotazione effettuata.");
				}
				else
					System.out.println("Prenotazione non effettuata.");

				break;

			case 2:
				System.out.println();

				for (int i = 0; i < lista.size(); i++) {
					lista.get(i).stampa();
				}
				break;

			case 3:
				mng.stampaDisponibilita();
				break;

			case 4:
				System.out.println();
				System.out.print("Inserire codice della prenotazione da eliminare: ");
				int codice = Integer.parseInt(in.readLine()); 

				pr.eliminaPrenotazione(lista, codice);
				break;

			case 5:
				GestioneDisponibilita.aggiungiAppartamento();
				break;
				
			case 6:
				GestioneDisponibilita.aggiungiCampeggio();
				break;
				
			default:

				break;
			}

		} while (scelta != 0);

	}

}
