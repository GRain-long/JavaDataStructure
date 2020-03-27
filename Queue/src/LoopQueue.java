/**
 * @Classname LoopQueue
 * @Description LoopQueue
 * @Date 2020/3/27
 * @Author Grain Rain
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    //队首索引
    int front;

    //队尾索引
    int tail;

    //队列默认容量为10
    private static final int DEFAULT_CAPACITY = 10;

    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 获取队列的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 入队操作,如果队列满了，则将容量扩至原来的2倍
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        //如果队列满了，则扩容
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() << 1);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 循环队列的扩容
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * 获取队列长度
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 获取队首元素
     *
     * @return
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        return data[front];
    }

    /**
     * 出队,如果队列容量变为原来的1/4，则将队列容量缩减至原来的1/2.
     *
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E result = data[front];
        front = (front + 1) % data.length;
        size--;
        //自动缩减容量
        if (size == getCapacity() >> 2 && getCapacity() >> 1 != 0) {
            resize(getCapacity() >> 1);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        sb.append("front [ ");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(", ");
            }
        }
        sb.append(" ] tail");
        return sb.toString();
    }
}
