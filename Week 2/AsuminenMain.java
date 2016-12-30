
public class AsuminenMain {
	
		public static String[] kysyAsukkaanTiedot(){
			Input in = new Input();
			String[] tiedot = new String[2];
			
		    System.out.print("nimi: ");
		    tiedot[0] = in.textIn();
		    System.out.print(""
		    		+ "syntymäaika: ");
		    tiedot[1] = in.textIn();
		    
			return tiedot;
		}
	
		public static void testaaOliot(){
			// testimuuttujat tontille
		    String[] sijainti = new String[2];
		    sijainti[0] = "65.012089";
		    sijainti[1] = "25.465077";
		    String tontinNimi = "tontinnimi";
		    double tontinPintaAla = 1000;
		    
		    // testimuuttujat rakennukselle
		    double rakennuksenPintaAla = 50;
		    int huoneidenLkm = 3;
		    
		    // testimuuttujat asukkaille
		    String asukas1 = "keijo meikäläinen";
		    String syntAika1 = "05011990";
		    String asukas2 = "teijo teikäläinen";
		    String syntAika2 = "01041980";
		    
		    Tontti tontti = new Tontti(tontinNimi, sijainti, tontinPintaAla);
		    Rakennus rakennus = new Rakennus(rakennuksenPintaAla, huoneidenLkm);
		    Asukas rakennuksenAsukas1 = new Asukas(asukas1, syntAika1);
		    Asukas rakennuksenAsukas2 = new Asukas(asukas2, syntAika2);
		    
		    tontti.setRakennus(rakennus);
		    rakennus.lisaaAsukas(rakennuksenAsukas1);
		    rakennus.lisaaAsukas(rakennuksenAsukas2);
		    
		    tontti.tulostaTontinTiedot();
		    tontti.getRakennus().tulostaRakennuksenTiedot();
		}
		
		public static void testaaOliotSyotteella(){
			
			// luodaan lukija
			Input in = new Input();
			
			System.out.println("Testifunktio, seuraa ohjeita...");
			
			// testimuuttujat tontille
			System.out.print("Anna tontin nimi: ");
		    String tontinNimi = in.textIn();
			
		    String[] sijainti = new String[2];
		    System.out.println("Syötä tontin sijaniti");
		    System.out.print("leveysaste: ");
		    sijainti[0] = in.textIn();
		    System.out.print("pituusaste: ");
		    sijainti[1] = in.textIn();
		    
		    System.out.println("syötä tontin pinta-ala: ");
		    double tontinPintaAla = in.doubleIn();
		    
		    Tontti tontti = new Tontti(tontinNimi, sijainti, tontinPintaAla);
		    // tulostetaan juuri  luodun tontin tiedot
		    tontti.tulostaTontinTiedot();
		    
		    
		    
		    // testimuuttujat rakennukselle
		    System.out.println("syötä tontille tulevan rakennuksen tiedot");
		    System.out.print("pinta-ala: ");
		    double rakennuksenPintaAla = in.doubleIn();
		    System.out.print("huoneiden lkm: ");
		    int huoneidenLkm = in.intIn();
		    
		    // luodaan rakennus, lisätään se tontille ja tulostetaan sen tiedot
		    Rakennus rakennus = new Rakennus(rakennuksenPintaAla, huoneidenLkm);
		    tontti.setRakennus(rakennus);
		    System.out.println("tulostetaan rakennuksen tiedot rakennus.tulostaRakennuksenTiedot() -funktiolla");
		    rakennus.tulostaRakennuksenTiedot();
		    System.out.println("tulostetaan rakennuksen tiedot tontti.getRakennus().tulostaRakennuksenTiedot() -funktiolla");
		    tontti.getRakennus().tulostaRakennuksenTiedot();
		    
		    // lisätään haluttu määrä asukkaita
		    System.out.print("syötä asukkaiden lkm: ");
		    int asukkaidenLkm = in.intIn();
		    
		    for (int i = 0; i  < asukkaidenLkm; i++){
		    	// palautetaan syötetyn asukkaan nimi ja syntymäaika tiedot taulukkoon
		    	String[] tiedot = kysyAsukkaanTiedot();
		    	// luodaan uusi asukas edellisillä tiedoilla
		    	Asukas asukas = new Asukas(tiedot[0], tiedot[1]);
		    	// lisätään asukas rakennuksen asukalistaan
		    	rakennus.lisaaAsukas(asukas);
		    }
		    
		    
		    System.out.println("\njuuri luodut asukkaat on lisätty rakennuksen tietoihin\n");
		    System.out.println("rakennus.tulostaAsukasLista()");
		    rakennus.tulostaAsukaslista();
		    System.out.println("\ntontti.getRakennus().tulostaAsukasLista()");
		    tontti.getRakennus().tulostaAsukaslista();
		    
		    System.out.println("\ntulostetaan vielä tiedot kootusti");
		    System.out.println("tontti.tulostaTontinTiedot()");
		    tontti.tulostaTontinTiedot();
		    System.out.println("tontti.getRakennus().tulostaRakennuksenTiedot()");
		    System.out.println("(tämä funktio tulostaa myös asukkaat mikäli rakennuksella asukkaita)");
		    tontti.getRakennus().tulostaRakennuksenTiedot();
		}
	

		public static void main(String[] args){
			
			//testaaOliot();
			testaaOliotSyotteella();
		}
}
