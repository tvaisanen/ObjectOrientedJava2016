import java.util.ArrayList;

public class Rakennus {
	private double rakennuksenPintaAla;
	private int asuntojenLkm;
	private String asunnonTyyppi; // kerros-, rivi- tai omakotitalo
    private ArrayList<Asunto> asunnot = new ArrayList<Asunto>();

    Rakennus(){}

	public Rakennus(double rakennuksenPintaAla_, int asuntojenLkm_, String tyyppi_) {
		this.rakennuksenPintaAla = rakennuksenPintaAla_;
		this.asuntojenLkm = asuntojenLkm_;
        this.asunnonTyyppi = tyyppi_;
	}

    public double getRakennuksenPintaAla() {
        return rakennuksenPintaAla;
    }

    public void setRakennuksenPintaAla(double rakennuksenPintaAla) {
        this.rakennuksenPintaAla = rakennuksenPintaAla;
    }

    public int getAsuntojenLkm() {
        return asuntojenLkm;
    }

    public void setAsuntojenLkm(int asuntojenLkm) {
        this.asuntojenLkm = asuntojenLkm;
    }

    public String getAsunnonTyyppi() {
        return asunnonTyyppi;
    }

    public void setTyyppi(String tyyppi) {
        this.asunnonTyyppi = tyyppi;
    }

    public void tulostaRakennuksenTiedot(){
		System.out.println("Rakennuksen tiedot:");
		System.out.println("-------------------------------");
		System.out.println("Pinta-ala:\t"     + this.getRakennuksenPintaAla());
		System.out.println("Huoneiden lkm:\t"  + this.getAsuntojenLkm());
		if (this.hasAsunto() == false){
			System.out.println("Rakennukselle ei ole määritelty asuntoja.");
		} else {
			System.out.println("Asuntojen lkm:\t" + this.asunnot.size());
			System.out.println("Asunnot: ");
			tulostaAsuntoLista();
		}
		System.out.println("-------------------------------");
	}

	public boolean lisaaAsunto(Asunto asunto_){
		boolean tilaaAsunnoille = false;
        if (asunnot.size() < this.asuntojenLkm) {
            asunnot.add(asunto_);
            System.out.print("Asunnoista määritelty " +
                              asunnot.size() + "/" + this.asuntojenLkm + " ");
			tilaaAsunnoille = true;
        } else if (asunnot.size() >= this.asuntojenLkm){
            System.out.print("Kaikki asunnot määritelty.\n" +
                             "Uutta asuntoa ei voida lisätä.\n");
        }
		return tilaaAsunnoille;
	}

	public ArrayList<Asunto> getAsunnot(){
		return asunnot;
	}

	public boolean hasAsunto(){
		if (this.asunnot != null) {
			return true;
		}
		else {
			return false;
		}
	}

	public void tulostaAsuntoLista(){
		for (int i = 0; i < asunnot.size(); i++){
			System.out.print("\n"+(i+1)+". ");
			asunnot.get(i).tulostaAsunnonTiedot();
		}
	}

	public void tulostaAsukasLista(){
		for (Asunto asunto : asunnot){
			System.out.println(asunto.toString());
			asunto.tulostaAsukasLista();
		}
	}

    @Override
    public String toString() {
        return "Rakennus{" +
                "rakennuksenPintaAla=" + rakennuksenPintaAla +
                ", asuntojenLkm=" + asuntojenLkm +
                ", tyyppi='" + asunnonTyyppi + '\'' +
                ", asunnot=" + asunnot +
                '}';
    }

}
