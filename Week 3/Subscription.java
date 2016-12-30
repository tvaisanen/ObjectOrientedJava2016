
public class Subscription {

	private String lehden_nimi = null;
	private String tilaajan_nimi = null;
	private String toimitusosoite = null;
	private double kuukausihinta = 0;
	
	public Subscription(){
		
	}
	
	public Subscription(String lehden_nimi, String tilaajan_nimi, 
						String toimitus_osoite, double kuukausihinta){
		this.lehden_nimi = lehden_nimi;
		this.tilaajan_nimi = tilaajan_nimi;
		this.toimitusosoite = toimitus_osoite;
		this.kuukausihinta = kuukausihinta;
		
	}
	
	
	
	public void printInvoice(){
		System.out.println("tulostetaan tietoja");
	}

	public String getLehden_nimi() {
		return lehden_nimi;
	}

	public void setLehden_nimi(String lehden_nimi) {
		this.lehden_nimi = lehden_nimi;
	}

	public String getTilaajan_nimi() {
		return tilaajan_nimi;
	}

	public void setTilaajan_nimi(String tilaajan_nimi) {
		this.tilaajan_nimi = tilaajan_nimi;
	}

	public String getToimitusosoite() {
		return toimitusosoite;
	}

	public void setToimitusosoite(String toimitusosoite) {
		this.toimitusosoite = toimitusosoite;
	}

	public double getKuukausihinta() {
		return kuukausihinta;
	}

	public void setKuukausihinta(double kuukausihinta) {
		this.kuukausihinta = kuukausihinta;
	}
}
