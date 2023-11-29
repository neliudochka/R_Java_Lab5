package entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PunctuationMarkTest {

    @Test
    public void testGetPunctuationMarks() {
        char[] expectedPunctuationMarks = {'.', ',', ';', ':', '!', '?', '-'};
        assertArrayEquals(expectedPunctuationMarks, PunctuationMark.getPUNCTUATION_MARKS());
    }

    @Test
    public void testIsPunctuationMark_Valid() {
        assertTrue(PunctuationMark.isPunctuationMark("."));
        assertTrue(PunctuationMark.isPunctuationMark(","));
        assertTrue(PunctuationMark.isPunctuationMark(";"));
        assertTrue(PunctuationMark.isPunctuationMark(":"));
        assertTrue(PunctuationMark.isPunctuationMark("!"));
        assertTrue(PunctuationMark.isPunctuationMark("?"));
        assertTrue(PunctuationMark.isPunctuationMark("-"));
    }

    @Test
    public void testIsPunctuationMark_Invalid() {
        assertFalse(PunctuationMark.isPunctuationMark("a"));
        assertFalse(PunctuationMark.isPunctuationMark(""));
        assertFalse(PunctuationMark.isPunctuationMark("!?"));
        assertFalse(PunctuationMark.isPunctuationMark(" "));
        assertFalse(PunctuationMark.isPunctuationMark("_"));
    }

    @Test
    public void testToString() {
        PunctuationMark punctuationMark = new PunctuationMark("!");
        assertEquals("!", punctuationMark.toString());
    }
}
