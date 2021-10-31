import java.util.concurrent.locks.ReentrantLock;

public class FooLock {
    ReentrantLock lock = new ReentrantLock();

    public void first(Runnable r) {
        lock.lock();
        System.out.print("first");
        lock.unlock();
    }

    public void second(Runnable r) {
        lock.lock();
        System.out.print("second");
        lock.unlock();
    }

    public void third(Runnable r) {
        lock.lock();
        System.out.print("third");
        lock.unlock();
    }
}
