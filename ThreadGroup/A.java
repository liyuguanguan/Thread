package thread.ThreadGroup;

import thread.MyThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class A {
    private static int aaa = 1024 * 1024;
    public static void main(String[] args) {
        byte[] a,b,c,d,f,e;
        a = new byte[2* 1024 * 1024];
        b = new byte[2* 1024 * 1024];
        c = new byte[1* 1024 * 1024];
        f = new byte[2* 1024 * 1024];
        d = new byte[9* aaa];

//        System.out.println(a.length);
//      ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(4,15,1,TimeUnit.MINUTES,new LinkedBlockingQueue(4),null,ThreadPoolExecutor.DiscardPolicy);
//        poolExecutor.prestartCoreThread();
//        System.out.println("核心线程数"+poolExecutor.getCorePoolSize());;
//        System.out.println("当前线程数"+poolExecutor.getPoolSize());;
//        poolExecutor.execute(new MyThread());
//      poolExecutor.execute(new MyThread());
//      poolExecutor.execute(new MyThread());
//      poolExecutor.execute(new MyThread());
//
//      poolExecutor.execute(new MyThread());
//      poolExecutor.execute(new MyThread());
//      poolExecutor.execute(new MyThread());
//      poolExecutor.execute(new MyThread());
//        System.out.println("当前线程数"+poolExecutor.getPoolSize());;
//      poolExecutor.execute(new MyThread());
//        poolExecutor.setCorePoolSize(8);
//      List a = new ArrayList();
//       while (true){
//         a.add("a");
//       }
    }
}
