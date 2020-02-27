import java.util.Iterator;

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

    public class Iterador<T> implements java.util.Iterator<T>{

        Nodo siguiente;

        public Iterador(){
            siguiente = head;
        }

        @Override
        public boolean hasNext() {
            return siguiente != null;
        }

        /**
         * Constructor copia,
         * reversa de una lista
         * metodo de copiar una lista
         * @return
         * vamos a ver Merge Sort
         * dadas dos listas ordenadas comparar las cabezas de las listas
         * eliminar el que sea mas pequeño y volver a comparar
         *  Dividir todo entere dos has que tengamos una lista de un solo elemento
         *
         */
        @Override
        public T next() {
            if (hasNext()){
                /**
                 * El codigo de luis es
                 * T elem = sigiente.elemento;
                 * siguiente = siguiente.siguiente;
                 * return elem;
                 */
                siguiente = siguiente.next;
                return (T) siguiente.prev.elemento;
            }
            return null;
        }

        @Override
        public void remove() {

        }
    }

    @Override
    public void push(T elem) {
        /**
         * Agrega lo hara al final
         */
        Nodo e = new Nodo(elem);
        if (elements == 0){
            head = tail = e;
        }else{
            tail.next = e;
            e.prev = tail;
            tail = e;
        }
        elements++;
    }

    @Override
    public void pop(T elem) {
        Nodo buqueda = search(elem, head);
        if(buqueda != null){
            if (elements == 1){
                head = tail = null;
            }else if (buqueda == head){
                head = buqueda.next;
                head.prev = null;
            }else if (buqueda == tail){
                tail = buqueda.prev;
                tail.prev = null;

            }else{
                buqueda.prev.next = buqueda.next;
                buqueda.next.prev = buqueda.prev;
            }
            elements--;
        }
    }

    @Override
    public boolean contains(T elem) {
        return false;
    }


    public class Nodo{
        private T elemento;
        private Nodo prev;
        private Nodo next;

        /**
         * Constructor por omision
         * @param elemento
         */
        public Nodo(T elemento){
            this.elemento = elemento;
        }
    }

    /**
     * Siempre recorrer hacia el siguiente hasta encontrar el elementos
     * @param element elemento a buscar
     * @param pivote desde donde se empezara a buscar
     * @return elementos encontrado
     */
    private Nodo search(T element, Nodo pivote){
        while (pivote != null){
            if (pivote.elemento.equals(element)){
                return pivote;
            }else {
                pivote = pivote.next;
            }
        }
        return null;
    }

    public <T extends Comparable<T>> ListaDL<T> merge(ListaDL<T> l1, ListaDL l2){

        ListaDL<T> merge = new ListaDL<>();
        Nodo auxL1 = (ListaDL.Nodo) l1.head;
        Nodo auxL2 = l2.head;

        while (auxL1 != null && auxL2 != null){
            if (auxL1.elemento.compareTo(auxL2.elemento) <= 0){
                merge.push((T) auxL1.elemento);
                auxL1 = auxL1.next;
            }else{
                merge.push((T) auxL2.elemento);
                auxL2 = auxL2.next;
            }
        }
        if (auxL1 != null){
            while (auxL1 != null){
                merge.push((T) auxL1.elemento);
                auxL1 = auxL1.next;
            }
        }else{
            while (auxL2 != null){
                merge.push((T) auxL2.elemento);
                auxL2 = auxL2.next;
            }
        }
        return merge;
    }

    public <T extends Comparable<T>> ListaDL<T> merge(ListaDL<T> l){
        if (l.elements == 1 || l.elements == 0){
            return l;
        }else {
            int n = l.elements / 2;
            int i = 0;
            ListaDL<T> lCopia = new ListaDL<>();
            while (i < n) {
                /**
                 * aqui se dividen entre dos las listas
                 * ese metodo lo va a envair en la practica
                 */
                lCopia.push(l.eliminaPrimero());
            }
            ListaDL<T> mergeList1 = merge(lCopia);
            ListaDL<T> mergeList2 = merge(l);
            return merge(mergeList1, mergeList2);
        }
    }

}


