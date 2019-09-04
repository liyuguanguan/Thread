package thread.WaitNotify;

/**
 * 交叉打印工具类
 */
public class DBtools {

    volatile private boolean prit = false;

    synchronized public void methodA(){

        try {
            while (prit){
                wait();
            }
            System.out.println("✨");
            prit = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized  public void methodB(){

        try {
            while (!prit){
                wait();
            }
            prit = false;
            System.out.println("※");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
class MethedA extends  Thread{

    private DBtools dBtools;

    public MethedA(DBtools dBtools) {
        this.dBtools = dBtools;
    }

    @Override
    public void run(){
        dBtools.methodA();
    }


}

class MethedB extends  Thread{

    private DBtools dBtools;

    public MethedB(DBtools dBtools) {
        this.dBtools = dBtools;
    }

    @Override
    public void run(){
        dBtools.methodB();
    }


}

    class  mm {
    public static void main(String[] args) {
        DBtools dBtools = new DBtools();
//        for(int i=0; i<10;i++){
            MethedA A = new MethedA(dBtools);
            A.start();
            MethedB b = new MethedB(dBtools);
            b.start();
//        }
    }


}