package thread.WaitNotify;

public class ThreadP extends Thread{

//    private Produce produce;

//    public ThreadP(Produce produce) {
//        this.produce = produce;
//    }

    @Override
    public void run (){
        while (true){
            String lock = new String("1");
            Produce produce = new Produce(lock);
            produce.setValue();
        }
    }
}
