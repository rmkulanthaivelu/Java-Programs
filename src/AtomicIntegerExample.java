import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    public static void main(String args[]){
        AtomicInteger count = new AtomicInteger(0);
        ExecutorService service = Executors.newFixedThreadPool(10);
        for(int i=0;i<1000;i++){
             service.submit(() -> {
              System.out.println(Thread.currentThread().getName()+":"+ count.incrementAndGet());
            });
        }
        service.shutdown();
    }
}
