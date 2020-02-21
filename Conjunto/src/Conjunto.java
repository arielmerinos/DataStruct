import java.util.Iterator;

/**
 * Esta clase permite el correcto manejo de los objetos de tipo conjunto, presenta las opraciones basicas como TAD y tambien
 * plantea operaciones entre dos conjuntos
 * @author Ariel Merino Peña 317031326
 * @version 1
 */
public class Conjunto<T> implements Iterable<T> {

    public Iterator iterator() {
        return new Iterador();
    }

    private class Iterador implements Iterator {
        private int posicion;

        public Iterador() {
            posicion = 0;
        }

        public boolean hasNext() {
            return posicion < cardinal;
        }

        public Object next() {
            return items[posicion++];
        }

        public void remove() {

        }

    }

    private T[] items;
    private int cardinal;

    /**
     * Constructor por omision
     */
    public Conjunto() {
        this(2);
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
            items[i] = (T) conjunto.items[i];
        }
    }

    public void addItem(T item) {
        if (!contains(item)) {
            if (items.length < cardinal) {
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


    public boolean contains(T item) {
        for (int i = 0; i < cardinal; i++) {
            if (items[i].equals(item)) return true;
        }
        return false;
    }

    public boolean isEmpty() {
        for (int i = 0; i < cardinal; i++) {
            if (items[i] != null) return false;
        }
        return true;
    }

    public int size() {
        return cardinal;
    }

    public void throwAll() {
        for (int i = 0; i < cardinal; i++) {
            items[i] = null;
        }
    }

    public Conjunto<T> union(Conjuntable<T> conjunto1) {
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

    public Conjunto<T> intersection() {
        return null;
    }

    public Conjunto<T> diff() {
        return null;
    }

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
}
