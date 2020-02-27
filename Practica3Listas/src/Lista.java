import java.util.Objects;

public class Lista<T> implements Listable<T>{
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

    /**
     * Constructor por omision de la lista, crea una lista vacioa
     * no hace falta porque las variables ya se inicializaron con los mismos variables
     */
    public Lista(){
        head = tail = null;
        elements = 0;
    }

    /**
     * Constructor que hace una copia de la lista
      * @param list lista para copiar
     */
    public Lista(Lista<T> list){
        // TODO: 27/02/20 copia
        this = list.copia();
    }

    @Override
    public boolean isEmpty() {
        return elements == 0;
    }

    @Override
    public void throwAll() {
        /**
         * No es a fuerza hacer todos null, pero es una buena practica
         */
        head = tail = null;
        elements = 0;
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public void addFirst(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (isEmpty()){
            tail = nuevo;
        }else{
            head.anterior = nuevo;
        }
        nuevo.siguiente = head;
        head = nuevo;
        elements++;
    }

    @Override
    public void addEnd(T elem) {
        Nodo nuevo = Nodo(elem);
        if(isEmpty()){
            head = nuevo;
        }else{
            tail.anterior
        }
        nuevo.anterior = tail;
        tail = nuevo;
    }

    /**
     * Java es paso por referencia en general pero en los tipos primitivos es paso por parametro
     * Estructra que permite manipular la estrucrtura interna de los compartimentos para alojar elementos en una lista
     */
    private class Nodo {
        T elemento;
        Nodo anterior, siguiente;

        /**
         * Si java no pudo castear algo manda errores hasta tiempo de ejecucion porque solo hasta que se ejecute va a saber
         * si hay problema o no.
         * Constructor es donde tiene que agregar un espacio solo para el elemento, no nos interesa
         * @param elemento
         */
        Nodo(T elemento){
            this.elemento = elemento;
        }

        /**
         * Esto compara objetos atributo por atributo para regresar verdadero si es que todas sus localidades son la misma
         *
         * @param o objeto a comparar, con el que van a ocupar el metodo equals.
         * @return el resultado de la comparacion
         */
        @Override
        public boolean equals(Object o) {
            Nodo nodo = (Nodo) o;
            return elemento.equals(nodo.elemento);
        }


        @Override
        public int hashCode() {
            return Objects.hash(elemento, anterior, siguiente);
        }
    }

}


