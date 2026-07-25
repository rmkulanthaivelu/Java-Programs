import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CamsProg {
    public static void main(String args[]){
        int[] arr = {2, 7, 4, 5};
        int target = 9;
        int[] arr1 = twoSum(arr,  target);
        System.out.println(Arrays.toString(arr1));

        // Find Duplicates
        int[] findDup = {1,2,3,2,4,5,3};
        Arrays.stream(findDup).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue()>1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

        int[] arrMissing = {1,2,3,5};
        int n = 5;
        int actualSum = Arrays.stream(arrMissing).sum();
        int expected = IntStream.rangeClosed(1,n).sum();
        System.out.println("Missing No:"+(expected-actualSum));

        int[] SecondLargest = {10,20,30,40,50};
        int largest = Arrays.stream(SecondLargest).boxed().sorted(Comparator.reverseOrder())
                .skip(2).findFirst().get();
        System.out.println("Third Highest:"+largest);
        int max = Arrays.stream(SecondLargest).max().getAsInt();
        System.out.println("Max:"+max);
        int min = Arrays.stream(SecondLargest).min().getAsInt();
        System.out.println("min:"+min);

        System.out.println("Sum of Array:"+Arrays.stream(SecondLargest).sum());
        System.out.println("Average of Array:"+Arrays.stream(SecondLargest).average().getAsDouble());
        int[] arrayEven = {3,5,8,9,2,8,4};
        long count = Arrays.stream(arrayEven).boxed().filter(n1->n1 % 2 !=0)
                .count();
        System.out.println("Cound of Even:"+count);



        Map<Boolean, List<Integer>> oddAndEven = Arrays.stream(arrayEven).boxed()
                .collect(Collectors.partitioningBy(n1->n1 % 2 ==0));

        Arrays.stream(arr).boxed()
                .sorted()
                .forEach(System.out::println);

        List<Integer> list =
                Arrays.stream(arr)
                        .boxed()
                        .toList();

        Integer result =
                list.stream()
                        .filter(e ->
                                Collections.frequency(list,e)==1)
                        .findFirst()
                        .orElse(null);
        System.out.println("First Non Repeated Char:"+result);

        //Frequency of Each Element
        Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting())).forEach((e2,e3)->System.out.println(e2+":"+e3));

        int[] mergeArray = IntStream.concat(Arrays.stream(arr),Arrays.stream(arrayEven)).toArray();
        System.out.println(Arrays.toString(mergeArray));


        //Reverse Array
        int[] Reverse = {3,5,8,9,2,8,4};
        IntStream.rangeClosed(1,Reverse.length)
                .map(i -> Reverse[Reverse.length-i])
                .forEach(System.out::println);

        //Largest Word in String
        String str="Java Stream API Interview";
        String iVal = Arrays.stream(str.split(" ")).max(Comparator.comparing(String::length))
                .orElse(null);
        System.out.println   (iVal);
        //First Repeated Character

        Set<Character> set = new LinkedHashSet<>();
        String stringVal = "welcome";
        Character ch = stringVal.chars()
                        .mapToObj(c -> (char)c)
                        .filter(c -> !set.add(c))
                        .findFirst()
                        .orElse(null);
        System.out.println("First Repeated Char"+ch+":"+set);
        //Check Polindrame
        String[] Polindrame={"MADAM","AMMA","DADY","RACECAR"};
       List<String> polyList =
                Arrays.stream(Polindrame).filter(word->new StringBuffer(word).reverse().toString().equals(word))
                        .max(Comparator.comparing(String::length)).stream().toList();
        System.out.println(polyList);


    }
    public static int[] twoSum(int[] arr, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            int diff = target-arr[i];
            System.out.println(arr[i] + ":"+target+":"+diff);
            if(map.containsKey(diff))
                return new int[]{map.get(diff),i};
            map.put(arr[i],i);
            System.out.println(arr[i] + ":"+i);
        }
        return arr;
    }
}
