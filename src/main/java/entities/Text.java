package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Represents a collection of sentences forming a text.
 */
public class Text {
    private final Sentence[] text;

    /**
     * Constructs a Text object from an array of sentences.
     * @param sentences An array of sentences.
     * @throws RuntimeException if the sentences array is empty.
     */
    public Text(Sentence[] sentences) {
        if(sentences.length == 0)
            throw new RuntimeException("Can't create a text from empty sentences array");
        this.text = sentences;
    }

    /**
     * Retrieves the array of sentences from the Text object.
     * @return An array of sentences.
     */
    public Sentence[] getText() {
        return text;
    }

    /**
     * Constructs a Text object from a string by parsing sentences.
     * @param str The string representing the text.
     * @throws RuntimeException if the input string is empty.
     */
    public Text(String str) {
        if(str.isEmpty())
            throw new RuntimeException("Can't create a text from empty string");
        Pattern pattern = Pattern.compile(".*?[!?.]+|.*$");
        Matcher matcher = pattern.matcher(str);

        List<String> sentences = new ArrayList<>();
        while (matcher.find()) {
            sentences.add(matcher.group());
        }

        //System.out.println(sentences);
        sentences.removeIf(String::isEmpty);
        this.text = sentences.stream()
                .map(Sentence::new)
                .toArray(Sentence[]::new);
    }

    /**
     * Returns a string representation of the Text object.
     * @return A string representing the text composed of sentences.
     */
    @Override
    public String toString() {
        return Arrays
                .stream(text)
                .map(Sentence::toString)
                .collect(Collectors.joining(" "));
    }
}
