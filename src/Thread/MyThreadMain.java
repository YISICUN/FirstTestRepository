package Thread;

public class MyThreadMain {
    public static void main(String[] args) throws InterruptedException {

        // // ✅ 步骤 3：使用 Lambda 表达式简化 Runnable（Java 8+）
        // Thread thread = new Thread(() -> {
        // System.out.println("Lambda线程：" + Thread.currentThread().getName());
        // });
        // thread.start();
        // System.out.println("主线程：" + Thread.currentThread().getName());
        // System.out.println("________________________________________________________________");

        // // ✅ 步骤 5：线程优先级（setPriority()）
        // Thread t1 = new Thread(() -> System.out.println("低优先级线程"));
        // Thread t2 = new Thread(() -> System.out.println("高优先级线程"));
        // t1.setPriority(Thread.MIN_PRIORITY); // 最低1
        // t2.setPriority(Thread.MAX_PRIORITY); // 最高10

        // t1.start();
        // t2.start();

        // t2.join();
        // // t1.join();
        // System.out.println("________________________________________________________________");

        // ✅ 步骤 1：多线程共享资源的问题（未同步）
        // 示例：两个线程同时向一个计数器加数，结果可能出错
        // ✅ 步骤 2：使用 synchronized 实现线程安全
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                // counter++; // 非线程安全操作
                increment(); // 加锁后是线程安全的
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

    public static synchronized void increment() {
        counter++; // 非线程安全操作
    }

    static int counter = 0;

}
