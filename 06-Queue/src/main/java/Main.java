import java.util.Random;

/**
 * @ClassName Main
 * @Description TODO
 * @Author wangyi
 * @Date 2020/12/8 21:20
 * @Version 1.0.0
 **/
public class Main {

    // 测试使用q运行opCount个enqueue和dequeuq操作需要的时间单位，单位：秒
    private static double testQueue(Queue<Integer> q,int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime)/1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 1000000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue,opCount);
        System.out.println("ArrayQueue, time: "+time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue,opCount);
        System.out.println("LoopQueue, time: "+time2 + " s");
    }
}
