import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseSentenceWordByWord {
    public static void main(String[] args) {
        String sentence = "Java Concept Of The Day";

        // Step 1: Split sentence into words
        String[] words = sentence.split(" ");

        // Step 2: Convert array to list to use Collections.reverse
        List<String> wordList = Arrays.asList(words);
        Collections.reverse(wordList);

        // Step 3: Join the reversed words into a sentence
        String reversedSentence = String.join(" ", wordList);

        // Step 4: Print results
        System.out.println("Original Sentence: " + sentence);
        System.out.println("Reversed Sentence: " + reversedSentence);
    }
}