package Runnable;

public class RunnableWithParam implements Runnable {

    private String taskName;

    public RunnableWithParam(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(taskName + " 由线程 " + Thread.currentThread().getName() + " 执行");
    }

    public static void main(String[] args) {
        System.out.println("✅ 3. 带参数的 Runnable（用构造函数传入参数）");
        System.out.println("________________________________________________________________");

        Thread t1 = new Thread(new RunnableWithParam("任务A"));
        Thread t2 = new Thread(new RunnableWithParam("任务B"));

        t1.start();
        t2.start();
        System.out.println("________________________________________________________________");

    }
}
