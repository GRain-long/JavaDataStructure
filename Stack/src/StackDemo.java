

/**
 * @Classname StackDemo
 * @Description StackDemo
 * @Date 2020/3/26
 * @Author Grain Rain
 */
public class StackDemo {

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
