/**
 * Esta clase permite el correcto manejo de los objetos de tipo conjunto, presenta las opraciones basicas como TAD y tambien
 * plantea operaciones entre dos conjuntos
 * @author Ariel Merino Peña 317031326
 * @version 1
 */
public class Conjunto implements Conjuntable{
    private Object[] items;

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

    }

    @Override
    public void eraseItem(Object item) {

    }

    @Override
    public boolean contains(Object item) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void throwAll() {

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
        return false;
    }
}
