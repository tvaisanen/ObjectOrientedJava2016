import java.util.ArrayList;

public class Asunto {
    private double pintaAla;
    private int huoneidenLkm;
    private ArrayList<Asukas> asukkaat = new ArrayList<>();

    public Asunto(){}

    public Asunto(double pintaAla, int huoneidenLkm) {
        this.pintaAla = pintaAla;
        this.huoneidenLkm = huoneidenLkm;
    }

    public double getPintaAla() {
        return pintaAla;
    }

    public void setPintaAla(float pintaAla) {
        this.pintaAla = pintaAla;
    }

    public int getHuoneidenLkm() {
        return huoneidenLkm;
    }

    public void setHuoneidenLkm(int huoneidenLkm) {
        this.huoneidenLkm = huoneidenLkm;
    }

    public ArrayList<Asukas> getAsukkaat() {
        return asukkaat;
    }

    public void setAsukkaat(ArrayList<Asukas> asukkaat) {
        this.asukkaat = asukkaat;
    }

    public void addAsukas(Asukas asukas) {
        asukkaat.add(asukas);
    }

    @Override
    public String toString() {
        return "Asunto {" +
                "pintaAla=" + pintaAla +
                ", huoneidenLkm=" + huoneidenLkm +
                ", asukkaat=" + asukkaat.size() +
                '}';
    }

    public void tulostaAsukasLista(){
        System.out.println("");
        for (Asukas asukas : asukkaat){
            System.out.println("\t-"+asukas.getNimi());
        }
    }

    public void tulostaAsunnonTiedot(){
        System.out.print("pinta-ala: " + pintaAla +
                         ", huoneiden lkm: " + huoneidenLkm +
                         ", asukkaat: " + asukkaat.size());
        tulostaAsukasLista();
    }
}
