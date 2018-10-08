package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class TestVolatile {

//    public volatile  int inc = 0;
    private AtomicInteger inc = new AtomicInteger();
//    Lock lock = new ReentrantLock();

    public  void increase(){
//        lock.lock();
            inc.getAndIncrement();
//            lock.unlock();


    }

    public static void main(String[] args) {
        final TestVolatile testVolitale = new TestVolatile();
        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run(){
                    for(int j=0;j<1000;j++)
                        testVolitale.increase();
                }
            }.start();

        }
        System.out.println(Thread.activeCount());
        System.out.println(testVolitale.inc);
    }

}
