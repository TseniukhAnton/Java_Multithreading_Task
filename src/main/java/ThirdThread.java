public class ThirdThread implements Runnable {
    Foo foo;
    Thread t;

    ThirdThread(Foo f) {
        foo = f;
        t = new Thread(this, "Thread3");
        //System.out.println("Thread created: " + t);
        t.start();
    }

    @Override
    public void run() {
        try {
            foo.third(this);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
