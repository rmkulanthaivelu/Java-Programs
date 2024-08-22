import java.util.ArrayList;
import java.util.List;

public class ContigousSubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] a = {-1, -2, 3, 5, -7, 2, 9,-11};
        int sum = a[0];
        int index = 0;
      //int[] subArr = new int[2];
        List<int[]> listSubArr = new ArrayList<>();
        for(int i=1;i<=a.length-1;i++){
            int[] subArr = new int[2];
            sum = sum + a[i];
            System.out.println(sum);
            if(sum ==0) {
                subArr[0]= i;
                subArr[1]= i;
                listSubArr.add(subArr);
                index=0;
            }
            index++;
        }
        for(int[] i:listSubArr){
            System.out.println("Start Index:"+i[0]+":"+i[1]);
        }
      }
    }
