import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.Comparable;

/**
 * <p>Clase para modelar árboles binarios de búsqueda genéricos.</p>
 *
 * <p>Un árbol instancia de esta clase siempre cumple que:</p>
 * <ul>
 *   <li>Cualquier elemento en el árbol es mayor o igual que todos sus
 *       descendientes por la izquierda.</li>
 *   <li>Cualquier elemento en el árbol es menor o igual que todos sus
 *       descendientes por la derecha.</li>
 * </ul>
 */
public class ArbolBinarioBusqueda<T extends Comparable<T>> extends ArbolBinario<T> {

    /* Clase privada para iteradores de árboles binarios ordenados. */
    private class Iterador implements Iterator<T> {

        /* Pila para recorrer los nodos en DFS in-order. */
        private Pila<Nodo> pila;

        /* Construye un iterador con el nodo recibido. */
        public Iterador() {
            //Aqui va tu codigo
        }

        /* Nos dice si hay un elemento siguiente. */
        @Override public boolean hasNext() {
            // Aquí va su código.

        }

        /* Regresa el siguiente elemento en orden DFS in-order. */
        @Override public T next() {
            // Aquí va su código.
        }
    }


    /**
     * Constructor que no recibe parámeteros. {@link ArbolBinario}.
     */
    public ArbolBinarioBusqueda() {

    }

    /**
     * Construye un árbol binario ordenado a partir de una colección. El árbol
     * binario ordenado tiene los mismos elementos que la colección recibida.
     * @param coleccion la colección a partir de la cual creamos el árbol
     *        binario ordenado.
     */

    public ArbolBinarioBusqueda(Coleccionable<T> coleccion) {
        //Aqui va tu codigo
    }

    protected void agregaNodo(Nodo<T> n, Nodo<T> nuevo){
        //Aqui va tu codigo
    }

    /**
     * Agrega un nuevo elemento al árbol. El árbol conserva su orden in-order.
     * @param elemento el elemento a agregar.
     */
    @Override public void agrega(T elemento) {
        //Aqui va tu codigo
    }

    protected Nodo<T> eliminaNodo(Nodo<T> n){
        //Aqui va tu codigo
    }

    /**
     * Elimina un elemento. Si el elemento no está en el árbol, no hace nada; si
     * está varias veces, elimina el primero que encuentre (in-order). El árbol
     * conserva su orden in-order.
     * @param elemento el elemento a eliminar.
     */
    @Override public void elimina(T elemento) {
        Nodo n = buscaNodo(raiz,elemento);
        eliminaNodo(n);
    }


    private Nodo maximoEnSubarbolIzquierdo(Nodo n){
        //Aqui va tu codigo
    }

    /**
     * Nos dice si un elemento está contenido en el arbol.
     * @param elemento el elemento que queremos verificar si está contenido en
     *                 la arbol.
     * @return <code>true</code> si el elemento está contenido en el arbol,
     *         <code>false</code> en otro caso.
     */
    @Override public boolean contiene(T elemento){
        //Aqui va tu codigo
    }

    protected Nodo<T> buscaNodo(Nodo<T> n, T elemento){
        //Aqui va tu codigo
    }


    /**
     * Gira el árbol a la derecha sobre el nodo recibido. Si el nodo no
     * tiene hijo izquierdo, el método no hace nada.
     * @param nodo el nodo sobre el que vamos a girar.
     */
    public void giraDerecha(Nodo<T> nodo) {
        //Aqui va tu codigo
    }

    /**
     * Gira el árbol a la izquierda sobre el nodo recibido. Si el nodo no
     * tiene hijo derecho, el método no hace nada.
     * @param nodo el nodo sobre el que vamos a girar.
     */
    public void giraIzquierda(Nodo<T> nodo) {
        //Aqui va tu codigo
    }


    /**
     * Regresa un iterador para iterar el árbol. El árbol se itera en orden.
     * @return un iterador para iterar el árbol.
     */
    @Override public Iterator<T> iterator() {
        return new Iterador();
    }

}