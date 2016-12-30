import java.util.Scanner;

public class Input {
	Scanner input;
	
	Input(){ this.input = new Scanner(System.in); }
	
	// TÄNNE VIELÄ VIRHEENTARKISTUKSET 
	// EI SAA HYVÄKSYÄ EI HYVÄKSYTTYÄ SYÖTETTÄ
	public int intIn(){
		return this.input.nextInt();
	}
	
	public double doubleIn(){
		return this.input.nextDouble();
	}
	
	public String textIn(){
		return this.input.nextLine();
	}
}
