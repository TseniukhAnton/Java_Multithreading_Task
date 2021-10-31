import java.util.concurrent.TimeUnit;

public class Foo {

    public synchronized void first(Runnable r) {
        try{
            System.out.print("first");
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void second(Runnable r) {
        try{
            System.out.print("second");
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void third(Runnable r) {
        try{
            System.out.print("third");
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}