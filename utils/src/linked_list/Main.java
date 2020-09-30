package linked_list;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

    private final static int NUM_THREADS = 10;

    public static void main(String[] args) {
        ConcurrentLinkedList<Integer> list = new ConcurrentLinkedList<>();

        Runner myTask = new Runner(list);

        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < 100; i++) {
            service.execute(myTask);
        }
        service.shutdown();

        System.out.println(list);

    }
}
