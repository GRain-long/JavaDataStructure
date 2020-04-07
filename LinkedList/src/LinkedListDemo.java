/**
 * @Classname LinkedListDemo
 * @Description TODO
 * @Date 2020/3/31
 * @Author Grain Rain
 */
public class LinkedListDemo {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        /*linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);*/


        int[] nums = new int[]{1, 2, 3, 4, 5};
        int count = sum(nums, 10);
        System.out.println(count);

    }

    public static int sum(int[] nums, int l) {


        return l == 0 ? 0 : nums[l - 1] + sum(nums, l - 1);
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);

        return head.val == val ? head.next : head;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
