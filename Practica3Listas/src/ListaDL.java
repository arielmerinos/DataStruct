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
}


