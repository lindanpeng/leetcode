import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class Test {
    static ReentrantLock lock=new ReentrantLock();
    static Condition condition =lock.newCondition();
    static Semaphore metux=new Semaphore(1);
    static Semaphore a=new Semaphore(1);
    static Semaphore b=new Semaphore(0);
    static  volatile  boolean  flag=true;
    static volatile int id=0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(new MyThreadB()).start();
        new Thread(new MyThreadA()).start();



    }

}
class MyThreadA implements Runnable{

    @Override
    public void run() {
        while (true){
            Test.lock.lock();
            try {
                Test.condition.signal();
               Thread.sleep(1000);
                System.out.println("Thread A");
                System.out.println(Test.id++);
                Test.condition.await();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                //Test.lock.unlock();
            }

        }
    }
}
class MyThreadB implements Runnable{

    @Override
    public void run() {
        while (true){
            Test.lock.lock();
            try {
                Test.condition.signal();
                Thread.sleep(1000);
                System.out.println("Thread B");
                System.out.println(Test.id++);
                Test.condition.await();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                //Test.lock.unlock();
            }

        }
    }
}
//class MyThreadA implements Runnable{
//    @Override
//    public void run() {
//        try {
//            while (true) {
//                Test.a.acquire();
//                Test.metux.acquire();
//                Thread.sleep(1000);
//                System.out.println("Thread 1");
//                System.out.println(Test.id++);
//                Test.metux.release();
//                Test.b.release();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}
//class MyThreadB implements  Runnable{
//
//    @Override
//    public void run() {
//        try {
//            while (true) {
//                Test.b.acquire();
//                Test.metux.acquire();
//                Thread.sleep(1000);
//                System.out.println("Thread 2");
//                System.out.println(Test.id++);
//                Test.metux.release();
//                Test.a.release();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
//}