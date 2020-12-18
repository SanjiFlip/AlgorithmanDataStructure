/**
 * @ClassName StudentMain
 * @Description TODO
 * @Author wangyi
 * @Date 2020/12/5 23:35
 * @Version 1.0.0
 **/
public class StudentMain {
    public static void main(String[] args) {
        Student[] students = {new Student("Alice"),
                              new Student("Bobo"),
                              new Student("Charles")};
        Student bobo = new Student("bobo");
        int res3 = LinearSearch.search(students,bobo);
        System.out.println(res3);
    }
}
