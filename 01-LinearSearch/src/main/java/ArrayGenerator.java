/**
 * @ClassName ArrayGenerator
 * @Description TODO 数组生成器
 * @Author wangyi
 * @Date 2020/12/6 15:43
 * @Version 1.0.0
 **/
public class ArrayGenerator {

    public ArrayGenerator() {
    }

    public static Integer[] generateOrderedArray(int n){
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
