
import java.util.Random;

public class JonoMain {

    int customersProcessed = 0;
    private static Random r = new Random();

    private static int randomBetween(int min, int max){
        int range = (max-min) + 1;
        return (int)(Math.random() * range) + min;
    }

    /* random variables for testing */
    private static int randomAmountOfProcesses(){
        // randomizes how many customers will be processed
        // added or served
        int low = 9;
        int high = 30;
        return randomBetween(low,high);
    }

    private static int randomizeCustomerAmount(){
        // randomizes how many customers there are in the beginning
        int low = 9;
        int high = 101;
        return randomBetween(low,high);
    }

    private static int randomBinary(){
        // randomizes does one customer out of the line or is there new one in the end of the line

        int low = 0;
        int high = 2;
        return r.nextInt(high-low) + low;

    }

    private static double randomPaymentAmount(){

        int low = 0;
        int high = 1000;
        return r.nextInt(high-low) + low;
    }

    private static int randomCustomerNumber(){

        int low = 0;
        int high = 1000;
        return r.nextInt(high-low) + low;
    }

    private static String randomCreditCardNumber(){

        int low = 0;
        int high = 1000000;
        return Integer.toString(r.nextInt(high-low) + low);
    }

    public static Customer randomCustomer(){
        // create random customer
        int cashOrCredit = randomBinary();
        Customer randomCustomer = null;
        Payment randomPayment;
        if (cashOrCredit == 0){
            randomPayment = new CashPayment(randomPaymentAmount());
            randomCustomer = new CashCustomer(randomCustomerNumber(), randomPayment);
        } else if (cashOrCredit == 1) {
            String randomCreditCardNumber = randomCreditCardNumber();
            randomPayment = new CreditCardPayment(randomPaymentAmount(), randomCreditCardNumber);
            randomCustomer = new CreditCardCustomer(randomCustomerNumber(),
                                                    randomCreditCardNumber,
                                                    randomPayment);
        }


        return randomCustomer;
    }


    static void processCustomerFromList(CustomerLine line){

        System.out.println("Processing payment...");
        Customer customer = (Customer)line.returnElement();
        customer.payment.printPaymentDetails();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Customer Processed");

    }


    public static void main(String[] args) {

        int initialCustomerAmount = randomizeCustomerAmount();
        CustomerLine line = null;
        for (int i = 0; i < initialCustomerAmount; i++) {
            try {
                line.addElement(randomCustomer());
            } catch (NullPointerException NPE) {
                line = new CustomerLine(randomCustomer());
            }
        }
        int amountOfProcesses = randomAmountOfProcesses();
        int added = 0;
        int processed = 0;

        System.out.println("Line length at the beginning: " + line.lineLength());
        for (int i = 0; i < amountOfProcesses; i++){

            System.out.println("\n" + (i+1) + ". transaction\n  ");

            if (randomBinary() == 0){
                added++;
                System.out.println("Customer added");
                line.addElement(randomCustomer());
                System.out.println("Customers in line: " + line.customerLine.length);
            } else {
                processed++;
                try {
                    if (line.lineExists() && line.customerLine.length > 0) {
                        processCustomerFromList(line);
                        System.out.println("Customers in line: " + line.customerLine.length);
                    } else {
                        System.out.println("Line is empty!");
                    }
                } catch (NullPointerException NPE){
                    System.out.println("There's no customers to process!");
                }
            }
        }
        // process rest of the customers !!!!
        System.out.println("\nNo more new customers, existing ones are going to be processed.\n");
        System.out.println(amountOfProcesses + " transactions");
        System.out.println(initialCustomerAmount + " initial customers");
        System.out.println(added + " customers added");
        System.out.println(processed + " customers processed");

        while (!(line.lineIsEmpty())){
            amountOfProcesses++;
            try {
                System.out.println(line.lineLength() + " customers left.");
                System.out.println("\n" + (amountOfProcesses) + ". transaction\n");
                processCustomerFromList(line);
            } catch (ArrayIndexOutOfBoundsException AIOBE) {
                System.out.println("There's no customers to be processed!");
                break;
            } catch (NullPointerException NPE) {
                NPE.printStackTrace();
                break;
            }
        }
    }
}
