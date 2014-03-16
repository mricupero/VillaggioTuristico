import java.util.Random;


public class Campeggio extends Unita {

	private static final String tipo="CAMPEGGIO";
	private float prezzo;

	
	public Campeggio() {
		super();
		//this.prezzo = new Random().nextInt((500 - 100) + 1) + 100;
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
		// TODO Auto-generated method stub
		return this.prezzo;
	}

	@Override
	public void setPrezzo(float prezzoUnita) {
		this.prezzo=prezzoUnita;
		
	}





	
	
	

}
