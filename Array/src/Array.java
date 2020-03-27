/**
 * @Classname Array
 * @Description 手写动态数组
 * @Date 2020/3/26
 * @Author Grain Rain
 */
public class Array<E> {

    private E[] data;

    //数组大小
    private int size;

    //默认初始容量
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 初始化数组大小
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 默认初始化
     */
    public Array() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 返回数组大小
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回数组容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组尾部添加元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 向数组首部添加元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 向数组索引处添加元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed , Requires index >=0 and index < size");
        }

        if (size == data.length) {
            resize((data.length >> 1) + data.length);
        }

        for (int i = size - 1; i > index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 返回索引处的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, index is illegal");
        }
        return data[index];
    }

    /**
     * 返回数组第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 返回数组最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改索引处的元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, index is illegal");
        }
        data[index] = e;
    }

    /**
     * 判断数组是否包含元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        /*for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;*/
        return find(e) >= 0;
    }

    /**
     * 查找元素e所在的索引(默认返回查找到的第一个元素的位置)，如果不包含元素e，则返回-1
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除指定位置的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed, index is illegal");
        }

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;  //loitering objects != memory leak

        if (size == data.length >> 2 && data.length >> 1 != 0) {
            resize(data.length >> 1);
        }

        return data[index];
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除指定元素
     *
     * @param e
     * @return
     */
    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * 数组的动态容量变化机制
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d , capacity = %d \n", size, data.length));
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
