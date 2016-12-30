
public class Tontti {
	private String nimi;
	private String[] sijainti;
	private double pintaAla;
	private Rakennus rakennus;
	
	public Tontti(String nimi_, String[] sijainti_, double pintaAla_){
		this.nimi  = nimi_;
		this.sijainti = sijainti_;
		this.pintaAla = pintaAla_;
		this.rakennus = null;
		System.out.println("-------------------------------");
		System.out.println("Tontti \"" + this.nimi + "\" luotu.");
	}
	
	public void tulostaTontinTiedot(){
		System.out.println("-------------------------------");
		System.out.println("Tontti:\t\t"  + this.getNimi());
		System.out.println("Sijainti:\tlat: "  + this.getSijainti()[0] + "\n\t\tlon: " + this.getSijainti()[1]);
		System.out.println("Pinta-ala:\t" + this.getPintaAla());
		System.out.println("-------------------------------");
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
	
	public void setSijainti(String[] sijainti_) {
		this.sijainti = sijainti_;
	}

	public String[] getSijainti() {
		return this.sijainti;
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
			System.out.println("Tontilla on jo rakennus!");
		}	
	}
	
	public Rakennus getRakennus(){
		return this.rakennus;
	}
}
