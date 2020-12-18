/**
 * @ClassName Main
 * @Description TODO
 * @Author wangyi
 * @Date 2020/12/7 20:23
 * @Version 1.0.0
 **/
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int[] scores = new int[]{100,66,98};
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }
        for (int score : scores) {
            System.out.println(score);
        }
    }
}
