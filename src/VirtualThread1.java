import java.util.HashMap;
import java.util.Map;

public class VirtualThread1 {
    public static void main(String args[]) {
        long start = System.currentTimeMillis();
        Map<String,Integer> map = new HashMap();
        for (int i = 0; i < 100000; i++) {
            map.put(""+i,i);
        }
            for (int i = 0; i < 100000; i++) {
            int k=i;
            Thread.ofVirtual().start(() ->
            {
               try {
                   int value = map.get(k);
                   map.put(""+k,value);
                   /* System.out.println("Hello-"+k);
                   Thread.sleep(1000);*/

                } catch (Exception e) {}
            });
        }
        long end = System.currentTimeMillis();
        long diff = end - start;
        long seconds = (diff / 1000) % 60;
        long minutes = (diff / (1000 * 60)) % 60;
        System.out.println("Time taken: " + minutes + " minutes " + seconds + " seconds");
    }

}
