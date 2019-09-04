package thread.WaitNotify;

import com.sun.beans.decoder.ValueObject;
import sun.applet.Main;

public class NotifyTest extends Thread{

    private Object lock;

    public NotifyTest(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run(){
        synchronized (lock){
            try {

                System.out.println("wait开始");
                lock.wait(5000);
                System.out.println("wait结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
class a extends Thread implements Runnable{
    private Object lock;

    public a(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run(){
        synchronized (lock){
                System.out.println("notify开始");
//                lock.notify();
                System.out.println("notify结束");

        }

    }

    public static void main(String[] args) {
        Object lock = new Object();
        NotifyTest notifyTest = new NotifyTest(lock);
        notifyTest.start();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        a a = new a(lock);
//        a.start();

    }
}
