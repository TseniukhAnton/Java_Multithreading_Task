import java.util.ConcurrentModificationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Foo2 {
    private final Lock lock = new ReentrantLock(true);
    private final Condition cond = lock.newCondition();

    public void first() throws InterruptedException {
        lock.lock();
        try {
            cond.await(1, TimeUnit.SECONDS);
            cond.signal();
            System.out.print("first");
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void second() {
        lock.lock();
        try {
            cond.await(10, TimeUnit.SECONDS);
            cond.signal();
            System.out.print("second");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void third() {
        lock.lock();
        try {
            cond.await(15, TimeUnit.SECONDS);
            cond.signal();
            System.out.print("third");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
