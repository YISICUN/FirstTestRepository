package Runnable;

public class RunnableMultiple implements Runnable {
    @Override
    public void run() {
        System.out.println("线程：" + Thread.currentThread().getName() + " 执行任务");
    }

    public static void main(String[] args) {
        System.out.println("✅ 2. 多个线程使用同一个 Runnable 对象");
        System.out.println("________________________________________________________________");
        RunnableMultiple runnable = new RunnableMultiple();

        Thread t1 = new Thread(runnable, "线程1");
        Thread t2 = new Thread(runnable, "线程2");
        t1.start();
        t2.start();
        System.out.println("________________________________________________________________");
    }
}
