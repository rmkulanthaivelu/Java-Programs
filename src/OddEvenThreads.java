public class OddEvenThreads {
    public static void main(String[] args) {

        NumberPrinter printer = new NumberPrinter(10);

        Thread oddThread = new Thread(() -> printer.printOdd(), "Odd Thread");
        Thread evenThread = new Thread(() -> printer.printEven(), "Even Thread");

        oddThread.start();
        evenThread.start();
    }
}

class NumberPrinter {

    private int number = 1;
    private final int limit;

    public NumberPrinter(int limit) {
        this.limit = limit;
    }

    public synchronized void printOdd() {
        while (number <= limit) {
            if (number % 2 == 0) {
                try { wait(); } catch (InterruptedException e) { }
            } else {
                System.out.println(Thread.currentThread().getName() + " : " + number++);
                notify();
            }
        }
    }

    public synchronized void printEven() {
        while (number <= limit) {
            if (number % 2 != 0) {
                try { wait(); } catch (InterruptedException e) { }
            } else {
                System.out.println(Thread.currentThread().getName() + " : " + number++);
                notify();
            }
        }
    }
}