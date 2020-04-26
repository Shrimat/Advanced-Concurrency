import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {
  private boolean inUse;
  private Lock lock;

  public ChopStick() {
    putDown();
    this.lock = new ReentrantLock();
  }

  public void pickUp() {
    this.inUse = true;
  }

  public void putDown() {
    this.inUse = false;
  }

  public boolean isInUse() {
    return inUse;
  }

  public void lock() {
    lock.lock();
  }

  public void unlock() {
    lock.unlock();
  }

}
