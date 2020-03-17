import java.util.Iterator;

/**
 * <p> Clase concreta para modelar la estructura de datos Pila</p>
 * <p>Esta clase implementa una Pila genérica, es decir que es homogénea pero
 * puede tener elementos de cualquier tipo.
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 * @version 1.0
 * @param <T> Tipo que tienen los objetos que guarda esta pila.
 */
public class Pila<T> implements Coleccionable<T> {

    private class Nodo {

        /**
         * El elemento del nodo.
         */
        public T elemento;
        /**
         * El siguiente nodo.
         */
        public Nodo siguiente;

        /**
         * Construye un nodo con un elemento.
         *
         * @param elemento el elemento del nodo.
         */
        public Nodo(T elemento) {
            this.elemento = elemento;
        }
    }

    private class IteradorPila implements Iterator<T> {

        public Nodo siguiente;

        public IteradorPila() {
            siguiente = tope;
        }

        /* Nos dice si hay un elemento siguiente. */
        @Override
        public boolean hasNext() {
            return siguiente != null;
        }

        /* Nos da el elemento siguiente. */
        @Override
        public T next() {
            T aux = siguiente.elemento;
            siguiente = siguiente.siguiente;
            return aux;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("No implementado");
        }

    }
    private Nodo tope;
    private int elementos;

    /**
     * Constructor por omisión de la clase;
     */
    public Pila() {
    }

    /**
     * Constructor que recibe un arreglo de elementos de tipo <code>T</code>.
     * Crea una pila donde el primer elemento del arreglo es el que queda al
     * fondo de la pila, el último elemento del arreglo queda en el tope
     * de la pila.
     * @param elementos
     */
    public Pila(T[] elementos) {
        //Aqui va tu codigo
    }

    /**
     * Constructor que recibe una colección de tipo {@link Coleccionable}
     * de elementos de tipo <code>T</code>.
     * Crea una pila donde el primer elemento de la colección es el que queda al
     * fondo de la pila, el último elemento de la colección queda en el tope
     * de la pila.
     * @param elementos La colección de elementos a agregar.
     */
    public Pila(Coleccionable<T> elementos) {
        //Aqui va tu codigo
    }

    /**
     * Constructor de la clase, que recibe una pila y regresa una copia
     * exacta de ésta.
     *
     * @param pila La pila que se va a copiar.
     */
    public Pila(Pila <T> pila){
        //Aqui va tu codigo
    }

    /**
     * Agrega un elemento al tope de la pila.
     *
     * @param elemento el elemento a agregar.
     */
    public void push(T elemento) {
        //aqui va tu codigo
    }

    /**
     * Elimina el elemento del tope de la pila y lo regresa.
     *
     * @return el elemento en el tope de la pila.
     */
    public T pop() {
        //Aqui va tu codigo
        return null;
    }

    /**
     * Nos permite ver el elemento en el tope de la pila
     *
     * @return el elemento en un extremo de la estructura.
     */
    public T peek() {
        //Aqui va tu codigo
        return null;
    }

    /**
     * Agrega un elemento a la pila.
     *
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     * <code>null</code>.
     */
    public void agrega(T elemento) {
        //Aqui va tu codigo
    }

    /**
     * Nos dice si un elemento está contenido en la pila.
     *
     * @param elemento el elemento que queremos verificar si está contenido en
     * la pila.
     * @return <code>true</code> si el elemento está contenido en la pila,
     * <code>false</code> en otro caso.
     */
    @Override
    public boolean contiene(T elemento) {
        //Aqui va tu codigo
        return false;
    }

    /**
     * Elimina un elemento de la pila.
     *
     * @param elemento el elemento a eliminar.
     */
    public void elimina(T elemento) {
        //Aqui va tu codigo
    }

    /**
     * Nos dice si la pila está vacía.
     *
     * @return <tt>true</tt> si la pila no tiene elementos,
     * <tt>false</tt> en otro caso.
     */
    @Override
    public boolean esVacio() {
        return elementos == 0;
    }

    /**
     * Regresa el número de elementos en la pila.
     *
     * @return el número de elementos en la pila.
     */
    @Override
    public int getTamanio() {
        return elementos;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorPila();
    }

    @Override
    public String toString() {
        Iterator it = iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()){
            sb.append(it.next());
        }
        return sb.toString();
    }
}
