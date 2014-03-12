import java.util.Random;


public class Appartamento extends Unita {
	
	private static final String tipo="APPARTAMENTO";
	private int numLocali;
	private int prezzo;
	//private int numPersone;
	//private boolean cucina;
	//private boolean biancheria;
	
	public Appartamento( ) {
		super();
		this.numLocali = new Random().nextInt((4 - 2) + 1) + 2; //range da 2 a 4
		this.prezzo = new Random().nextInt((500 - 100) + 1) + 100;
		//this.numPersone = numPersone;
		//this.cucina = cucina;
		//this.biancheria = biancheria;
	}

	public int getNumLocali() {
		return numLocali;
	}

	public void setNumLocali(int numLocali) {
		this.numLocali = numLocali;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public String getTipo() {
		return tipo;
	}
	
	

	

}
