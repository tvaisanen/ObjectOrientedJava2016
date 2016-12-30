
public class CustomerLine<Object> extends AbstractLine<Object> {


    Customer[] customerLine = null;


    public CustomerLine(Customer customer){
        customerLine = new Customer[1];
        customerLine[0] = customer;
    }


    public void addElement(Object customer){

        Customer[] tmp;
        tmp = new Customer[customerLine.length + 1];
        System.arraycopy(customerLine, 0, tmp, 0, customerLine.length);
        tmp[customerLine.length] = (Customer)customer;
        customerLine = tmp;
    }


    public Object returnElement(){

        Customer[] tmp;
        Customer firstFromTheLine = customerLine[0];
        tmp = new Customer[customerLine.length - 1];
        System.arraycopy(customerLine, 1, tmp, 0, customerLine.length-1);
        customerLine = tmp;
        return (Object)firstFromTheLine;
    }

    public boolean lineExists(){
        if ( customerLine != null){
            return true;
        } else {
            return false;
        }
    }

    public boolean lineIsEmpty(){
        if ( customerLine == null){
            return true;
        } else {
            return false;
        }
    }

    public int lineLength(){
        return customerLine.length;
    }

    public void printLine(){
        for (int i = 0; i < lineLength(); i++){
            System.out.println(i + " " +returnElement());
        }
    }
}
