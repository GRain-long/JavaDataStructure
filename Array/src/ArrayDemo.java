/**
 * @Classname ArrayDemo
 * @Description 动态数组Demo
 * @Date 2020/3/26
 * @Author Grain Rain
 */
public class ArrayDemo {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(20);

        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }

        System.out.println(arr);
    }
}
