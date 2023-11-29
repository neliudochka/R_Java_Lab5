package entities;

import org.jetbrains.annotations.NotNull;

/**
 * Represents a single letter.
 */
public class Letter {
    //actual character of letter
    private final Character letter;

    /**
     * Constructs a Letter object from a single character string.
     *
     * @param l The string representing the letter.
     * @throws RuntimeException If the input string is empty or contains more than one character.
     */
    public Letter(@NotNull String l) {
        if (l.isEmpty())
            throw new RuntimeException("Can't create a letter from empty string");
        if (l.length() > 1)
            throw new RuntimeException("Can't create a letter from more than one character");
        this.letter = l.charAt(0);
    }

    /**
     * Letter representation as a string.
     *
     * @return The string representation of the letter.
     */
    @Override
    public String toString() {
        return letter.toString();
    }
}
