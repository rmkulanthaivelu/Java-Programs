
import java.util.concurrent.*;
        import java.net.http.*;
        import java.net.URI;

public class LoadTest {

    public static void main(String[] args) throws Exception {
        int totalRequests = 1_000_000;
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        HttpClient client = HttpClient.newHttpClient();
        long start = System.currentTimeMillis();
        CountDownLatch latch = new CountDownLatch(totalRequests);
        for (int i = 0; i < totalRequests; i++) {
            System.out.println("Before Submit");
            executor.submit(() -> {
                try {
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create("http://localhost:8080/orders"))
                            .header("Content-Type", "application/json")
                            .POST(HttpRequest.BodyPublishers.ofString("""
                        {
                          "id": 1,
                          "item": "Pizza",
                          "amount": 200
                        }
                        """))
                            .build();

                    client.send(request, HttpResponse.BodyHandlers.ofString());
                } catch (Exception e) {}
                latch.countDown();
            });
        }
        latch.await();
        long end = System.currentTimeMillis();
        long diff = end - start;
        long seconds = (diff / 1000) % 60;
        long minutes = (diff / (1000 * 60)) % 60;
        System.out.println("Time taken: " + minutes + " minutes " + seconds + " seconds");
    }
}