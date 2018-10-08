package thread;

public class MyThread  implements Runnable{
//    private int i = 0;
    @Override
    public void run() {
        for (int i=0;i<10;i++) {
            i++;
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
