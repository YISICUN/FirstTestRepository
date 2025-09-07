package Runnable;

public class RunnableCounter implements Runnable {
    private int count;

    public RunnableCounter(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= count; i++) {
            System.out.println(Thread.currentThread().getName() + " 计数：" + i);
            try {
                Thread.sleep(200); // 模拟耗时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnableCounter(5), "计数器线程");
        t1.start();
    }
}
