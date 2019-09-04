package thread.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class JiaoCha {


    public ReentrantLock reentrantLock = new ReentrantLock(true);
    public Condition condition = reentrantLock.newCondition();
    private Boolean hasValue = true;
    public void methodA(){


            try {
                reentrantLock.lock();
                while (hasValue == false){
                condition.await();
                }
                System.out.println("打印※"+reentrantLock.getHoldCount()+reentrantLock.getQueueLength()+reentrantLock.getWaitQueueLength(condition));
                hasValue = false;
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }

    }

    public void methodB(){


        try {
            reentrantLock.lock();
            while (hasValue == true){
                condition.await();

            }
            System.out.println("打印哈哈");
            hasValue = true;
            condition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }
}
class ThreadAA extends Thread{
    private JiaoCha JiaoCha;

    public ThreadAA(thread.ReentrantLock.JiaoCha jiaoCha) {
        JiaoCha = jiaoCha;
    }

    @Override
    public  void  run(){
        for (int i=0;i<Integer.MAX_VALUE;i++){
            JiaoCha.methodA();
        }
    }
}
class ThreadBB extends Thread{
    private JiaoCha JiaoCha;

    public ThreadBB(thread.ReentrantLock.JiaoCha jiaoCha) {
        JiaoCha = jiaoCha;
    }

    @Override
    public  void  run(){
        for (int i=0;i<Integer.MAX_VALUE;i++){
            JiaoCha.methodB();
        }

    }
}
class  mainA{
    public static void main(String[] args) {
        JiaoCha jiaoCha = new JiaoCha();
        ThreadAA threadAA = new ThreadAA(jiaoCha);
        threadAA.start();
        ThreadBB threadBB = new ThreadBB(jiaoCha);
        threadBB.start();
    }
}