/**
 * @Classname LinkedList
 * @Description LinkedList
 * @Date 2020/3/27
 * @Author Grain Rain
 */
public class LinkedList<E> {

    private class Node {
        E e;
        Node next;
        Node prev;


        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;

    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表中元素的个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 往index处添加元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 头插法添加元素e
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 尾插法插入链表元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }


    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Get failed. illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取最后一个元素
     * @param index
     * @return
     */
    public E getLast(int index){
        return get(size - 1);
    }

    /**
     * 修改index位置的元素
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if (index<0||index>=size) {
            throw new IllegalArgumentException("Set failed, illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;

    }

    /**
     * 查找链表中是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除链表中index中的位置
     * @param index
     * @return
     */
    public E remove (int index){

        if(index<0||index>=size){
            throw new IllegalArgumentException("Remove failed, illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    /**
     * 删除第一个元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除最后一个元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while(cur!=null){
            sb.append(cur + " -> ");
            cur = cur.next;
        }
        return sb.toString();
    }
}
