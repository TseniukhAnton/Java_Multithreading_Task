public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        FirstThread f = new FirstThread(foo);
        SecondThread s = new SecondThread(foo);
        ThirdThread thrd = new ThirdThread(foo);

        System.out.println("First Thread isAlive: " + f.t.isAlive());
        System.out.println("Second Thread isAlive: " + s.t.isAlive());
        System.out.println("Third Thread isAlive: " + thrd.t.isAlive());

        try{
            System.out.println("Wait for threads' completion");
            f.t.join();
            s.t.join();
            thrd.t.join();
        }catch (InterruptedException exc){
            System.out.println("Main thread interrupted");
        }

        System.out.println("First Thread isAlive: " + f.t.isAlive());
        System.out.println("Second Thread isAlive: " + s.t.isAlive());
        System.out.println("Third Thread isAlive: " + thrd.t.isAlive());

        System.out.println("Main thread completed");
    }
}
