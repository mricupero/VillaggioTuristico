import java.util.Random;


public class Appartamento extends Unita {
	
	private static final String tipo="APPARTAMENTO";
	private int numLocali;	
	
	private float prezzo;
	
	public Appartamento( ) {
		super();
		this.numLocali = new Random().nextInt((4 - 2) + 1) + 2; 		//range da 2 a 4
		this.prezzo=200;
	}
	
	public Appartamento(int numLocali, float prezzo ) {
		super();
		this.numLocali = numLocali; 		
		this.prezzo=prezzo;
	}

	public int getNumLocali() {
		return numLocali;
	}

	public void setNumLocali(int numLocali) {
		this.numLocali = numLocali;
	}


	public String getTipo() {
		return tipo;
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
