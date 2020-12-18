import java.util.Arrays;

/**
 * @ClassName MergeSort
 * @Description TODO 归并排序
 * @Author wangyi
 * @Date 2020/12/11 19:19
 * @Version 1.0.0
 **/
public class MergeSort<E> {


    private MergeSort() {

    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 可能会发生数组越界，可以用减法表示
        //int mid = (l + r) / 2;
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);

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

    public static void main(String[] args) {
        int n = 100000;
        //SelectionSort , n = 100000 : 11.363239 s
        //InsertSort2 , n = 100000 : 13.359168 s
        //MergeSort , n = 100000 : 0.055703 s
        Integer[] array = ArrayGenerator.generateRandomArray(n, n);
        Integer[] array2 = Arrays.copyOf(array, array.length);
        Integer[] array3 = Arrays.copyOf(array, array.length);
        SortingHelper.sortTest("SelectionSort",array);
        SortingHelper.sortTest("InsertSort2",array2);
        SortingHelper.sortTest("MergeSort", array3);

    }

}
