import java.util.Arrays;

/**
 * @ClassName InsertSort
 * @Description TODO 插入排序
 * @Author wangyi
 * @Date 2020/12/6 19:06
 * @Version 1.0.0
 **/
public class InsertSort {

    private InsertSort() {
    }

    /**
     * 插入排序的重要性
     * 对于有序数组，插入排序的复杂度是O(n)
     * 整体，插入排序的复杂度依然是O(n^2)
     * 对比选择排序，选择排序的复杂度永远是O(n^2)
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {

            //将arr[i]插入到合适的位置
/*            for (int j = i; j - 1 >= 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }*/
            // {1, 4, 2, 3, 6, 5}
            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }

        }
    }

    //优化版本的插入排序
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 将arr[i]插入到合适的位置
            E t = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    /**
     *  sort3 的基本逻辑是，从后向前扫描，对于每一个 arr[i]，寻找 arr[i...n) 区间中需要插入的位置。
     *  在具体找这个位置的时候， 我们依然是暂存 arr[i] 到 t 这个变量，之后，只要 t 比当前的 arr[j + 1] 还要大，
     *  说明 t 应该插入的位置还靠后，我们只需要让 arr[j + 1] 平行移动到 arr[j] 的位置，
     *  然后 j ++，继续看下一个 j。
     */
    // 换个方式实现插入排序
    public static <E extends Comparable<E>> void sort3(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            // 将arr[i]插入到合适的位置
            E t = arr[i];
            int j;
            for (j = i; j + 1 < arr.length && t.compareTo(arr[j + 1]) > 0; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = t;
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 4, 2, 3, 6, 5};
        InsertSort.sort3(arr);
        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }

        System.out.println();
        //测试 无序的
        int[] datasize = {10000, 100000};
        for (int n : datasize) {
            Integer[] array = ArrayGenerator.generateRandomArray(n, n);
            Integer[] array2 = Arrays.copyOf(array, array.length);
            SortingHelper.sortTest("InsertSort", array);
            SortingHelper.sortTest("InsertSort2", array2);
        }
        System.out.println("===========================================");
        // 测试有序的数组 对比选择排序和插入排序
        for (int n : datasize) {
            Integer[] array = ArrayGenerator.generateOrderedArray(n);
            Integer[] array2 = Arrays.copyOf(array, array.length);
            System.out.println("OrderedArray");
            SortingHelper.sortTest("InsertSort2", array);
            SortingHelper.sortTest("SelectionSort", array2);
            System.out.println("RandomArray");
            array = ArrayGenerator.generateRandomArray(n, n);
            array2 = Arrays.copyOf(array, array.length);
            SortingHelper.sortTest("InsertSort2", array);
            SortingHelper.sortTest("SelectionSort", array2);
            System.out.println();
        }
    }
}
