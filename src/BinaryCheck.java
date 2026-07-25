import java.util.List;
import java.util.stream.Collectors;

public class BinaryCheck {

    public static void main(String[] args) {
        int number = 101101;
        boolean isBinary = true;
        while (number > 0) {
            int digit = number % 10;
            if (digit != 0 && digit != 1) {
                isBinary = false;
                break;
            }
            number /= 10;
        }
        System.out.println(isBinary);

        String str = "Welc@ome^1 Helo*";
       String list = str.chars().filter(c->Character.isLetter(c) || Character.isWhitespace(c))
                .mapToObj(ch->String.valueOf((char)ch))
               .collect(Collectors.joining());
       System.out.println(list);
    }
}