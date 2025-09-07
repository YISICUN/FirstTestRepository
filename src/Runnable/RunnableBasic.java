package Runnable;

public class RunnableBasic implements Runnable {
    @Override
    public void run() {
        System.out.println("线程执行中，线程名：" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("✅ 1. 实现 Runnable 创建线程（最基础）");
        System.out.println("________________________________________________________________");
        RunnableBasic runnable = new RunnableBasic();
        Thread thread = new Thread(runnable);
        thread.start(); // 启动线程

        Thread thread2 = new Thread(new RunnableBasic());
        thread2.start();
        System.out.println("________________________________________________________________");
    }
}
