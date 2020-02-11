
public interface Conjuntable {
    public void addItem(Object item);
    public void eraseItem(Object item);
    public boolean contains(Object item);
    public boolean isEmpty();
    public int size();
    public void throwAll();
    public Conjuntable union(Conjuntable conjunto1);
    public Conjuntable intersection();
    public Conjuntable diff();
    public boolean subSet(Conjuntable conjunto);
}
