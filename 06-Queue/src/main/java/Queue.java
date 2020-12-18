/**
 * @ClassName ArrayQueue
 * @Description TODO 队列接口
 * @Author wangyi
 * @Date 2020/12/8 18:43
 * @Version 1.0.0
 **/
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    // 队列中添加元素
    void enqueue(E e);

    // 队列中取出元素
    E dequeue();

    // 获取队列中的第一个元素
    E getFront();

}
