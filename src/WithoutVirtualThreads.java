import java.util.concurrent.Executors;

import java.util.concurrent.*;

public class WithoutVirtualThreads {

    public static void main(String[] args) throws Exception {

        int totalOrders = 1_000_000;
        //ExecutorService executor = Executors.newFixedThreadPool(200);
       ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        OrderService service = new OrderService();
        long start = System.currentTimeMillis();
        CountDownLatch latch = new CountDownLatch(totalOrders);
        for (int i = 0; i < totalOrders; i++) {
            int id = i;
            executor.submit(() -> {
                service.processOrder(new Order(id, "Pizza"));
                latch.countDown();
            });
        }
        latch.await();
        executor.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("WITHOUT Virtual Threads Time: " + (end - start));
    }
}
class OrderService {
    public String processOrder(Order order) {
   //     validate(order);
   //     processPayment(order);
        saveToDB(order);
        return "SUCCESS";
    }

    private void validate(Order order) {
        sleep(5); // simulate validation
    }

    private void processPayment(Order order) {
        sleep(10); // simulate external API call
    }

    private void saveToDB(Order order) {
        sleep(20); // simulate DB write
    }

    private void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) {}
    }
}
class Order {
    int id;
    String item;

    Order(int id, String item) {
        this.id = id;
        this.item = item;
    }
}