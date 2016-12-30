

public class Asukas {
	private String nimi;

	public Asukas(String nimi_){
		this.nimi = nimi_;
	}

	private void setNimi(String nimi_) {
		this.nimi = nimi_;
	}

	public String getNimi(){
		return this.nimi;
	}

	@Override
	public String toString() {
		return "Asukas{" +
				"nimi='" + nimi + '\'' +
				'}';
	}



}
