import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FooDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Foo foo = new Foo();
        CompletableFuture<Void> printFirst = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(this::run);
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
}
