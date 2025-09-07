package Thread;

public class WaitNotifyExample {
    static final Object lock = new Object();
    static boolean hasData = false;

    public static void main(String[] args) {
        System.out.println("________________________________________________________________");
        Thread producer = new Thread(() -> {
            synchronized (lock) {
                System.out.println("生产者：准备生产数据...");
                hasData = true;
                lock.notify(); // 唤醒消费者
                System.out.println("生产者：数据已生产，通知消费者");
                try {
                    Thread.sleep(1000);
                    System.out.println("生产者：数据已生产，通知消费者2,结束.");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            synchronized (lock) {
                while (!hasData) {
                    try {
                        System.out.println("消费者：等待数据...");
                        lock.wait(); // 等待通知
                        System.out.println("消费者：收到数据，开始处理！--------1");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费者：收到数据，开始处理！");
            }
        });

        consumer.start(); // 先启动消费者（先等）
        try {
            Thread.sleep(100); // 等一下，让消费者先进入等待状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producer.start(); // 再启动生产者
        System.out.println("________________________________________________________________");

    }
}
