public class Payment {
	double amount = 0;
	protected static double totalPayments = 0;
	protected static double totalCashPayments = 0;
	protected static double totalCreditPayments = 0;
	
	
	public Payment(){
		
	}
	
	public Payment(double amount){
		this.amount = amount;
		totalPayments += amount;
	}

	public void setAmount(double amount){
		this.amount = amount;
		totalPayments += amount;
	}

	public double getAmount(){
		return this.amount;
	}

	void printPaymentDetails(){
		System.out.println("Payment details: ");
	}
	
	public void printTotalAmount(){
		System.out.println("total amount: " + totalPayments);
	}
}