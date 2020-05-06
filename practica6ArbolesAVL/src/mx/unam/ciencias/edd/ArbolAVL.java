package mx.unam.ciencias.edd;

/**
 * <p>Clase para árboles AVL.</p>
 *
 * <p>Un árbol AVL cumple que para cada uno de sus nodos, la diferencia entre
 * la áltura de sus subárboles izquierdo y derecho está entre -1 y 1.</p>
 */
public class ArbolAVL<T extends Comparable<T>> extends ArbolBinarioBusqueda<T> {

    /**
     * Clase interna protegida para nodos de árboles AVL. La única diferencia
     * con los nodos de árbol binario, es que tienen una variable de clase
     * para la altura del nodo.
     */
    protected class NodoAVL extends Nodo {

        /** La altura del nodo. */
        public int altura;

        /**
         * Constructor único que recibe un elemento.
         * @param elemento el elemento del nodo.
         */
        public NodoAVL(T elemento) {
            super(elemento);
        }

        /**
         * Regresa la altura del nodo.
         * @return la altura del nodo.
         */
        @Override public int altura() {
            return super.altura();
        }


        /**
         * Regresa una representación en cadena del nodo AVL.
         * @return una representación en cadena del nodo AVL.
         */
        @Override public String toString() {
            return super.toString();
        }

        /**
         * Compara el nodo con otro objeto. La comparación es
         * <em>recursiva</em>.
         * @param o el objeto con el cual se comparará el nodo.
         * @return <code>true</code> si el objeto es instancia de la clase
         *         {@link NodoAVL}, su elemento es igual al elemento de éste
         *         nodo, los descendientes de ambos son recursivamente
         *         iguales, y las alturas son iguales; <code>false</code> en
         *         otro caso.
         */
        @Override public boolean equals(Object o) {
            return super.equals(o);
        }
    }

    /**
     * Constructor sin parámetros. Para no perder el constructor sin parámetros
     * de {@link ArbolBinarioBusqueda}.
     */
    public ArbolAVL() {
        super();
    }

    /**
     * Construye un árbol rojinegro a partir de una colección. El árbol
     * rojinegro tiene los mismos elementos que la colección recibida.
     * @param coleccion la colección a partir de la cual creamos el árbol
     *        rojinegro.
     */
    public ArbolAVL(Coleccionable<T> coleccion) {
        super(coleccion);
    }

    /**
     * Construye un nuevo nodo, usando una instancia de {@link NodoAVL}.
     * @param elemento el elemento dentro del nodo.
     * @return un nuevo nodo con el elemento recibido dentro del mismo.
     */
    @Override protected NodoAVL nuevoNodo(T elemento) {
        return new NodoAVL (elemento);
    }
    /**
     * Agrega un nuevo elemento al árbol. El método invoca al método {@link
     * ArbolBinarioBusqueda#agrega}, y después balancea el árbol girándolo como
     * sea necesario.
     * @param elemento el elemento a agregar.
     */
    @Override public void agrega(T elemento) {
        super.agrega(elemento);
        Nodo<T> nodoAVL = buscaNodo(raiz, elemento);
        rebalanceo((NodoAVL)nodoAVL);
        checaAltura((NodoAVL)nodoAVL);
        /**
         * Falta invocal al valanceo
         */
    }
    /**
     * Método privado que rebalance el árbol.
     */
    private void rebalanceo(NodoAVL nodo) {
        if (nodo == null){
            System.out.println("n este caso el nodo es nulo");
            return;
        }
        checaAltura(nodo);
        int balance = balanceo(nodo);
        System.out.println("Este nodo: " +nodo + " tiene balanceo: " + balance);
        if (balance == 2){
            System.out.println("Entro al caso en el que la direfencia es 2");
            NodoAVL n = nuevoNodo((T) nodo.izquierdo.elemento);
            if (balanceo(n) == -1){
                giraIzquierdaAVL(n);
            }
            giraDerechaAVL(nodo);

        }
        else if (balance == -2){
            System.out.println("Entro al caso en el que la direfencia es -2");
            NodoAVL n = nuevoNodo((T) nodo.derecho.elemento);
            if (balanceo(n) == 1){
                giraDerechaAVL(n);
            }
            giraIzquierdaAVL(nodo);
        }
        rebalanceo((NodoAVL) nodo.padre);
    }

    private int balanceo(NodoAVL n){
        System.out.println("El el nodo: " + n + " el balanceo va como, iz: " + getAltura((NodoAVL)n.izquierdo) +" der: " + getAltura((NodoAVL)n.derecho));
        return getAltura((NodoAVL) n.izquierdo) -getAltura((NodoAVL)n.derecho);
    }

    /**
     * Elimina un elemento del árbol. El método elimina el nodo que contiene
     * el elemento, y gira el árbol como sea necesario para rebalancearlo.
     * @param elemento el elemento a eliminar del árbol.
     */
    @Override public void elimina(T elemento) {
        Nodo<T> nodo = buscaNodo(raiz, elemento);
        super.elimina(elemento);
        rebalanceo((NodoAVL) nodo);
    }

    /**
     * Lanza la excepción {@link UnsupportedOperationException}: los árboles AVL
     * no pueden ser girados a la derecha por los usuarios de la clase, porque
     * se desbalancean.
     * @param nodo el nodo sobre el que se quiere girar.
     * @throws UnsupportedOperationException siempre.
     */
    @Override public void giraDerecha(Nodo<T> nodo) {
        throw new UnsupportedOperationException("Los árboles AVL no  pueden " +
                "girar a la izquierda por el usuario.");
    }

    /**
     * Lanza la excepción {@link UnsupportedOperationException}: los árboles AVL
     * no pueden ser girados a la izquierda por los usuarios de la clase, porque
     * se desbalancean.
     * @param nodo el nodo sobre el que se quiere girar.
     * @throws UnsupportedOperationException siempre.
     */
    @Override public void giraIzquierda(Nodo<T> nodo) {
        throw new UnsupportedOperationException("Los árboles AVL no  pueden " +
                "girar a la derecha por el usuario.");
    }

    private void checaAltura(NodoAVL n){
        n.altura = altura();
    }
    private void giraDerechaAVL(NodoAVL p){
        super.giraDerecha(p);
        checaAltura(p);
        checaAltura((NodoAVL) p.padre);
    }
    private void giraIzquierdaAVL(NodoAVL p){ // Aquí suponemos que p tiene hijo derecho q
        super.giraIzquierda(p);
        checaAltura(p);
        checaAltura((NodoAVL) p.padre);
    }
    private int getAltura(NodoAVL v){
        return (v == null) ? -1 : v.altura;
    }

}