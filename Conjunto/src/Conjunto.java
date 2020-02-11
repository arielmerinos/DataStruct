import java.util.Iterator;

/**
 * Esta clase permite el correcto manejo de los objetos de tipo conjunto, presenta las opraciones basicas como TAD y tambien
 * plantea operaciones entre dos conjuntos
 * @author Ariel Merino Peña 317031326
 * @version 1
 */
public class Conjunto implements Conjuntable, Iterable{

    public Iterator iterator(){
        return new Iterador();
    }

    private class Iterador implements Iterator{
        private int posicion;
        
        public Iterador(){
            posicion = 0;
        }

        public boolean hasNext(){
            return posicion < cardinal;
        }

        public Object next(){
            return items[posicion++];
        }

        public void remove(){

        }

    }
    private Object[] items;
    private int cardinal;

    /**
     * Constructor por omision
     */
    public Conjunto(){
        this(2);
    }

    /**
     * Constructor que sirve para construir un conjunto de un tamaño dado
     * @param size tamaño del arreglo
     */
    public Conjunto(int size){
        items = new Object[size <= 0 ? 20 : size];
        cardinal = 0;
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }
    }

    /**
     * Constructor que hace una copia de otro conjunto
     * @param conjunto Conjunto que sera copiado
     */
    public Conjunto(Conjunto conjunto){
        items = new Object[conjunto.items.length];
        for (int i = 0; i < conjunto.items.length ; i++) {
            items[i] = conjunto.items[i];
        }
    }

    @Override
    public void addItem(Object item) {
        if(!contains(item)){
            items[cardinal] = item;
        }
    }

    @Override
    public void eraseItem(Object item) {
        if (!isEmpty()){
            for (int i = 0; i < cardinal; i++) {
                if (item.equals(items[i])){
                    items[i] = null;
                    return;
                }
            }
        }
    }

    @Override
    public boolean contains(Object item) {
        if (!isEmpty()){
            for (int i = 0; i < cardinal ; i++) {
                if (items[i].equals(item)) return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < cardinal ; i++) {
            if(items[i] != null) return false;
        }
        return true;
    }

    @Override
    public int size() {
        return cardinal;
    }

    @Override
    public void throwAll() {
        for (int i = 0; i < cardinal ; i++) {
            items[i] = null;
        }
    }

    @Override
    public Conjuntable union(Conjuntable conjunto1) {

        return null;
    }

    @Override
    public Conjuntable intersection() {
        return null;
    }

    @Override
    public Conjuntable diff() {
        return null;
    }

    @Override
    public boolean subSet(Conjuntable conjunto) {
        if (conjunto.size() <= cardinal){
            for (int i = 0; i < conjunto.size() ; i++) {
                if (contains(items[i])){

                }
            }
        }
        return false;
    }
}
