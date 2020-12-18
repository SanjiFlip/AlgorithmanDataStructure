/**
 * @ClassName SortingHelper
 * @Description TODO
 * @Author wangyi
 * @Date 2020/12/6 17:32
 * @Version 1.0.0
 **/
public class SortingHelper {

    private SortingHelper() {
    }

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortname,E[] arr){
        long startTime = System.nanoTime();
        switch (sortname) {
            case "SelectionSort":
                SelectionSort.sort(arr);
                break;
            case "InsertSort":
                InsertSort.sort(arr);
                break;
            case "InsertSort2":
                InsertSort.sort2(arr);
                break;
            case "MergeSort":
                MergeSort.sort(arr);
                break;
            case "MergeSortTest":
                MergeSortTest.sort(arr);
                break;
            case "MergeSort2":
                MergeSort2.sort(arr);
                break;
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        if (!SortingHelper.isSorted(arr)){
            throw new RuntimeException(sortname + " failde!");
        }
        System.out.println(String.format("%s , n = %d : %f s",sortname,arr.length,time));
    }
}
