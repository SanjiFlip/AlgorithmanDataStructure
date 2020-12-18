/**
 * @ClassName LinearSearch
 * @Description TODO 线性查找
 * @Author wangyi
 * @Date 2020/12/5 22:47
 * @Version 1.0.0
 **/
public class LinearSearch {
    /**
     * 使用泛型
     * 不可以是基本数据类型，只能是 类对象
     * boolean，byte ，char，short，int，long，float，double
     * 每个基本数据类型都有对应的包装类
     * Boolean，Byte，Character，Short，Integer，Long，Float，Double
     */

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            // == 是表示引用相等  equals表示值相等
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] datasize = {1000000, 10000000};
        for (int n : datasize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);
            long start = System.nanoTime();
            for (int k = 0; k < 100; k++) {
                LinearSearch.search(data, n);
            }
            long end = System.nanoTime();
            double time = (end - start) / 1000000000.0;
            System.out.println("n= " + n + ", 100 runs:" + time + " s");
        }

    }

}
