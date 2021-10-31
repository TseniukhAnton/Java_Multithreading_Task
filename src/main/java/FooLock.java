import java.util.ConcurrentModificationException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class FooLock {
    private final Lock lock = new ReentrantLock();
    private final Condition cond = lock.newCondition();

    public void first(Runnable r) throws InterruptedException {
        try {
            lock.lock();
            //cond.await();
            System.out.print("first");
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable r) {
        try {
            lock.lock();
            System.out.print("second");
            cond.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable r) {
        try {
            lock.lock();
            System.out.print("third");
        } finally {
            lock.unlock();
        }
    }
}
