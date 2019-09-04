package thread.ReentrantLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantWriteWrite {

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void write(){
        reentrantReadWriteLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+""+System.currentTimeMillis());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reentrantReadWriteLock.writeLock().unlock();
    }

    public void writeb(){
        reentrantReadWriteLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+""+System.currentTimeMillis());
        reentrantReadWriteLock.writeLock().unlock();
    }

    public static void main(String[] args) {
         ReentrantWriteWrite reentrantWriteWrite = new ReentrantWriteWrite();
        write write = new write(reentrantWriteWrite);
        write.setName("A");
        write.start();
        writeB writeB = new writeB(reentrantWriteWrite);
        writeB.setName("B");
        writeB.start();
    }
}
class write extends Thread{
   private ReentrantWriteWrite reentrantWriteWrite;

    public write(ReentrantWriteWrite reentrantWriteWrite) {
        this.reentrantWriteWrite = reentrantWriteWrite;
    }

    @Override
    public void run() {
        super.run();
        reentrantWriteWrite.write();
    }
}

class writeB extends Thread{
    private ReentrantWriteWrite reentrantWriteWrite;

    public writeB(ReentrantWriteWrite reentrantWriteWrite) {
        this.reentrantWriteWrite = reentrantWriteWrite;
    }

    @Override
    public void run() {
        super.run();
        reentrantWriteWrite.writeb();
    }
}
