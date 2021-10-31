import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class FooSem {
    static Semaphore sem = new Semaphore(3);

    public void first(Runnable r) {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("first");
        sem.release();
    }

    public void second(Runnable r) {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("second");
        sem.release();
    }

    public void third(Runnable r) {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("third");
        sem.release();
    }
}