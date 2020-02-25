public class ListaDL<T> implements Listable<T>{
    /**
     * Primer elemento de la lista
     */
    private Nodo head;
    /**
     * ultimo elemento de la lista
     */
    private Nodo tail;
    /**
     * Cardinalidad de la lista
     */
    private int elements;

    @Override
    public void push(T elem) {

    }

    @Override
    public void pop(T elem) {

    }

    @Override
    public boolean contains(T elem) {
        return false;
    }


    public class Nodo{
        private T elemento;
        private Nodo anterior;
        private Nodo siguiente;
    }



}
