package thread.join;


public class main  extends  Thread{


    @Override
    public  void  run (){

        try {

            System.out.println("hahah");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        main main = new main();
        main.start();
        try {
            main.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a");

    }
}
