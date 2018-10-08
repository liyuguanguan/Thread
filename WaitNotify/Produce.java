package thread.WaitNotify;

import sun.awt.SunHints;

public class Produce {

    private String lock;

    public Produce(String lock) {
        this.lock = lock;
    }
    public void setValue(){
            synchronized (lock){

                    try {
                        if (!valueObject.value.equals("")) {
                            lock.wait();
                        }
                        Thread.sleep(1000);
                        String value =System.currentTimeMillis()+"_" +System.nanoTime();
                        System.out.println("set的值是" +value);
                        valueObject.value = value;
                        lock.notify();

                } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
    }
}
