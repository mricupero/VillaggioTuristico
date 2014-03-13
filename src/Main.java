import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

import org.omg.CORBA.ExceptionList;


public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int scelta=0, rifUnita=0;																//rifUnita è 0!!!
		LinkedList<Prenotazione> lista = new LinkedList<Prenotazione>();
		GestioneDisponibilita mng = new GestioneDisponibilita();


		do {

			System.out.println();System.out.println();
			System.out.println("---MENU--- 2");
			System.out.println("1: Aggiungi prenotazione.");
			System.out.println("2: Stampa prenotazione.");
			System.out.println("3: Lista disponibilita.");
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

				Prenotazione pr = new Prenotazione(nome, cognome, cf, rifUnita);
				boolean ok = pr.controlloDisponibilita(rifUnita);
				if (ok == true)
					lista.add(pr);
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

			default:

				break;
			}

		} while (scelta != 0);

	}

}
