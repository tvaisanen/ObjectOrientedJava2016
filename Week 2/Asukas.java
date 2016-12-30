

public class Asukas {
	private Input in;
	private String nimi;
	private String syntymaAika;
	
	public Asukas(String nimi_, String syntymaAika_){
		this.nimi = nimi_;
		this.syntymaAika = syntymaAika_;
	}

	private void setNimi(String nimi_) {
		this.nimi = nimi_;
	}

	private void setSyntymaAika(String syntymaAika_) {
		this.syntymaAika = syntymaAika_;
	}
	
	public String getNimi(){
		return this.nimi;
	}
	
	public String getSyntymaAika(){
		return this.syntymaAika;
	}
	
	public void tulostaAsukkaanTiedot(){
		System.out.println("-------------------------------");
		System.out.println(this.getNimi());
		System.out.println(this.getSyntymaAika());
		System.out.println("-------------------------------");
	}
}
