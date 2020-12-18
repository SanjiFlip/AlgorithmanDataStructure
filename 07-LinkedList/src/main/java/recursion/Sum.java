package recursion;

/**
 * @ClassName Sum
 * @Description TODO 递归解决问题
 * @Author wangyi
 * @Date 2020/12/11 12:33
 * @Version 1.0.0
 **/
public class Sum {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    // 计算arr[l-n）这个区间内所有数字的和
    private static int sum(int[] arr, int l) {
        // 求解最基本的问题
        if (l == arr.length) {
            return 0;
        }
        // 把原问题转化为更小的问题
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(sum(nums));
    }

}
