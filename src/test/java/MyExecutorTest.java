import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyExecutorTest {
    //exec
    @Test
    public void exec_ValidInput_ReturnsFirstNonRepeatingWord() {
        StringBuilder text = new StringBuilder("This is a doggy! And one more doggy!");
        StringBuilder result = MyExecutor.exec(text);
        assertEquals("This", result.toString());

        text = new StringBuilder("la la la wot! And smth else! la.");
        result = MyExecutor.exec(text);
        assertEquals("wot", result.toString());
    }

    @Test
    public void exec_AllWordsAreSame_ReturnsEmptyString() {
        StringBuilder text = new StringBuilder("Everything is the same? Everything is the same!");
        StringBuilder result = MyExecutor.exec(text);
        assertEquals("", result.toString());
    }

    @Test
    public void exec_EmptyText_ThrowException() {
        StringBuilder text = new StringBuilder("");
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> MyExecutor.exec(text));

        String exceptionMessage = "Text is empty!";
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void exec_SecondSentenceIsEmpty_ReturnsEmptyStringBuilder() {
        StringBuilder text = new StringBuilder(".");
        StringBuilder result = MyExecutor.exec(text);
        assertEquals("", result.toString());
    }
}
