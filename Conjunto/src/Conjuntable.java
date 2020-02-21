
public interface Conjuntable<T> extends Iterable<T> {

    void addItem(T item);
    public void eraseItem(T item);
    public boolean contains(T item);
    public boolean isEmpty();
    public int size();
    public void throwAll();
    public Conjuntable<T> union(Conjuntable<T> conjunto1);
    public Conjuntable intersection();
    public Conjuntable diff();
    public boolean subSet(Conjuntable<T> conjunto);

}
