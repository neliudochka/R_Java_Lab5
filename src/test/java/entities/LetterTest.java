package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LetterTest {
    @Test
    public void testConstructor_ValidInput_CreatesLetter() {
        Letter letter = new Letter("A");
        assertEquals("A", letter.toString());
    }

    @Test
    public void testConstructor_EmptyString_ThrowsException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> new Letter(""));
        assertEquals("Can't create a letter from empty string", exception.getMessage());
    }

    @Test
    public void testConstructor_MoreThanOneCharacterInput_ThrowsException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> new Letter("nd"));
        assertEquals("Can't create a letter from more than one character", exception.getMessage());
    }

    @Test
    public void testToString() {
        Letter letter = new Letter("x");
        assertEquals("x", letter.toString());
    }
}