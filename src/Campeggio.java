import java.util.Random;


public class Campeggio extends Unita {

	private static final String tipo="CAMPEGGIO";
	private int prezzo;
	
	public Campeggio() {
		super();
		this.prezzo = new Random().nextInt((500 - 100) + 1) + 100;
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

	@Override
	public int getNumLocali() {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
	

}
