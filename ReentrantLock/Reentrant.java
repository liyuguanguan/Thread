package thread.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Reentrant {
    public static void main(String[] args) {
         ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        Condition condition = reentrantLock.newCondition();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
