import java.util.Iterator;
import java.lang.Comparable;
import java.util.NoSuchElementException;

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
            pila = new Pila<>();
            Nodo n = raiz;
            while (n != null){
                pila.agrega(n);
                n = n.izquierdo;
            }
        }

        /* Nos dice si hay un elemento siguiente. */
        @Override public boolean hasNext() {
            return !pila.esVacio();
        }

        /* Regresa el siguiente elemento en orden DFS in-order. */
        @Override public T next() {
            if(pila.esVacio()){
                throw  new NoSuchElementException("No hay mas elementos");
            }
            Nodo n = pila.pop();
            T elem = (T) n.elemento;
            n = n.derecho;
            while (n != null){
                pila.push(n);
                n = n.izquierdo;
            }
            return elem;
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
        super(coleccion);
    }

    protected void agregaNodo(Nodo<T> n, Nodo<T> nuevo) {
        if(n.elemento.compareTo(nuevo.elemento) >= 0){
            if (n.hayIzquierdo()){
                agregaNodo(n.izquierdo, nuevo);
            }else {
                n.izquierdo = nuevo;
                nuevo.padre = n;
            }
        }else {
            if (n.hayDerecho()){
                agregaNodo(n.derecho, nuevo);
            }else {
                n.derecho = nuevo;
                nuevo.padre = n;
            }
        }

    }

    /**
     * Agrega un nuevo elemento al árbol. El árbol conserva su orden in-order.
     * @param elemento el elemento a agregar.
     */
    @Override public void agrega(T elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El elemento enviado es nulo");
        }
        Nodo agregar = new Nodo<>(elemento);
        tamanio++;
        if (raiz == null){
            raiz = agregar;
        }else {
            agregaNodo(raiz, agregar);
        }

    }

    protected Nodo<T> eliminaNodo(Nodo<T> n){
        //Aqui va tu codigo
        return null;
    }

    /**
     * Elimina un elemento. Si el elemento no está en el árbol, no hace nada; si
     * está varias veces, elimina el primero que encuentre (in-order). El árbol
     * conserva su orden in-order.
     * @param elemento el elemento a eliminar.
     */
    @Override public void elimina(T elemento) {
        if (elemento == null){
            throw  new IllegalArgumentException("El elemento a eliminar es nulo");
        }
        Nodo n = buscaNodo(raiz,elemento);
        eliminaNodo(n);
    }


    private Nodo maximoEnSubarbolIzquierdo(Nodo n){
        if (!n.hayDerecho()){
            return n;
        }
        return maximoEnSubarbolIzquierdo(n.derecho);
    }

    /**
     * Nos dice si un elemento está contenido en el arbol.
     * @param elemento el elemento que queremos verificar si está contenido en
     *                 la arbol.
     * @return <code>true</code> si el elemento está contenido en el arbol,
     *         <code>false</code> en otro caso.
     */
    @Override public boolean contiene(T elemento){
        if (elemento == null){
            throw  new IllegalArgumentException("Elemento invalido");
        }
        return buscaNodo(raiz, elemento) != null;
    }


    protected Nodo<T> buscaNodo(Nodo<T> n, T elemento){
        if (n == null){
            return null;
        }
        if (n.elemento.equals(elemento)){
            return n;
        }
        Nodo subAIzq = buscaNodo(n.izquierdo, elemento);
        Nodo subADer = buscaNodo(n.derecho, elemento);
        return subAIzq != null ? subAIzq : subADer;
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