//Method to calculate sum of 'n' numbers

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MissingNumberInArray{

    public static int sumOfElements(int[] array){
        return Arrays.stream(array).sum();
    }

    public static void sumOfNumbersCollection(int[] array){
        TreeSet<Integer> setVal = new TreeSet<>(Arrays.stream(array).boxed().collect(Collectors.toList()));
        int i=1;
        System.out.println("setVal No:"+setVal);
        for(int iVal: setVal){
            if(i != iVal){
                System.out.println("Missing No:"+i);
                i++;
            }
            i++;
        }
    }
    public static void main(String[] args){
        int n = 8;
        int[] a = {1, 4, 5, 3, 7, 8, 6};
        int sumOfNnumbers = (n * (n+1))/ 2;
        int sumOfElements = sumOfElements(a);
        int missingNumber = sumOfNnumbers - sumOfElements;
        System.out.println("Missing Number is = "+missingNumber);
        int[] a1 = {1, 4, 5, 3, 7};
        sumOfNumbersCollection(a1);
    }
}