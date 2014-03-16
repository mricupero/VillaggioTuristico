import java.util.Random;


public abstract class Unita {

	private int rif;
	private boolean prenotato;

	public Unita() {
		super();
		this.rif = new Random().nextInt(100);
		this.prenotato=false;
	}

	public int getRif() {
		return rif;
	}

	public void setRif(int rif) {
		this.rif = rif;
	}

	public boolean isPrenotato() {
		return prenotato;
	}

	public void setPrenotato(boolean prenotato) {
		this.prenotato = prenotato;
	}

	public abstract float getPrezzo();

	public abstract void setPrezzo(float prezzoUnita);

	public abstract String getTipo();

	public abstract int getNumLocali();

	
	
	
}
