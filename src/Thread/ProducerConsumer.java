package Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    private int data = 0; // 共享数据
    private boolean hasData = false; // 标记是否有数据可消费

    // 生产者线程调用的方法
    public void produce() throws InterruptedException {
        lock.lock();
        try {
            System.out.println("lock住,准备生产");
            while (hasData) { // 如果已有数据，等待消费者消费
                condition.await();
            }
            data++;
            System.out.println("生产者生产了数据: " + data);
            hasData = true;
            condition.signal(); // 通知消费者线程
        } finally {
            lock.unlock();
            System.out.println("解除lock----------生产");
        }
    }

    // 消费者线程调用的方法
    public void consume() throws InterruptedException {
        lock.lock();
        try {
            System.out.println("lock住,准备消费");
            while (!hasData) { // 如果没有数据，等待生产者生产
                condition.await();
            }
            System.out.println("消费者消费了数据: " + data);
            hasData = false;
            condition.signal(); // 通知生产者线程
        } finally {
            lock.unlock();
            System.out.println("解除lock----------消费");

        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        // 生产者线程
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    pc.produce();
                    Thread.sleep(500); // 模拟生产时间
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 消费者线程
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    pc.consume();
                    Thread.sleep(800); // 模拟消费时间
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        consumer.start();
        producer.start();
    }
}
