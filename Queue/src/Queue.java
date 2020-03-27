public interface Queue<E> {

    void enqueue(E e);

    int getSize();

    boolean isEmpty();

    E getFront();

    E dequeue();


}
