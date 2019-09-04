package thread.ReentrantLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWrite {
    ReentrantReadWriteLock reentrantReadWrite = new ReentrantReadWriteLock();
    public void methodA(){

        try {
            reentrantReadWrite.readLock().lock();
            System.out.println("A"+System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantReadWrite.readLock().unlock();
        }
    }

    public void methodB(){
        try {
            reentrantReadWrite.readLock().lock();
            System.out.println("B"+System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantReadWrite.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWrite reentrantReadWrite = new ReentrantReadWrite();
        RA ra = new RA(reentrantReadWrite);
        ra.start();
        RB rb = new RB(reentrantReadWrite);
        rb.start();

    }
}
class RA extends Thread{
    ReentrantReadWrite reentrantReadWrite = new ReentrantReadWrite();

    public RA(ReentrantReadWrite reentrantReadWrite) {
        this.reentrantReadWrite = reentrantReadWrite;
    }

    @Override
    public void run() {
        super.run();
        reentrantReadWrite.methodA();
    }
}

class RB extends Thread{
    ReentrantReadWrite reentrantReadWrite = new ReentrantReadWrite();

    public RB(ReentrantReadWrite reentrantReadWrite) {
        this.reentrantReadWrite = reentrantReadWrite;
    }

    @Override
    public void run() {
        super.run();
        reentrantReadWrite.methodB();
    }
}