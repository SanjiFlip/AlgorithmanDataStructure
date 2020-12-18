/**
 * @ClassName IntSelectionSort
 * @Description TODO int类型的选择排序
 * @Author wangyi
 * @Date 2020/12/6 17:09
 * @Version 1.0.0
 **/
public class IntSelectionSort {

    private IntSelectionSort() {
    }

    //原地排序 不开辟新空间
    public static void sort(int[] arr) {
        // arr[0...i)是有序的  arr[i...n)是无序的
        // 每次处理的都是i的位置，i的位置就是第i小的值
        for (int i = 0; i < arr.length; i++) {
            // 选择 arr[i,n)中最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //交换位置
            swap(arr, i, minIndex);
        }
    }

    public static void sort1(int[] arr) {
        for (int i = arr.length - 1; i >=0; i--) {
            // 选择 arr[i,n)中最小值的索引
            int maxIndex = i;
            for (int j = i; j >= 0; j--) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            //插入位置
            swap(arr,i,maxIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3, 6, 5};
        IntSelectionSort.sort(arr);
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();

        int[] arr1 = {1, 4, 2, 3, 6, 5};
        IntSelectionSort.sort1(arr1);
        for (int i : arr1) {
            System.out.print(i + " ");
        }
    }
}
