package thread.ReentrantLock;
 
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 线程一对一交替打印
 * @ClassName: OneToOnePrint  
 * @Description:
 * @author freeflying
 * @date 2018年8月20日
 */
public class OneToOnePrint {
	public static void main(String[] args) {
		OneToOnePrintEx onePrintEx=new OneToOnePrintEx();
		OneToOnePrintThreadA threadA = new OneToOnePrintThreadA(onePrintEx);
		threadA.start();
		OneToOnePrintThreadB threadB=new OneToOnePrintThreadB(onePrintEx);
		threadB.start();
	}
}
class OneToOnePrintEx{
	private ReentrantLock lock=new ReentrantLock();
	private Condition condition=lock.newCondition();
	private boolean hasValue=false;
	public void set() {
		try {
			lock.lock();
			while(hasValue==true) {
				condition.await();
			}
			System.out.println("*");
			hasValue=true;
			condition.signal();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
	}
	public void get() {
		try {
			lock.lock();
			while(hasValue==false) {
				condition.await();
			}
			System.out.println("-");
			hasValue=false;
			condition.signal();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
	}
}
class OneToOnePrintThreadA extends Thread{
	private OneToOnePrintEx printEx;
 
	public OneToOnePrintThreadA(OneToOnePrintEx printEx) {
		super();
		this.printEx = printEx;
	}
	@Override
	public void run() {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			printEx.set();
		}
	}
}
class OneToOnePrintThreadB extends Thread{
	private OneToOnePrintEx printEx;
 
	public OneToOnePrintThreadB(OneToOnePrintEx printEx) {
		super();
		this.printEx = printEx;
	}
	@Override
	public void run() {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			printEx.get();
		}
	}
}
