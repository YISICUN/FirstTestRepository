package Thread;

public class VolatileExample {
    static volatile boolean running = true;

    public static void main(String[] args) {

        System.out.println("________________________________________________________________");

        Thread thread = new Thread(() -> {
            while (running) {
                // busy-wait
            }
            System.out.println("线程停止了！");
        });

        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        running = false; // 修改了 volatile 变量，线程能感知到变化
        System.out.println("// 修改了 volatile 变量，线程能感知到变化");
        System.out.println("________________________________________________________________");

    }
}
