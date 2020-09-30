package linked_list;

import java.util.concurrent.atomic.AtomicInteger;

public class Runner implements Runnable {

    private ConcurrentLinkedList<Integer> list;
    private AtomicInteger count;

    public Runner(ConcurrentLinkedList<Integer> list) {
        this.list = list;
        this.count = new AtomicInteger(0);
    }

    @Override
    public void run() {
        if (!list.contains(count.get())) {
            list.add(count.getAndIncrement());
        }
    }
}
