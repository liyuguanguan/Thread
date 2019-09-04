package thread.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition conditionA = reentrantLock.newCondition();
    private  Condition conditionB = reentrantLock.newCondition();

    public void awaitA(){

        try {
            reentrantLock.lock();

            System.out.println("begin awaitA时间为" + System.currentTimeMillis() + "ThreadName=" + Thread.currentThread().getName());
            conditionA.await();
            System.out.println("end awaitA时间为" + System.currentTimeMillis() + "ThreadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void awaitB(){

        try {
            reentrantLock.lock();
            System.out.println("begin awaitB时间为" +System.currentTimeMillis()+"threadName=" + Thread.currentThread().getName());
            conditionB.await();
            System.out.println("end awaitB时间为" +System.currentTimeMillis()+"threadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public  void singalALLA(){
        try {
            reentrantLock.lock();
            conditionA.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }
    public void singalAllB(){
        reentrantLock.lock();
        conditionB.signalAll();
        reentrantLock.unlock();
    }
}
class ThreadA extends Thread{
    private MyService myService;

    public ThreadA(MyService myService) {
        this.myService = myService;
    }
    @Override
    public void run(){
        myService.awaitA();
    }
}class ThreadB extends Thread{
    private MyService myService;

    public ThreadB(MyService myService) {
        this.myService = myService;
    }
    @Override
    public void run(){
        myService.awaitB();
    }
}
class  main{
    public static void main(String[] args) {
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        threadA.setName("A");
        threadA.start();
        ThreadB threadB = new ThreadB(myService);
        threadB.setName("B");
        threadB.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myService.singalALLA();
    }
}
