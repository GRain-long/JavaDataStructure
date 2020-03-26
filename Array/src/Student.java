/**
 * @Classname Student
 * @Description 自定义学生类
 * @Date 2020/3/26
 * @Author Grain Rain
 */
public class Student {

    private String name;

    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Studeng( name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {
        Array<Student> students = new Array<>();

        students.addLast(new Student("Java",85));
        students.addLast(new Student("Python",90));
        students.addLast(new Student("Go",95));

        System.out.println(students);
    }
}
