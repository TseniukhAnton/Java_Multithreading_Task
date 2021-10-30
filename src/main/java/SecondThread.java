public class SecondThread implements Runnable {
    Foo foo;
    Thread t;

    SecondThread(Foo f) {
        foo = f;
        t = new Thread(this, "Thread2");
        //System.out.println("Thread created: " + t);
        t.start();
    }

    @Override
    public void run() {
        try {
            foo.second(this);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
