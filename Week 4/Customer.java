
public class Customer {
    int customerNumber;
    Payment payment;

    public Customer(){}

    public Customer(int customerNumber, Payment payment){
        this.customerNumber = customerNumber;
        this.payment = payment;
    }

    public void printCustomerInfo(){
        System.out.println("Customer information:");
        System.out.println("customernumber: " + this.customerNumber);
        this.payment.printPaymentDetails();
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }
}
