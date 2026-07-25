import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindMaximumOccurringCharacter {
    public static void main(String[] args)
    {
      //  printMaxOccurringChar("Java Concept Of The Day");
      //  System.out.println("========================");
      //  printMaxOccurringChar("Java J2ee Android Hibernate JSP");
      //  System.out.println("========================");
     //   printMaxOccurringChar("abbcccddddeeeeeffffff");
       // System.out.println("=========================");

        array();

    }
    public static void array(){

        int[][]  arr = {{1,3},{2,6},{8,10},{15,18}};
        // after interval --> [1,6],[8,10],[15,18];
        int j = 0;
        int start = 0;
        int end = 0;
        for(int i =0;i<arr.length;i++){
            start = arr[i][j];
            end = arr[i][j+1];
            System.out.println(start + ":"+end);
        }
        for(int i =0;i<arr.length;i++){
            // for(int j=0;j<arr.length;j++){
            if(start<=arr[i][j] && start<arr[i][j+1] ){
               // arr[i][j] = arr[i][j];
               // j=0;
            }else{
                arr[i][j] = arr[i][j+1];
            }
            if(end<=arr[i][j] && end<=arr[i][j+1]){
            //    arr[i][j] = arr[i][j];
                //j=0;
            }else{
                arr[i][j] = arr[i][j+1];
            }
            start = arr[i][j];
            end = arr[i][j+1];

            System.out.println(start + ":"+end);
           //j++;
         //  if(j==1) j=0;
            // }
        }
        int k =0;
       for(int i=0;i<arr.length;i++){
         //  for(int k=0;k<arr.length-1;k++){
              // System.out.print(arr[i][k+1] +" ");
           if(k==1) k=0;
          // }
       }
    }
    public static void printMaxOccurringChar(String str){
        char[] chars = str.toCharArray();
        Map.Entry<Character,Long> maxOccur =
                str.chars()
                .filter(c->c != ' ')
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);
        System.out.println(maxOccur);

        List<String> list1 = Arrays.asList("Java,Python,Microservice".split(" "));
        List<String> list2 = Arrays.asList("Java,Spring,Kafka".split(" "));
        list2.addAll(list1);




    }
}