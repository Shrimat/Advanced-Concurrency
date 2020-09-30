package dining_philosophers;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    int numPhilosophers = Integer.parseInt(args[0]);
    List<Philosopher> philosophers = new ArrayList<>();
    List<ChopStick> chopSticks = new ArrayList<>();
    for (int i = 0; i < numPhilosophers; i++) {
      chopSticks.add(new ChopStick());
    }
    for (int i = 0; i < numPhilosophers; i++) {
      Philosopher myPhilly = new Philosopher(chopSticks.get(i),
          chopSticks.get((i + 1) % numPhilosophers),
          ("dining_philosophers.Philosopher " + (i+1)));
      myPhilly.start();
      philosophers.add(myPhilly);
    }
    try {
      for (Philosopher philly : philosophers) {
        philly.join();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}
