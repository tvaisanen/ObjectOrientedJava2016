import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;


class PankkitiliMain {
	
	static Scanner in = new Scanner(System.in);
	static Pankkitili current;
	
	
	
	public static void main(String[] args){
		
		List<Pankkitili> tilit = new ArrayList<Pankkitili>();
		boolean run = true;
		
		System.out.println("Käyttöliittymä Pankkitili -luokan testaukseen.");
		
		while (run) {
			valinnat();
			int seuraavaOperaatio = in.nextInt();
			
			
			switch (seuraavaOperaatio) {
				case 1: 
						// kysytään käyttäjältä tiedot tilin luomiseen
						tilit.add(uudenTilinTiedot());
						// asetetaan juuri luotu tili valituksi
						current = tilit.get(tilit.size() - 1);
						break;
				case 2:
						System.out.print("Otto: ");
						double nostoSumma = in.nextDouble();
						current.otto(nostoSumma);
						current.tilitiedot();
						break;
				case 3:
						System.out.print("Talleta: ");
						double talletusSumma = in.nextDouble();
						current.talletus(talletusSumma);
						current.tilitiedot();
						break;
				case 4:
						current.tilitiedot();
						break;
				case 5:
						valitseTili(tilit);
						current.tilitiedot();
						break;
				case 6: 
						run = false;
						System.out.println("Poistutaan pankista.");
						break;
				default: 
						System.out.println("Virheellinen valinta!");
						break;
			}
			
		}
		
	}

	private static Pankkitili uudenTilinTiedot(){
		String omistaja;
		String tilinumero;
		double saldo;

		System.out.println("Luodaan uusi tili..");

		System.out.print("omistaja: ");
		omistaja = in.next();

		System.out.print("tilinro: ");
		tilinumero = in.next();

		System.out.print("saldo: ");
		saldo = in.nextDouble();

		// luodaan tili
		Pankkitili uusitili = new Pankkitili(omistaja, tilinumero, saldo);
		return uusitili;
	}

	private static void valitseTili(List<Pankkitili> tilit) {
		/*
		 * Tulostetaan lisätyt tilit näytölle joista voidaan valita 
		 * käsiteltävä tili
		 */
		System.out.println("Valitse tili: ");
		for (int i = 0; i < tilit.size(); i++){
			System.out.println((i+1) + ". Omistaja: " + tilit.get(i).getOmistaja() + ", " 
									 + "Tilinro: " + tilit.get(i).getTilinumero() + ", " 
									 + "Saldo: " + tilit.get(i).getSaldo());
		}
		
		/*
		 * määritellään valittuTili muuttuja aluksi -1:ksi
		 * joka ei läpäise validin syötteen arvoa
		 * määritellään myös valintaOk ehto jota käytetään If-lausekkeessa
		 * ja jos valintaOk niin silloin luetaan valittuTili -muuttujaan uusi arvo
		 * joka vastaa valintaa
		 */
		
		int valittuTili;
		if (in.hasNextInt()){
			valittuTili = in.nextInt() - 1;
		} else {
			valittuTili = -1;
		}
		
		boolean valintaOk = valittuTili >= 0 && 
							valittuTili < tilit.size();
		
		if (valintaOk) {
			current = tilit.get(valittuTili);
		} else {
			System.out.println("Virheellinen valinta!");
			System.out.println("Käytetään tiliä: ");
		}
	}

	private static void valinnat() {
		/**
		 * Tulostaa valinnat käyttöliittymän aloitusikkunaan.
		 */
		System.out.println("\nValitse toiminto: ");
		System.out.println("1) Uusi tili");
		System.out.println("2) Otto");
		System.out.println("3) Talletus");
		System.out.println("4) Tilitiedot");
		System.out.println("5) Vaihda tili");
		System.out.println("6) Poistu");
		System.out.print(">> ");	
	}
}
