package entities;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SentenceTest {

    @Test
    public void testConstructor_InputSentenceElements_CreatesSentence() {
        SentenceElement[] elements = {new Word("Me"), new Word("wanna"),  new Word("die"), new PunctuationMark("!"), new Word("help"),};
        Sentence sentence = new Sentence(elements);
        assertNotNull(sentence.getSentence());
        assertEquals("Me wanna die ! help", sentence.toString());
    }

    @Test
    public void testConstructor_EmptySentenceElements_ThrowsException() {
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> new Sentence(new SentenceElement[0])
        );
        assertEquals("Can't create a sentence from empty sentence elements array", exception.getMessage());
    }

    @Test
    public void testConstructor_InputString_CreatesSentence() {
        Sentence sentence = new Sentence("Me - dead!!!");
        assertEquals("Me - dead ! ! !", sentence.toString());
    }

    @Test
    public void testConstructor_EmptyString_ThrowsException() {
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> new Sentence("")
        );
        assertEquals("Can't create a sentence from empty string", exception.getMessage());
    }

    @Test
    public void testToString() {
        SentenceElement[] elements = {new Word("what"), new PunctuationMark("?"), new Word("Help"), new PunctuationMark("!"), new PunctuationMark("!"),};
        Sentence sentence = new Sentence(elements);
        assertEquals("what ? Help ! !", sentence.toString());
    }
}
