import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PalindromeIterative {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("madam","apple","racecar");
        List<String> isPalindrome = polindrome(list);
        System.out.println(isPalindrome);

        int[] arr = {3,5,2,0,2,0,9};
        int index = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] !=0){
                arr[index++] = arr[i];
            }
        }
        while(index<arr.length){
            arr[index++] = 0;
        }
        System.out.println(Arrays.toString(arr));

    }
    public static List<String>  polindrome( List<String> list ){
        List<String> isPalindrome = list.stream()
                .filter(word->new StringBuffer(word)
                        .reverse().toString().equals(word))
                .collect(Collectors.toList());
                return isPalindrome;
    }

}