public class Foo {
    public synchronized void first(Runnable r) {
        System.out.print("first");
    }

    public synchronized void second(Runnable r) {
        System.out.print("second");
    }

    public synchronized void third(Runnable r) {
        System.out.print("third");
    }
}