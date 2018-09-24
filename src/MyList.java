public interface MyList<E> {
    void add(E element);
    int size();
    void add(int index, E element);
    void resize(int length);
    Object get(int index);
    void remove(int index);
    void remove(E element);
    boolean isEmpty();
    boolean contains(E element);
    void clear();
    int indexOf(E element);
    void set(int index, E element);
}
