public class Philosopher extends Thread {

  private ChopStick leftChop;
  private ChopStick rightChop;
  private boolean hasEaten;
  private String name;

  public Philosopher(ChopStick leftChop, ChopStick rightChop, String name) {
    this.leftChop = leftChop;
    this.rightChop = rightChop;
    this.hasEaten = false;
    this.name = name;
  }

  @Override
  public void run() {
    while (!hasEaten) {
      if (leftChop.isInUse() || rightChop.isInUse()) {
        System.out.println(name + " is thinking...");
        thinker();
      } else {
        leftChop.lock();
        leftChop.pickUp();
        rightChop.lock();
        rightChop.pickUp();
        System.out.println(name + " is eating...");
        eater();
        System.out.println(name + " has finished eating!");
        hasEaten = true;
        rightChop.putDown();
        rightChop.unlock();
        leftChop.putDown();
        leftChop.unlock();
      }

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
