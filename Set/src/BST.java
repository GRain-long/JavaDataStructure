/**
 * @Classname BST
 * @Description 二分搜索树
 * @Date 2020/4/7
 * @Author Grain Rain
 */
public class BST<E extends Comparable<E>> {

    public void add(E e) {

    }

    public boolean contains(E e) {
        return false;
    }

    public void remove(E e) {

    }

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }


    private Node root;

    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}