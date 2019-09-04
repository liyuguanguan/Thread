package thread.ReentrantLock;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author: liyu.guan
 * @Date: 2019/9/3 4:43 PM
 */
public class jiaochaLockSuppor {

    private static Thread t1;
    private static Thread t2;
    private static Thread t3;
    private static volatile Boolean aaa = true;

    public static void main(String[] args) throws InterruptedException {
        char[] aa = "abcdef".toCharArray();
        char[] bb = "123456".toCharArray();
        char[] cc = "!@#$%^".toCharArray();
        for (int i = 0; i <10 ; i++) {


            t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (char a : aa) {
                        System.out.println(a);
                        LockSupport.unpark(t2);
                        LockSupport.park();
                    }
                }
            });
            t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (char b : bb) {
                        LockSupport.park();
                        System.out.println(b);
                        LockSupport.unpark(t3);


                    }
                }
            });
            t3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (char c : cc) {
                            LockSupport.park();
                            System.out.println(c);
                            LockSupport.unpark(t1);



                    }
                }
            });

            t1.start();
            t2.start();
            t3.start();
            Thread.sleep(1000);
            System.out.println("________________");
        }
    }
}
