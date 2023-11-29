package entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextTest {

    @Test
    public void testConstructor_InputSentences_CreatesText() {
        Sentence[] sentences = {
                new Sentence("This is sentence one."),
                new Sentence("aoaoaooa!!!"),
                new Sentence("me - asleep?")
        };
        Text text = new Text(sentences);
        assertNotNull(text.getText());
        assertEquals("This is sentence one . aoaoaooa ! ! ! me - asleep ?", text.toString());
    }

    @Test
    public void testConstructor_EmptySentences_ThrowsException() {
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> new Text(new Sentence[0])
        );
        assertEquals("Can't create a text from empty sentences array", exception.getMessage());
    }

    @Test
    public void testConstructor_InputString() {
        String str = "This is sentence one. Sentence two !! Sentence three?";
        Text text = new Text(str);
        assertNotNull(text.getText());
        assertEquals(3, text.getText().length);
        assertEquals("This is sentence one . Sentence two ! ! Sentence three ?", text.toString());
    }

    @Test
    public void testConstructor_InputStringWithoutClosingMark_CreatesText() {
        String str = "This is sentence one. Sentence two !! Sentence three";
        Text text = new Text(str);
        assertNotNull(text.getText());
        assertEquals(3, text.getText().length);
        assertEquals("This is sentence one . Sentence two ! ! Sentence three", text.toString());
    }

    @Test
    public void testConstructor_EmptyString_ThrowsException() {
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> new Text("")
        );
        assertEquals("Can't create a text from empty string", exception.getMessage());
    }

    @Test
    public void testToString() {
        Sentence[] sentences = {
                new Sentence("This is sentence one."),
                new Sentence("Sentence two!"),
                new Sentence("Sentence three?")
        };
        Text text = new Text(sentences);
        assertEquals("This is sentence one . Sentence two ! Sentence three ?", text.toString());
    }
}
