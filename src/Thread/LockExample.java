package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    static int counter = 0;
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        System.out.println("________________________________________________________________");
        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "准备加锁");
                lock.lock(); // 加锁
                System.out.println(Thread.currentThread().getName() + "加锁" + (i + 1) + "合计:" + counter);

                try {
                    counter++;
                    System.out.println(Thread.currentThread().getName() + "加一" + (i + 1) + "合计:" + counter);

                } finally {
                    System.out.println(Thread.currentThread().getName() + "准备解锁");
                    lock.unlock(); // 确保释放锁
                    System.out.println(Thread.currentThread().getName() + "解锁" + (i + 1) + "----------合计:" + counter);
                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("最终计数结果：" + counter);

        System.out.println("________________________________________________________________");

    }
}
