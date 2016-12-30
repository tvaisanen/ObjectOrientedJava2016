
public class RegularSubscription extends Subscription {
	
	private int tilauksen_kesto = 0;
	
	public RegularSubscription(){
		super();
	}
	
	public RegularSubscription(int tilauksen_kesto) {
		super();
		this.tilauksen_kesto = tilauksen_kesto;
	}
	
	public void printInvoice(){
		System.out.println("Tilauksen tiedot:");
		System.out.println("tilaaja: " + this.getTilaajan_nimi());
		System.out.println("osoite: " + this.getToimitusosoite());
		System.out.println("lehti: " + this.getLehden_nimi());
		System.out.println("hinta/kk: " + this.getKuukausihinta() + "€");
		System.out.println("tilauksen kesto: " + this.getTilauksen_kesto() + "\n");
	}
	
	public int getTilauksen_kesto() {
		return tilauksen_kesto;
	}

	public void setTilauksen_kesto(int tilauksen_kesto) {
		this.tilauksen_kesto = tilauksen_kesto;
	}

}
