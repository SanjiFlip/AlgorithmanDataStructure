public interface Stack<E> {

    // 获取大小
    int getSize();

    //判空
    boolean isEmpty();

    // 向栈中添加元素
    void push(E e);

    // 向栈中取出元素
    E pop();

    // 查看栈顶元素
    E peek();

}
