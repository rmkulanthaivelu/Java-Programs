
public class DeadLockFixed {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    public static void main(String[] args) {
        Runnable task = () -> {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " acquired lock1");
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName()
                            + " acquired lock2");
                }
            }
        };
        new Thread(task, "T1").start();
        new Thread(task, "T2").start();
    }
}