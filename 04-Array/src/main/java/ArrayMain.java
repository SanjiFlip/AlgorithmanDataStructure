/**
 * @ClassName ArrayMain
 * @Description TODO
 * @Author wangyi
 * @Date 2020/12/7 22:14
 * @Version 1.0.0
 **/
public class ArrayMain {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.add(1,100);
        System.out.println(arr);
        arr.addFirst(1000);
        System.out.println(arr);

        // [1000, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
    }
}
