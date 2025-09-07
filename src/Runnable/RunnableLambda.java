package Runnable;

public class RunnableLambda {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("线程 " + Thread.currentThread().getName() + " 使用 Lambda 执行");
        };

        Thread thread = new Thread(task);
        thread.start();

    }
}
