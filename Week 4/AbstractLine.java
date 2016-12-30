
abstract class AbstractLine<E> implements LineInterface<E>{

    private E[] a ;

    public void addElement(E obj){
        E[] tmp;
        tmp =  (E[]) new Object[a.length + 1];
        System.arraycopy(a, 0, tmp, 0, a.length);
        tmp[a.length] = obj;
        a = tmp;
    }

    public E returnElement(){
        E[] tmp;
        E firstFromTheLine = a[0];
        tmp = (E[]) new Object[a.length - 1];
        System.arraycopy(a, 1, tmp, 0, a.length-1);
        a = tmp;
        return firstFromTheLine;
    }

    public boolean lineExists(){
        if ( a != null){
            return true;
        } else {
            return false;
        }
    }

    public boolean lineIsEmpty() {
        if (a == null) {
            return true;
        } else {
            return false;
        }
    }
}


