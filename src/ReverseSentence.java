import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseSentence {
    public static void main(String[] args) {
        String sentence = "Java Concept Of The Day";

        // Split sentence into words
        String[] words = sentence.split(" ");

        // Convert array to list for using Collections.reverse
        List<String> wordList = Arrays.asList(words);
        Collections.reverse(wordList);

        // Join words back to a sentence
        String reversedSentence = String.join(" ", wordList);

        System.out.println("Original Sentence: " + sentence);
        System.out.println("Reversed Sentence: " + reversedSentence);
    }
}