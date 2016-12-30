import java.util.Scanner;

public class Input{
    private Scanner input;
    Input(){
        input = new Scanner(System.in);
    };

    public String readLine(){
        while (! input.hasNext()) {
            System.out.print("Syötä merkkijono: ");
            input.next();
        }
        return input.nextLine();
    }

    public String readString(){
        while (! input.hasNext()) {
            System.out.print("Syötä merkkijono: ");
            input.next();
        }
        return input.next();
    }

    public Character readChar(){
        while (! input.hasNext()) {
            System.out.print("Input char: ");
            input.next();
        }

        return input.next().charAt(0);
    }

    public int readInt(){
        while (! input.hasNextInt()) {
            System.out.print("Syötä kokonaisluku: ");
            input.next();
        }
        return input.nextInt();
    }

}