import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));      // 3
        System.out.println(romanToInt("LVIII"));    // 58
        System.out.println(romanToInt("MCMXCIV"));  // 1994

    }
    public static int romanToInt(String strInput){
        Map<Character,Integer> romanInt = new HashMap<>();
        romanInt.put('I',1);
        romanInt.put('V',5);
        romanInt.put('X',10);
        romanInt.put('L',50);
        romanInt.put('C',100);
        romanInt.put('D',500);
        romanInt.put('M',1000);
        int total = 0;
        for(int i=0;i<strInput.length();i++){
            int inVal = romanInt.get(strInput.charAt(i));
            // Check next value
            if (i <strInput.length()-1  && inVal < romanInt.get(strInput.charAt(i + 1))) {
                total -= inVal;  // subtract case
            } else {
                total += inVal;  // normal add
            }

        }
        return total;

    }
}


