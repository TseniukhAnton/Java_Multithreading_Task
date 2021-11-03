import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class FooDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Foo2 foo = new Foo2();
        CompletableFuture<Void> printFirst = CompletableFuture.runAsync(new Runnable() {
           @Override
            public void run(){
               try {
                   foo.first();
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
                    foo.second();
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
                    foo.third();
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(Thread.activeCount());
        printFirst.get();
        printSecond.get();
        printThird.get();
    }
}

