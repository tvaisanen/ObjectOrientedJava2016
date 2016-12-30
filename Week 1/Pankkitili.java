import java.util.Scanner;

public class Pankkitili {
	
		private String tilinumero, omistaja;
		private double saldo;

		private static Scanner keyboardIn = new Scanner(System.in);
		
		
		public Pankkitili(String omistaja_, String tilinumero_, double saldo_){ 	
			this.omistaja = omistaja_;
			this.tilinumero = tilinumero_;
			this.saldo = saldo_;
		}
		
		private void setOmistaja(String omistaja_){
			this.omistaja = omistaja_;
		}
		
		private void setTilinumero(String tilinumero_){
			this.tilinumero =  tilinumero_;
		}
		
		private void setSaldo(double saldo_){
			this.saldo =  saldo_;
		}
		
		public String getOmistaja(){
			return this.omistaja;
		}
		
		public String getTilinumero(){
			return this.tilinumero;
		}
		
		public double getSaldo(){
			return this.saldo;
		}
		
		private boolean kate(double otto){
			if (this.saldo - otto >= 0){
				return true;
			} else {
				return false;
			}
		}
		
		public void otto(double nostoSumma){
			if (nostoSumma <= 0) {
				System.out.println("Et voi nostaa negatiivista summaa!");
			} else if (kate(nostoSumma)) {
				this.saldo -= nostoSumma;
			} else {
				System.out.println("Tilin kate ei riitä ottoon!");
			}
		}
		
		public void talletus(double talletusSumma){
			if (talletusSumma <= 0) {
				System.out.println("Et voi tallettaa negatiivista summaa! Käytä ottoa!");
			} else {
				this.saldo += talletusSumma;
			}
		}
		
		public void tilitiedot(){
			System.out.println("-------------------------------------");
			System.out.println("Tilin omistaja: " + getOmistaja());
			System.out.println("Tilinumero: "     + getTilinumero());
			System.out.println("Tilin saldo: "    + getSaldo());
			System.out.print("-------------------------------------");
		}
		
}
