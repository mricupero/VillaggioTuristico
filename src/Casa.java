import java.util.LinkedList;
import java.util.Random;


public class Casa extends Unita {

	private static final String tipo="CASA";
	private static LinkedList<Appartamento> listaApp = new LinkedList<Appartamento>();
	private float prezzo;


	public Casa() {
		super();
		//this.prezzo = new Random().nextInt((500 - 100) + 1) + 100;
	}

	public static LinkedList<Appartamento> getListaApp() {
		return listaApp;
	}

	public static void setListaApp(LinkedList<Appartamento> listaApp) {
		Casa.listaApp = listaApp;
	}

	public String getTipo() {
		return tipo;
	}

	@Override
	public int getNumLocali() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public float getPrezzo() {
		return this.prezzo;
	}
	
	@Override
	public void setPrezzo(float prezzoUnita) {
		this.prezzo=prezzoUnita;
		
	}

	
	
	

}
