import java.util.Arrays;
import java.util.Iterator;

/**
 * Esta clase permite el correcto manejo de los objetos de tipo conjunto, presenta las opraciones basicas como TAD y tambien
 * plantea operaciones entre dos conjuntos
 * @author Ariel Merino Peña 317031326
 * @version 1
 */
public class Conjunto<T> implements Iterable<T> {

    @Override
    public java.util.Iterator<T> iterator() {
        return new Iterador();
    }
    /**
     * Permite el correcto manejro de los iteradores
     * @param <T> tipo sobre los cuales va a iterar
     */
    private class Iterador<T> implements Iterator<T> {
        private int posicion;

        /**
         * Constructor por omision
         */
        public Iterador() {
            posicion = 0;
        }

        @Override
        public boolean hasNext() {
            return posicion < cardinal;
        }

        @Override
        public T next() {
            return (T) items[posicion++];
        }

        @Override
        public void remove() {

        }

    }

    /**
     * Arreglo que guardara los elementos del conjunto
     */
    private T[] items;
    /**
     * Varible contador que servira para conocer el numero de elementos en un conjunto
     */
    private int cardinal;

    /**
     * Constructor por omision
     */
    public Conjunto() {
        this(1);
    }

    /**
     * Constructor que sirve para construir un conjunto de un tamaño dado
     *
     * @param size tamaño del arreglo
     */
    public Conjunto(int size) {
        items = (T[]) new Object[size <= 0 ? 20 : size];
        cardinal = 0;
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }
    }

    /**
     * Constructor que hace una copia de otro conjunto
     *
     * @param conjunto Conjunto que sera copiado
     */
    public Conjunto(Conjunto conjunto) {
        items = (T[]) new Object[conjunto.items.length];
        for (int i = 0; i < conjunto.items.length; i++) {
            this.items[i] = (T) conjunto.items[i];
        }
    }

    /**
     * Agrega elementos al conjunto si es que aun no existian
     * @param item elemento candidato a ser añadido
     */
    public void addItem(T item) {
        if (!contains(item)) {
            if (items.length <= cardinal) {
                T[] aux = (T[]) new Object[cardinal + 2];
                for (int i = 0; i < cardinal; i++) {
                    aux[i] = items[i];
                }
                items = aux;
            }
            items[cardinal] = item;
            cardinal++;
        }
    }

    /**
     * Elimina un elemento del conjunto, en caso de no encontrarlo terminara el metodo
     * @param item elemento que sera eliminado
     */
    public void eraseItem(T item) {
        for (int i = 0; i < cardinal; i++) {
            if (item.equals(items[i])) {
                for (int j = i; j < cardinal - 1; j++) {
                    items[j] = items[j + 1];
                }
                cardinal--;
                return;
            }
        }
    }

    /**
     * Busca un elemento en el conjunto
     * @param item elemento que buscara en el conjunto
     * @return Verdadero si lo ha encontrado, falso en otro caso.
     */
    public boolean contains(T item) {
        for (int i = 0; i < cardinal; i++) {
            if (items[i].equals(item)) return true;
        }
        return false;
    }

    /**
     * Verifica si tiene elementos un conjunto
     * @return si el conjunto tiene o no elementos
     */
    public boolean isEmpty() {
        return cardinal > 0 ? true: false;
    }

    /**
     * Permite acceder al cardinal del conjunto
     * @return el tamaño del conjunto (cuantos elemetnos tiene)
     */
    public int size() {
        return cardinal;
    }

    /**
     * Vacia completamente el conjunto para dejarlo sin elementos
     */
    public void throwAll() {
        cardinal = 0;
    }

    /**
     * Permite unir dos conjuntos, hacer que los elementos de ambos esten en un nuevo conjnto
     * @param conjunto1 Conjunto con el cual se hara la conjuncion
     * @return nuevo conjunto con elementos de ambos conjuntos
     */
    public Conjunto<T> union(Conjunto<T> conjunto1) {
        Conjunto<T> union = new Conjunto<>(cardinal + conjunto1.size());
        for (T elem : conjunto1) {
            if(!union.contains(elem)){
                union.addItem(elem);
            }
        }
        for (T elem : this) {
            if(!union.contains(elem)){
                union.addItem(elem);
            }
        }
        return union;
    }

    /**
     * Permite realizar la interseccion de dos conjuntos
     * @return elementos que estan en un conjunto y estan en el segundo
     */
    public Conjunto<T> intersection(Conjunto<T> conjunto) {

        Conjunto intersectionSet = new Conjunto(conjunto.size());

        Iterator it = iterator();
        while (it.hasNext()) {
            T elemento = (T) it.next();
            if (conjunto.contains(elemento)){
                intersectionSet.addItem(elemento);
            }
        }
        return intersectionSet;
    }

    /**
     * Realiza la diferencia entre dos conjuntos
     * @return Nuevo cnjunto que contiene los elementos que se encontraron en el primer conjunto y no en el segundo
     */
    public Conjunto<T> diff(Conjunto<T> conjunto) {
        Conjunto diferentialSet = new Conjunto(conjunto.size());
        Iterator it = iterator();

        while (it.hasNext()) {
            T elemento = (T) it.next();
            if (!conjunto.contains(elemento))
                diferentialSet.addItem(elemento);
        }
        return diferentialSet;
    }

    public Conjunto<T> simetricDiff(Conjunto<T> conjuntoP){
        Conjunto primeraParte = conjuntoP.diff(this);
        Conjunto segundaParte = this.diff(conjuntoP);
        Conjunto result = primeraParte.union(segundaParte);
        return result;
    }

    /**
     * Verifica si un conjunto dado es subconjnto de otro
     * @param conjunto conjunto que se validara como subconjunto del que fue aplicado el metodo
     * @return verdadero en caso de que todos los elementos del conjunto dado esten en el segundo, en el caso contrario falso
     */
    public boolean subSet(Conjunto<T> conjunto) {
        if (conjunto.size() <= cardinal) {
            for (T elemento : conjunto) {
                if (!contains(elemento)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        Iterador it = new Iterador();
        StringBuilder std = new StringBuilder();

        while (it.hasNext()){
            std.append(it.next() + ", ");
        }
        String result = "";
        if (std.length() > 1){
            result = std.substring(0,std.length() - 2);
        }
        return "{" + result + "}";
    }
}
