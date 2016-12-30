import java.util.Scanner;


public class AsuminenMain {

    static Scanner input = new Scanner(System.in);

    static String readLine(){
        while (! input.hasNext()) {
            System.out.print("Syötä merkkijono: ");
            input.next();
        }
        return input.nextLine();
    }

    static String readString(){
        while (! input.hasNext()) {
            System.out.print("Syötä merkkijono: ");
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

    static Tontti luoUusiTontti(){
        // kysytään testimuuttujat tontille
        // ja palautetaan juuri luotu tontti
        System.out.print("Tontin tiedot\nnimi: ");
        String nimi = readLine();
        System.out.print("osoite: ");
        String osoite = readLine();
        System.out.print("pinta-ala: ");
        double pintaAla = readDouble();
        return new Tontti(nimi, osoite, pintaAla);
    }


    public static Rakennus luoUusiRakennus() {
        /*
        kysellään käyttäjältä uuden rakennuksen tiedotj
        ja palautetaan luotu rakennus
         */

        System.out.print("Rakennuksen tiedot\npinta-ala: ");
        Double pintaAla = readDouble();
        System.out.print("asuntojen lkm: ");
        int asuntojenLkm = readInt();
        System.out.print("valitse tyyppi [1] omakotitalo [2] rivitalo [3] kerrostalo");
        boolean tyyppiOk = false;
        String tyyppi = null;
        while (!tyyppiOk){
            System.out.print(" :: ");
            int valinta = readInt();
            switch (valinta){
                case 1: tyyppi = "omakotitalo";
                        tyyppiOk = true;
                        break;
                case 2: tyyppi = "rivitalo";
                        tyyppiOk = true;
                        break;
                case 3: tyyppi = "kerrotsalo";
                        tyyppiOk = true;
                        break;
                default: System.out.print("valinnan täytyy olla kokonaislukue 1-3.");
            }
        }
        return new Rakennus(pintaAla, asuntojenLkm, tyyppi);
    }

    public static Asunto luoUusiAsunto(){
        /*
            kysytään käyttäjältä tiedot asunnon
            luomiseen ja palautetaan asunto
         */
        System.out.print("Asunnon tiedot\npinta-ala: ");
        double pintaAla = readDouble();
        System.out.print("huoneiden lkm: ");
        int huoneidenLkm = readInt();
        return new Asunto(pintaAla, huoneidenLkm);
    }

    public static void lisaaAsuntoja(Rakennus rakennus){
        boolean lisaa = true;
        while (lisaa){
            System.out.print("Lisätäänkö asunnon tiedot? [1] kyllä, [2] ei :: ");
            switch (readInt()){
                case 1:
                        // tarkistetaan onko asuntojen lkm pienempi kuin
                        // määriteltyjen asuntojen määrä
                        if(!rakennus.lisaaAsunto(luoUusiAsunto())){
                            lisaa = false;
                        }
                        break;

                case 2: System.out.println("Lopetetaan asuntojen lisääminen..\n");
                        lisaa = false;
                        break;

                default: System.out.print("Virheellinen valinta..");
                        break;
            }
        }
    }

    public static Asunto valitseRakennuksenAsunto(Rakennus rakennus){
        Asunto muokattavaAsunto = null;
        boolean valintaOk = false;
        while (!valintaOk) {
            if (rakennus.getAsunnot().size() < 2){
                return rakennus.getAsunnot().get(0);
            } else {
                System.out.print("\nValitse asunto johon lisätä asukkaita: ");
                rakennus.tulostaAsuntoLista();
            }
            int valinta = readInt();
            if (0 < valinta  || valinta - 1 < rakennus.getAsuntojenLkm()) {
                muokattavaAsunto = rakennus.getAsunnot().get(valinta - 1);
                valintaOk = true;
            } else {
                System.out.print("Virheellinen valinta, yritä uudelleen..");
            }
        }
        return muokattavaAsunto;
    }

    public static Asukas luoUusiAsukas(){
        System.out.println("lisätään uusi asukas.. (käytä välilyönnin sijasta '_'-merkkiä)");
        System.out.print("asukkaan nimi: ");
        String asukkaanNimi = readString();
        return new Asukas(asukkaanNimi);
    }

    public static void lisaaAsukkaita(Asunto asunto){
        boolean lisaa = true;
        while (lisaa){
            System.out.print("Lisätäänkö asukas? [1] kyllä, [2] ei :: ");
            int valinta = readInt();
            switch (valinta){
                case 1:
                    Asukas uusiAsukas = luoUusiAsukas();
                    System.out.println(uusiAsukas.getNimi()+" lisätty.");
                    asunto.addAsukas(uusiAsukas);
                    break;

                case 2:
                    System.out.println("Valitse seuraava toiminto..");
                    lisaa = false;
                    break;

                default:
                    System.out.print("Virheellinen valinta..");
                    break;
            }
        }

    }

    public static void lisaaAsukkaitaAsuntoihin(Rakennus rakennus){

        boolean lisaaAsukkaita = true;
        boolean vaihdaAsunto = true;
        // oletusvalinta on rakennuksen ensimmäinen asunto
        Asunto asuntoJohonLisataAsukkaita = rakennus.getAsunnot().get(0);
        while (lisaaAsukkaita){
            if (vaihdaAsunto) {
                asuntoJohonLisataAsukkaita = valitseRakennuksenAsunto(rakennus);
                vaihdaAsunto = false;
            }
            lisaaAsukkaita(asuntoJohonLisataAsukkaita);
            System.out.print("[1] jatka asukkaiden lisäämistä\n" +
                             "[2] vaihda asuntoa johon lisätä asukkaita\n" +
                             "[3] lopeta asukkaiden lisääminen.");
            int valinta = readInt();
            switch (valinta){
                case 1: break;
                case 2: vaihdaAsunto = true; break;
                case 3: lisaaAsukkaita = false; break;
            }

        }

    }


    public static void testiFunktio(){

        System.out.println("Testifunktio, seuraa ohjeita...");

        // luodaan uusi tontti kysymällä käyttäjältä tiedot
        // ja tulostetaan juuri luodun tontin tiedot
        Tontti tontti = luoUusiTontti();
        tontti.tulostaTontinTiedot();
        System.out.print("Lisätään tontille rakennus: ");
        tontti.setRakennus(luoUusiRakennus());

        // demotaan sitä, että tontilla voi olla vain yksi rakennus
        // yrittämällä lisätä toinen rakennus
        // tontti.setRakennus(luoUusiRakennus());

        // lisätään rakennukseen asuntoja
        lisaaAsuntoja(tontti.getRakennus());

        // lisätään asukkaita käyttäjän valitsemiin asuntoihin
        lisaaAsukkaitaAsuntoihin(tontti.getRakennus());

        tontti.tulostaTontinTiedot();

    }

    public static void debugAsukasTulostus(){
        Tontti t = new Tontti("nimi","osoite",2);
        t.setRakennus(new Rakennus(1,1,"kerrostalo"));
        t.getRakennus().lisaaAsunto(new Asunto(1,2));
        t.getRakennus().getAsunnot().get(0).addAsukas(new Asukas("keijo"));
        t.getRakennus().tulostaAsukasLista();
        for (Asunto a : t.getRakennus().getAsunnot()){
            a.tulostaAsukasLista();
        }

    }


    public static void main(String[] args){
			
			testiFunktio();
		}
}
