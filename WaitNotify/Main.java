package thread.WaitNotify;

public class Main {

    public static void main(String[] args) {
        String lock = new String("");
        Produce produce = new Produce(lock);
        Consumer consumer = new Consumer(lock);
        ThreadP threadP = new ThreadP();
        threadP.start();
        ThreadC threadC = new ThreadC();
        threadC.start();

    }
}
