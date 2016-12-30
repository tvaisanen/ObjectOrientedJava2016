
public class StandingSubscription extends Subscription {
	
	private int alennusprosentti = 0;
	private final int tilauksen_kesto = 12;
	
	public StandingSubscription(){
		super();
	}
	
	public StandingSubscription(int alennusprosentti){
		super();
		this.alennusprosentti = alennusprosentti;
	}
	
	public void printInvoice(){
		System.out.println("Tilauksen tiedot:");
		System.out.println("tilaaja: " + this.getTilaajan_nimi());
		System.out.println("osoite: " + this.getToimitusosoite());
		System.out.println("lehti: " + this.getLehden_nimi());
		System.out.println("hinta/kk: " + this.getKuukausihinta()+"€");
		System.out.println("hinta alennuksella: " + this.getKuukausihinta()*(1-(0.01*alennusprosentti))+"€");
		System.out.println("alennus %: " + this.getAlennusprosentti());
		System.out.println("tilauksen kesto: " + this.getTilauksen_kesto() + "\n");
	}

	public int getAlennusprosentti() {
		return alennusprosentti;
	}

	public void setAlennusprosentti(int alennusprosentti) {
		this.alennusprosentti = alennusprosentti;
	}

	public int getTilauksen_kesto() {
		return tilauksen_kesto;
	}	
	
}
