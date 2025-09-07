package Runnable;

public class RunnableSafe implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (this) {
                count++;
                System.out.println(Thread.currentThread().getName() + " count=" + count);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
        RunnableSafe runnable = new RunnableSafe();

        Thread t1 = new Thread(runnable, "线程1");
        Thread t2 = new Thread(runnable, "线程2");

        t1.start();
        t2.start();
    }
}
