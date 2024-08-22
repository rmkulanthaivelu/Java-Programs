import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayElementCountExample {

    public static void main(String[] args){
        arrayElementCount1(new int[]{4, 5, 4, 5, 4, 6});
        System.out.println("-------------------------");
        arrayElementCount2(new int[]{12, 9, 12, 9, 10, 9, 10, 11});
        System.out.println("-------------------------");
       // arrayElementCount3(new int[]{891, 187, 891, 187, 891, 476, 555, 741});
    }
    public static void arrayElementCount1(int[] intArr){
        List<Integer> list = Arrays.stream(intArr).boxed().collect(Collectors.toList());
        List<Map.Entry<Integer,Long>> map = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().sorted(Collections.reverseOrder(Comparator.comparing(Map.Entry::getValue)))
                .collect(Collectors.toList());
        for(Map.Entry<Integer,Long> mapVal: map){
           int key =  mapVal.getKey();
           long value =  mapVal.getValue();
           for(int i=0;i<value;i++)
               System.out.print(key + " ");

        }
        System.out.println(map);
    }
    public static void arrayElementCount2(int[] intArr){
        Map<Integer,Integer> map = new HashMap();
        for(int i:intArr){
            if(map.get(i)==null)
                map.put(i,1);
            else
                map.put(i,map.get(i)+1);
        }
        for(Map.Entry<Integer,Integer> mapVal: map.entrySet()){
            int key =  mapVal.getKey();
            long value =  mapVal.getValue();
            for(int i=0;i<value;i++)
                System.out.print(key + " ");

        }
        System.out.println(map);
    }


}
