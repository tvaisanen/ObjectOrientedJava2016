class CreditCardCustomer extends Customer {
    String creditCardNumber = null;

    public CreditCardCustomer(){

    }

    public CreditCardCustomer(int customerNumber, String creditCardNumber, Payment payment){
        super(customerNumber, payment);
        this.creditCardNumber = creditCardNumber;
    }
}
