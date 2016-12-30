
import java.util.InputMismatchException;
import java.util.Scanner;

public class Vt3main {
	
	static void printSubscriptionInvoice(Subscription subs){
		subs.printInvoice();
	}
	
	static void tulostaValikko(){
		System.out.println("\n");
		System.out.println("Uusi tilaus \t\t\t[1]");
		System.out.println("Tulosta tilauslista \t[2]");
		System.out.println("Lopeta \t\t\t\t\t[3]");
		System.out.println();
	}

	static void testiMetodiInstanssienLuomiseen(){
		StandingSubscription kestotilaus = new StandingSubscription(50);
		RegularSubscription normitilaus = new RegularSubscription();

        System.out.println("Luodaan tilaukset: kestotilaus ja normitilaus\n");

		kestotilaus.setTilaajan_nimi("Matti Meikäläinen");
		kestotilaus.setLehden_nimi("Kaleva");
		kestotilaus.setKuukausihinta(32.1);
		kestotilaus.setToimitusosoite("Koulukuja 13");
        kestotilaus.setAlennusprosentti(12);


        normitilaus.setTilaajan_nimi("Keijo Teikäläinen");
        normitilaus.setLehden_nimi("Helsingin Sanomat");
        normitilaus.setKuukausihinta(32.1);
        normitilaus.setToimitusosoite("Kotikuja 41");
        normitilaus.setTilauksen_kesto(3);


        System.out.println("kestotilaus.printInvoice()");
        kestotilaus.printInvoice();
        System.out.println("printSubscriptionInvoice(kestotilaus)");
        printSubscriptionInvoice(kestotilaus);

        System.out.println("normitilaus.printInvoice()");
        normitilaus.printInvoice();
        System.out.println("printSubscriptionInvoice(normitilaus)");
        printSubscriptionInvoice(normitilaus);
	}

    static void kayttajanTiedoillaInstanssit(){
        StandingSubscription kestotilaus = new StandingSubscription(50);
        RegularSubscription normitilaus = new RegularSubscription();

        System.out.println("Luodaan tilaukset: kestotilaus ja normitilaus\n");

        System.out.print("Kestotilauksen tiedot: \ntilaajan nimi: ");
        kestotilaus.setTilaajan_nimi(readString());
        System.out.print("toimitusosoite: ");
        kestotilaus.setToimitusosoite(readString());
        System.out.print("lehden nimi: ");
        kestotilaus.setLehden_nimi(readString());
        System.out.print("kuukausihinta: ");
        kestotilaus.setKuukausihinta(readDouble());
        System.out.print("alennusprosentti: ");
        kestotilaus.setAlennusprosentti(readInt());


        System.out.print("Normaalin tilauksen tiedot: \ntilaajan nimi: ");
        normitilaus.setTilaajan_nimi(readString());
        System.out.print("toimitusosoite: ");
        normitilaus.setToimitusosoite(readString());
        System.out.print("lehden nimi: ");
        normitilaus.setLehden_nimi(readString());
        System.out.print("kuukausihinta: ");
        normitilaus.setKuukausihinta(readDouble());
        System.out.print("Tilauksen kesto: ");
        normitilaus.setTilauksen_kesto(readInt());


        System.out.println("\nkestotilaus.printInvoice()");
        kestotilaus.printInvoice();
        System.out.println("printSubscriptionInvoice(kestotilaus)");
        printSubscriptionInvoice(kestotilaus);

        System.out.println("normitilaus.printInvoice()");
        normitilaus.printInvoice();
        System.out.println("printSubscriptionInvoice(normitilaus)");
        printSubscriptionInvoice(normitilaus);
    }

	static Scanner input = new Scanner(System.in);

	static String readString(){
        while (! input.hasNext()) {
            System.out.print("Syötä kokonaisluku: ");
            input.next();
        }
        return input.next();
    }

	static int readInt(){
		while (! input.hasNextInt()) {
            System.out.print("Syötä kokonaisluku: ");
            input.next();
		}
		return input.nextInt();
	}

    static double readDouble(){
        while (! input.hasNextDouble()) {
            System.out.print("Syötä desimaaliluku: ");
            input.next();
        }
        return input.nextDouble();
    }

	public static void main(String[] args){


		StandingSubscription kestotilaus = new StandingSubscription(50);
		RegularSubscription normitilaus = new RegularSubscription();

        testiMetodiInstanssienLuomiseen();

        System.out.println("Testataan myös instanssien luonti käyttäjän parametreilla..");
        System.out.println("Luetaan tiedot luokkien testaamiseen");

        kayttajanTiedoillaInstanssit();



	}

}
