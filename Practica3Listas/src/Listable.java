public interface Listable<T> {
    /**
     * Se agrega siempre al inicio de la
     * @param elem
     */
    public void addFirst(T elem);
    public void addEnd(T elem);
    public void erase(T elem);
    public boolean contains(T elem);
    public void throwAll();
    public boolean isEmpty();

    /**
     * Devuelve el numero de elementos de una lista
     * @return elementos
     */
    public int size();
}
