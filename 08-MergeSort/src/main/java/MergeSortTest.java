import java.util.Arrays;

/**
 * @ClassName MergeSort
 * @Description TODO 归并排序 调试专用
 * @Author wangyi
 * @Date 2020/12/11 19:19
 * @Version 1.0.0
 **/
public class MergeSortTest<E> {


    private MergeSortTest() {

    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1, 0);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, int depth) {

        // 生成深度字符串
        String depthString = generateDepthString(depth);

        // 打印当前 sort 处理的数组区间信息
        System.out.print(depthString);
        System.out.println(String.format("mergesort arr[%d, %d]", l, r));

        if (l >= r) {
            return;
        }
        // 可能会发生数组越界，可以用减法表示
        //int mid = (l + r) / 2;
        int mid = l + (r - l) / 2;
        sort(arr, l, mid, depth + 1);
        sort(arr, mid + 1, r, depth + 1);
        // 打印这次 merge 要处理的区间范围
        System.out.print(depthString);
        System.out.println(String.format("merge arr[%d, %d] and arr[%d, %d]", l, mid, mid + 1, r));

        merge(arr, l, mid, r);

        // 打印 merge 后的数组
        System.out.print(depthString);
        System.out.print(String.format("after mergesort arr[%d, %d] :", l, r));
        for (E e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();

    }


    //合并两个有序的区间arr[l,mid] 和 arr[mid + 1, r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {

        // 数组备份第[l,r]的数组  这个方法是一个前闭后开的区间所以需要r+1
        // temp 偏移量为l
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);

        int i = l, j = mid + 1;

        // 每轮循环都是为arr[k]赋值
        for (int k = l; k <= r; k++) {
            // arr[i]和arr[j]
            // i越界
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
                // j越界
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
                //i>=j
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
                //j>i
            } else {
                arr[k] = temp[j - l];
                j++;
            }


        }

    }

    private static String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int n = 8;
        Integer[] array = ArrayGenerator.generateRandomArray(n, n);
        System.out.println(Arrays.toString(array));
        SortingHelper.sortTest("MergeSortTest", array);
    }
}
