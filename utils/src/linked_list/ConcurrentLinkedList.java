package linked_list;

import java.util.LinkedList;
import java.util.List;

public class ConcurrentLinkedList<T> {

    private List<T> myList;

    public ConcurrentLinkedList() {
        this.myList = new LinkedList<>();
    }


    public synchronized boolean add(T x) {
        return myList.add(x);
    }

    public synchronized T remove(int index) {
        return myList.remove(index);
    }

    public synchronized boolean contains(int value) {
        return myList.contains(value);
    }

    @Override
    public synchronized String toString() {
        return myList.toString();
    }
}
