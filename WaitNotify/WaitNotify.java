package thread.WaitNotify;

public class WaitNotify {

    public static void main(String[] args) {
        String lock = new String();
        System.out.println("syn上面");
        synchronized (lock){
            System.out.println("sync第一行");
            try {
                lock.wait();
                System.out.println("wait下面一行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("最后一行");
    }
}
