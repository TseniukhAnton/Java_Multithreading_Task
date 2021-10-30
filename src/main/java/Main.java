public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        new FirstThread(foo);
        new SecondThread(foo);
        new ThirdThread(foo);
    }
}
