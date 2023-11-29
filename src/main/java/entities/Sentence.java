package entities;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a sentence composed of SentenceElement objects.
 */
public class Sentence {
    private final SentenceElement[] sentence;

    /**
     * Constructs a Sentence object from an array of SentenceElement objects.
     *
     * @param sentenceElements The array of SentenceElement (Words and PunctuationMarks) objects representing the sentence.
     * @throws RuntimeException If the array of SentenceElement objects is empty.
     */
    public Sentence(SentenceElement @NotNull [] sentenceElements) {
        if (sentenceElements.length == 0)
            throw new RuntimeException("Can't create a sentence from empty sentence elements array");
        this.sentence = sentenceElements;
    }

    /**
     * Constructs a Sentence object from a string representing sentence elements.
     *
     * @param line The string containing sentence.
     * @throws RuntimeException If the input string is empty.
     */
    public Sentence(@NotNull String line) {
        if (line.isEmpty())
            throw new RuntimeException("Can't create a sentence from empty string");

        List<SentenceElement> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for(char c: line.toCharArray()) {
            if(String.valueOf(c).equals(" ")) {
                if(!word.isEmpty()) {
                    words.add(new Word(word.toString()));
                    word = new StringBuilder("");
                }
                            }
            else if (PunctuationMark.isPunctuationMark(String.valueOf(c))){
                if(!word.isEmpty()) {
                    words.add(new Word(word.toString()));
                    word = new StringBuilder("");
                }
                words.add(new PunctuationMark(String.valueOf(c)));

            } else {
                word.append(c);
            }
        }

        if(!word.isEmpty()) words.add(new Word(word.toString()));

        this.sentence = words.toArray(new SentenceElement[0]);
    }


    /**
     * Retrieves the array of SentenceElement objects representing the sentence.
     *
     * @return An array of SentenceElement objects representing the sentence.
     */
    public SentenceElement[] getSentence() {
        return sentence;
    }


    /**
     * Retrieves the string representation of the sentence by concatenating its elements.
     *
     * @return A string representation of the sentence by joining its elements with spaces.
     */
    @Override
    public String toString() {
        return Arrays
                .stream(sentence)
                .map(SentenceElement::toString)
                .collect(Collectors.joining(" "));
    }
}
