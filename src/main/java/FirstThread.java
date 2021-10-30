public class FirstThread implements Runnable {
    Foo foo;
    Thread t;

    FirstThread(Foo f) {
        foo = f;
        t = new Thread(this, "Thread1");
        //System.out.println("Thread created: " + t);
        t.start();
    }

    @Override
    public void run() {
        try {
            foo.first(this);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
