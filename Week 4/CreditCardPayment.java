class CreditCardPayment extends Payment {
	String creditCardNumber = null;

	public CreditCardPayment(){
		
	}
	
	public CreditCardPayment(double amount, String creditCardNumber){
		super(amount);
		this.creditCardNumber = creditCardNumber;
	}

	public void setCreditCardNumber(String cardNumber_){
		this.creditCardNumber = cardNumber_;
	}
	
	public String getCreditCardNumber(){
		return this.creditCardNumber;
	}

	void printPaymentDetails(){
		System.out.println("Payment details:\ncard: " + creditCardNumber + 
			"\namount: " + amount);
	}
	
	
}	
