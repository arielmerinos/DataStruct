
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p> Clase concreta para modelar la estructura de datos Cola</p>
 * <p>Esta clase implementa una Cola genérica, es decir que es homogénea pero
 * puede tener elementos de cualquier tipo.
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 * @version 1.0
 * @param <T> Tipo que tienen los objetos que guarda esta cola.
 */
public class Cola<T> implements Coleccionable<T> {

    private Nodo tope;
    private Nodo rabo;

    private int elementos;

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

    private class IteradorCola implements Iterator<T> {

        public Nodo siguiente;

        public IteradorCola() {
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
            Iterator.super.remove();
        }

    }

    public Cola() {
        //Aqui no hay que hacer nada

    }

    /**
     * Constructor que recibe un arreglo de elementos de tipo <code>T</code>.
     * Crea una cola donde el primer elemento del arreglo es el que queda al
     * fondo de la cola, el último elemento del arreglo queda en el tope
     * de la cola.
     * @param elementos
     */
    public Cola(T[] elementos) {
        //Aqui va tu codigo
    }


    public Cola(Coleccionable<T> elementos) {
        //Aqui va tu codigo
    }

    /**
     * Agrega un elemento al tope de la Cola.
     *
     * @param elemento el elemento a agregar.
     */
    public void queue(T elemento) {
        //aqui va tu codigo
    }

    /**
     * Elimina el elemento del tope de la Cola y lo regresa.
     *
     * @return el elemento en el tope de la Cola.
     */
    public T dequeue() {
        //aqui va tu codigo
        return null;
    }

    /**
     * Nos permite ver el elemento en el tope de la Cola
     *
     * @return el elemento en un extremo de la estructura.
     */
    public T peek() {
        //Aqui va tu codigo
        return null;
    }

    /**
     * Agrega un elemento a la Cola.
     *
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     * <code>null</code>.
     */
    public void agrega(T elemento) throws IllegalArgumentException{
        //Aqui va tu codigo
    }

    /**
     * Nos dice si un elemento está contenido en la Cola.
     *
     * @param elemento el elemento que queremos verificar si está contenido en
     * la Cola.
     * @return <code>true</code> si el elemento está contenido en la Cola,
     * <code>false</code> en otro caso.
     */
    @Override
    public boolean contiene(T elemento) {
        //Aqui va tu codigo
        return false;
    }

    /**
     * Elimina un elemento de la Cola.
     *
     * @param elemento el elemento a eliminar.
     */
    @Override
    public void elimina(T elemento) {
        // Aquí va su código.
    }

    /**
     * Nos dice si la Cola está vacía.
     *
     * @return <tt>true</tt> si la Cola no tiene elementos,
     * <tt>false</tt> en otro caso.
     */
    @Override
    public boolean esVacio() {
        // Aquí va su código.
        return elementos == 0;
    }

    /**
     * Regresa el número de elementos en la Cola.
     *
     * @return el número de elementos en la Cola.
     */
    @Override
    public int getTamanio() {
        //Aqui vatu codigo.
        return elementos;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorCola();
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
