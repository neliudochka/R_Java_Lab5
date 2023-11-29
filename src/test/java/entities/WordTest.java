package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordTest {

    @Test
    public void testConstructor_LetterArrayInput_CreatesWord() {
        Letter[] letters = {new Letter("H"),
                new Letter("e"),
                new Letter("l"),
                new Letter("p")
        };

        Word word = new Word(letters);
        assertEquals("Help", word.toString());
    }

    @Test
    public void testConstructor_EmptyLettersArray_ThrowsException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> new Word(new Letter[]{}));
        assertEquals("Can't create a word from empty array of letters", exception.getMessage());
    }

    @Test
    public void testConstructor_StringInput_CreatesWord() {
        Word word = new Word("Help");
        assertEquals("Help", word.toString());
    }

    @Test
    public void testConstructor_EmptyString_ThrowsException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> new Word(""));
        assertEquals("Can't create a word from empty string", exception.getMessage());
    }


}
