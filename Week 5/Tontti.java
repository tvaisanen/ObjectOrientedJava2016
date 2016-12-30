
public class Tontti {
	private String nimi;
	private String osoite;
	private double pintaAla;
	private Rakennus rakennus = null;
	
	public Tontti(String nimi_, String osoite_, double pintaAla_){
		this.nimi  = nimi_;
		this.osoite = osoite_;
		this.pintaAla = pintaAla_;
		this.rakennus = null;
		System.out.println("-------------------------------");
		System.out.println("Tontti \"" + this.nimi + "\" luotu.");
	}
	
	public void tulostaTontinTiedot(){
		System.out.println("Tontin tiedot:");
		System.out.println("-------------------------------");
		System.out.println("Tontti:\t\t"  + this.getNimi());
		System.out.println("Osoite: \t"  + this.getOsoite());
		System.out.println("Pinta-ala:\t" + this.getPintaAla());
		System.out.println("-------------------------------");
		if (hasRakennus()) {
			getRakennus().tulostaRakennuksenTiedot();
		}
	}
	
	public void setNimi(String nimi_) {
		this.nimi  = nimi_;
	}
	
	public String getNimi() {
		return this.nimi;
	}
	
	public void setPintaAla(double pintaAla_) {
		this.pintaAla = pintaAla_;
	}

	public double getPintaAla() {
		return this.pintaAla;
	}
	
	public void setSijainti(String osoite_) {
		this.osoite = osoite_;
	}

	public String getOsoite() {
		return this.osoite;
	}
	
	public boolean hasRakennus(){
		if (this.rakennus != null) {
			return true;
		} 
		else {
			return false;
		}
	}
	public void setRakennus(Rakennus rakennus_){
		if (this.rakennus == null){
			this.rakennus = rakennus_;
		} 
		else {
			System.out.println("Rakennusta ei lisätty koska tontilla on jo rakennus!");
		}	
	}
	
	public Rakennus getRakennus(){
		return this.rakennus;
	}
}
