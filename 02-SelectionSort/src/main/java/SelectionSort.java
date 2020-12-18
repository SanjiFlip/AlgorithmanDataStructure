/**
 * @ClassName SelectionSort
 * @Description TODO 选择排序
 * @Author wangyi
 * @Date 2020/12/6 16:24
 * @Version 1.0.0
 **/
public class SelectionSort {

    private SelectionSort() {
    }

    /**
     * 每次取出最小的放到前面的位置，最小的和前面交换位置 --原地排序 不开辟新空间
     * <E extends Comparable<E>> 继承Comparable接口，可比较的
     *
     * @param arr
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        // arr[0...i)是有序的  arr[i...n)是无序的
        // 每次处理的都是i的位置，i的位置就是第i小的值
        for (int i = 0; i < arr.length; i++) {
            // 选择 arr[i,n)中最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            //交换位置
            swap(arr, i, minIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        // 基本数据类型排序
/*        Integer[] arr = {1, 4, 2, 3, 6, 5};
        SelectionSort.sort(arr);
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();*/

        // 自定义类排序
/*        Student[] students = {new Student("Alice", 92),
                new Student("Bob", 100),
                new Student("Tom", 66)};
        SelectionSort.sort(students);
        for (Student student : students) {
            System.out.print(student + " ");
        }
        System.out.println();*/

        // 生成随机数组排序
/*        int n = 10000;
        Integer[] array = ArrayGenerator.generateRandomArray(n, n);
        long startTime = System.nanoTime();
        SelectionSort.sort(array);
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        if (!SortingHelper.isSorted(array)){
            throw new RuntimeException("SelectionSort failde!");
        }
        System.out.print(time + " s");
        System.out.println();*/

        //测试
        int[] datasize = {10000,100000};
        for (int n : datasize) {
            Integer[] array1 = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort",array1);
        }
    }

}
