package thread.WaitNotify;

public class Consumer {

    private String lock;

    public Consumer(String lock) {
        this.lock = lock;
    }

    public void getValue(){
        synchronized (lock){

                try {
                    if (valueObject.value.equals("")) {
                        lock.wait();
                    }
                    Thread.sleep(1000);
                    System.out.println("get的值是" +valueObject.value);
                    valueObject.value = "";
                    lock.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}
