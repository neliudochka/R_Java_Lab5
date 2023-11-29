package entities;

import org.jetbrains.annotations.NotNull;

/**
 * Represents a punctuation mark used within text.
 */
public class PunctuationMark extends SentenceElement {

    // Set of known punctuation marks
    private static final String PUNCTUATION_MARKS = ".,;:!?-";

    /**
     * Gets an array containing all known punctuation marks.
     *
     * @return An array containing known punctuation marks as characters.
     */
    public static char[] getPUNCTUATION_MARKS() {
        return PUNCTUATION_MARKS.toCharArray();
    }

    //Actual punctuation mark as a character
    private final String punctuationMark;

    /**
     * Constructs a PunctuationMark object.
     *
     * @param p The string representing the punctuation mark.
     */
    public PunctuationMark(String p) {
        this.punctuationMark = p;
    }

    /**
     * Checks if the input string represents a punctuation mark.
     *
     * @param str The input string to check.
     * @return True if the input is a single character and is a known punctuation mark, false otherwise.
     */
    public static boolean isPunctuationMark(@NotNull String str) {
        return str.length() == 1 && PUNCTUATION_MARKS.contains(str);
    }

    /**
     * Returns the string representation of the punctuation mark.
     *
     * @return The string representation of the punctuation mark.
     */
    @Override
    public String toString() {
        return punctuationMark;
    }
}
