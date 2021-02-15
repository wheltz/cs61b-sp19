/**
 * @program: proj1b
 * @Date: 2021/2/15 15:09
 * @Author: Mr.Deng
 * @Description:
 */
public interface Deque<T> {
    public void addFirst(T item);
    public void addLast(T item);
    default public boolean isEmpty(){
        return size() == 0;
    }
    public int size();
    public void printDeque();
    public T removeFirst();
    public T removeLast();
    public T get(int index);
}
