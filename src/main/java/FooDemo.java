import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class FooDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FooLock foo = new FooLock();
        CompletableFuture<Void> printFirst = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(this::run);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        CompletableFuture<Void> printSecond = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second(this::run);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        CompletableFuture<Void> printThird = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third(this::run);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        printFirst.get();
        printSecond.get();
        printThird.get();
    }
}

