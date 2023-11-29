package entities;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Represents a word composed of Letter objects.
 */
public class Word extends SentenceElement {
    private final Letter[] word;

    /**
     * Constructs a Word object from an array of Letter objects.
     *
     * @param letters The array of Letter objects to construct the word.
     * @throws RuntimeException If the array of letters is empty.
     */
    public Word(@NotNull Letter[] letters) {
        if (letters.length == 0)
            throw new RuntimeException("Can't create a word from empty array of letters");
        this.word = letters;
    }

    /**
     * Constructs a Word object from a string.
     *
     * @param s The string used to create the word.
     * @throws RuntimeException If the input string is empty.
     */
    public Word(@NotNull String s) {
        if (s.isEmpty())
            throw new RuntimeException("Can't create a word from empty string");
        this.word = Arrays
                .stream(s.split(""))
                .map(Letter::new)
                .toArray(Letter[]::new);
    }

    /**
     * Retrieves the concatenated string representation of the Word object.
     *
     * @return The concatenated string representation of the Word.
     */
    @Override
    public String toString() {
        return Arrays
                .stream(word)
                .map(Letter::toString)
                .collect(Collectors.joining());
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj The reference object with which to compare.
     * @return True if this object is the same came type and has the same value; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        //System.out.println("equals: " + obj.toString() + " " + this.toString());
        return this.toString().equals(obj.toString());
    }
}
