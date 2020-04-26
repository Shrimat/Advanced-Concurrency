public class Philosopher extends Thread {

  private ChopStick leftChop;
  private ChopStick rightChop;
  private String name;

  public Philosopher(ChopStick leftChop, ChopStick rightChop, String name) {
    this.leftChop = leftChop;
    this.rightChop = rightChop;
    this.name = name;
  }

  @Override
  public void run() {
    ChopStick first, second;
    if (leftChop.hashCode() <= rightChop.hashCode()) {
      first = leftChop;
      second = rightChop;
    } else {
      first = rightChop;
      second = leftChop;
    }

    while (true) {
      first.lock();
      System.out.println(name + " is using his left chopstick");
      second.lock();
      System.out.println(name + " is using his right chopstick. Eating.");
      eater();
      second.unlock();
      first.unlock();
      thinker();
    }
  }

  private void thinker() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {}
  }

  private void eater() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) { }
  }

}
