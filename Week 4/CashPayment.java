public class CashPayment extends Payment {

	public CashPayment(){
		
	}
	
	public CashPayment(double amount){
		super(amount);
	}

	void printPaymentDetails(){
		System.out.println("Payment details:\ncash, amount: " + this.getAmount());
	}
}