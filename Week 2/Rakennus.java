import java.util.ArrayList;

public class Rakennus {
	private double rakennuksenPintaAla;
	private int huoneidenLkm;
	private ArrayList<Asukas> asukkaat = new ArrayList<Asukas>();
	
	public Rakennus(double rakennuksenPintaAla_, int huoneidenLkm_) {
		this.rakennuksenPintaAla = rakennuksenPintaAla_;
		this.huoneidenLkm = huoneidenLkm_;
	}
	
	public void tulostaRakennuksenTiedot(){
		System.out.println("-------------------------------");
		System.out.println("Pinta-ala:\t"     + this.getRakennuksenPintaAla());
		System.out.println("Huoneiden lkm:\t"  + this.getHuoneidenLkm());
		if (this.hasAsukas() == false){
			System.out.println("Rakennukselle ei ole merkitty asukkaita");
		} else {
			System.out.println("Asukkaiden lkm:\t" + this.asukkaat.size());
			System.out.println("Asukkaat: ");
			tulostaAsukaslista();
		}
		System.out.println("-------------------------------");
	}

	public void setHuoneidenlkm(int huoneidenLkm_){
		this.huoneidenLkm = huoneidenLkm_;
	}
	
	public int getHuoneidenLkm(){
		return this.huoneidenLkm;
	}

	public void setRakennuksenPintaAla(double rakennuksenPintaAla_){
		this.rakennuksenPintaAla = rakennuksenPintaAla_;
	}

	public double getRakennuksenPintaAla(){
		return this.rakennuksenPintaAla;
	}
	
	public void lisaaAsukas(Asukas asukas_){
		asukkaat.add(asukas_);
	}
	
	public ArrayList<Asukas> getAsukkaat(){
		return asukkaat;
	}
	
	public boolean hasAsukas(){
		if (this.asukkaat != null) {
			return true;
		} 
		else {
			return false;
		}
	}

	public void tulostaAsukaslista(){
		for (int i = 0; i < asukkaat.size(); i++){
			System.out.println((i + 1) + ") nimi: " + asukkaat.get(i).getNimi() + ", syntymäaika : " + asukkaat.get(i).getSyntymaAika());
		}
	}
}
