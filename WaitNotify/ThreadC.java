package thread.WaitNotify;

public class ThreadC extends  Thread{


//    private Consumer consumer;
//
//    public ThreadC(Consumer consumer) {
//        this.consumer = consumer;
//    }

    @Override
    public void run (){
        while (true){
            String lock = new String("");
            Consumer consumer = new Consumer(lock);
            consumer.getValue();
        }
    }
}
