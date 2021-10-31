import java.sql.Time;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class FooDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Foo foo = new Foo();
        CompletableFuture<Void> printFirst = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(this::run);
                    TimeUnit.SECONDS.sleep(5);
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
                    TimeUnit.SECONDS.sleep(5);
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
                    TimeUnit.SECONDS.sleep(5);
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

